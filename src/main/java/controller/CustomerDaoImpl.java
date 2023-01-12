package controller;

import DaoInterface.ConnectionDAO;
import DaoInterface.CustomerDao;
import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDaoImpl extends ConnectionDAO implements CustomerDao {
//    getCustomerById(int id) - Returns the customer object for the given id.
//            addCustomer(Customer c) - Adds a customer with given information.
//    removeCustomerById(int id) - Removes a customer with the given id.



    public void save(List<Customer> CustomerList) {
        try {
            Connection con = ConnectionDAO.getConnection();
            for(Customer b: CustomerList) {
                String sqlQuery = "INSERT INTO customer (fname,lname,email) VALUES (?,?,?)";
                PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
                prepStmt.setString(1,  b.getFirstName());
                prepStmt.setString(2, b.getLastName());
                prepStmt.setString(3, b.getEmail());
                int affectedRows = prepStmt.executeUpdate();
                System.out.println(affectedRows + " row(s) affected !!");
            }
        }
        catch (ClassNotFoundException e)
        {
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Customer> getAll() {
        try {
            Connection connection = ConnectionDAO.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
            List boollist = new ArrayList();
            while(rs.next())
            {
                Customer b = new Customer();
                b.setFirstName( rs.getString("fname") );
                b.setLastName( rs.getString("lName") );
                b.setEmail( rs.getString("email") );
                boollist.add(b);
            }
            return boollist;

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(Customer bookObj, int id){
        try {
            Connection connection = ConnectionDAO.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE customer SET fname=?, lname=?, email=? WHERE id=?");
            ps.setString(1, bookObj.getFirstName());
            ps.setString(2, bookObj.getLastName());
            ps.setInt(3, id);
            ps.setString(4, bookObj.getEmail());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return false;
    }



    public Customer getCustomerById(int id) {
        Customer b = new Customer();
        try {
        Connection connection = ConnectionDAO.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM customer where id = ?");

        while(rs.next())
        {

            b.setId(rs.getInt("id"));
            b.setFirstName( rs.getString("fname") );
            b.setLastName( rs.getString("lName") );
            b.setEmail( rs.getString("email") );

        }
      return b;

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }



    public boolean delete(int id) {
        try {
            Connection connection = ConnectionDAO.getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM customer WHERE id=?");
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException ex) {
            System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
        }
        return false;
    }
}




