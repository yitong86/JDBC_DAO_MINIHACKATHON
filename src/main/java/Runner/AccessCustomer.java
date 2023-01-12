package Runner;

import DaoInterface.CustomerDao;
import controller.CustomerDaoImpl;
import model.Customer;

import java.util.ArrayList;

public class AccessCustomer {
    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDaoImpl();
        System.out.println("--------- inserting customer records ----------");

        ArrayList<Customer> CustomerList1 = new ArrayList<Customer>();

        Customer c1 = new Customer();
        c1.setFirstName("lucy");
        c1.setLastName("JJ");
        c1.setEmail("aa@gmail.com");
        CustomerList1.add(c1);

        Customer c2 = new Customer();
        c2.setFirstName("apple");
        c2.setLastName("gg");
        c2.setEmail("gg@gmail.com");
        CustomerList1.add(c2);

        Customer c3 = new Customer();
        c3.setFirstName("jane");
        c3.setLastName("ooop");
        c3.setEmail("po0@gmail.com");
        CustomerList1.add(c3);



        customerDao.saveCustomer(CustomerList1);

    }
}
