package controller;

import DaoInterface.ConnectionDAO;
import DaoInterface.ItemDao;
import model.Customer;
import model.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl extends ConnectionDAO implements ItemDao {

    public void save(List<Item> ItemList) {
        try {
            Connection con = ConnectionDAO.getConnection();
            for(Item b: ItemList) {
                String sqlQuery = "INSERT INTO item (name,price) VALUES (?,?)";
                PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
                prepStmt.setString(1,  b.getName());
                prepStmt.setDouble(2, b.getPrice());

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

    public List<Item> getAll() {
        try {
            Connection connection = ConnectionDAO.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM item");
            List boollist = new ArrayList();
            while(rs.next())
            {
                Item b = new Item();
                b.setName( rs.getString("name") );
                b.setPrice(rs.getDouble("price"));


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

    public boolean update(Item bookObj, int id){
        try {
            Connection connection = ConnectionDAO.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE item SET name=?, price=?  WHERE id=?");
            ps.setString(1, bookObj.getName());

            ps.setDouble(2, bookObj.getPrice());
            ps.setInt(3, id);

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



    public boolean delete(int id) {
        try {
            Connection connection = ConnectionDAO.getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM item WHERE id=?");
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



