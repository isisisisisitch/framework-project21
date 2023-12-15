package ca.bytetube.test;

import ca.bytetube.bean.Customer;
import ca.bytetube.dao.CustomerDao;
import org.junit.Test;

import java.util.List;

public class CustomerDaoTest {

    @Test
    public void testList() {
        CustomerDao dao = new CustomerDao();
        List<Customer> customers = dao.list();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
