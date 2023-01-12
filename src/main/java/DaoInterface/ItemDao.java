package DaoInterface;

import model.Customer;
import model.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemDao {
    /** This is the method to be used to list down all the records from the books table.*/
    List<Item> getAllItems() throws ClassNotFoundException, SQLException;

    /** This method to be used to create a record in the books table. */
    void saveItem(List<Item> ItemList);

    /** This is the method to be used to delete a record from the Student table corresponding to a passed books id. */
    boolean deleteItem(int id);

    /** This is the method to be used to update a record into the books table. */
    boolean updateItem(Item item, int id);

    List<Item> removeItemById(int id);

}
