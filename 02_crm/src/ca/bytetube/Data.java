package ca.bytetube;

import ca.bytetube.bean.Customer;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private static final List<Customer> list = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            list.add(new Customer("dal" + i, 20 + i, 1.0 + i));
        }
    }

    public static List<Customer> getCustomer() {
        return list;
    }

    public static void addCustomer(Customer customer){
        list.add(customer);
    }


}
