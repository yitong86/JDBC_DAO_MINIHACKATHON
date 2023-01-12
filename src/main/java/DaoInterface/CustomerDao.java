package DaoInterface;

import model.Customer;
import java.util.List;
import java.sql.SQLException;

public interface CustomerDao extends Dao<Customer>{
    Customer getCustomerById(int id) throws SQLException;



}
