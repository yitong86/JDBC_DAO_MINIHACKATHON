package DaoInterface;

import model.Customer;
import java.util.List;
import java.sql.SQLException;

public interface CustomerDao {
        /** This is the method to be used to list down all the records from the books table.*/
        List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException;

        /** This method to be used to create a record in the books table. */
        void saveCustomer(List<Customer> CustomerList);

        /** This is the method to be used to delete a record from the Student table corresponding to a passed books id. */
        boolean deleteCustomer(int id);

        /** This is the method to be used to update a record into the books table. */
        boolean updateCustomer(Customer customer, int id);

         List<Customer> getCustomerById(int id);



}
