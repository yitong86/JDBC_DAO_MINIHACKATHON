package Runner;

import DaoInterface.CustomerDao;
import DaoInterface.ItemDao;
import controller.CustomerDaoImpl;
import controller.ItemDaoImpl;
import model.Customer;
import model.Item;

import java.util.ArrayList;

public class AccessItem {
    public static void main(String[] args) {
        ItemDao itemDao = new ItemDaoImpl();
        System.out.println("--------- inserting customer records ----------");

        ArrayList<Item> itemList1 = new ArrayList<Item>();


        Item item1 = new Item();
        item1.setName("pear");
        item1.setPrice(13);
        itemList1.add(item1);

        Item item2 = new Item();
        item2.setName("ope");
        item2.setPrice(9);
        itemList1.add(item2);

        itemDao.saveItem(itemList1);
    }
}
