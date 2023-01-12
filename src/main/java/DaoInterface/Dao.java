package DaoInterface;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    /** This is the method to be used to list down all the records from the books table.*/
    List<T> getAll() throws ClassNotFoundException, SQLException;

    /** This method to be used to create a record in the books table. */
    void save(List<T> t);

    /** This is the method to be used to delete a record from the Student table corresponding to a passed books id. */
    boolean delete(int id);

    /** This is the method to be used to update a record into the books table. */
    boolean update(T t, int id);





}
