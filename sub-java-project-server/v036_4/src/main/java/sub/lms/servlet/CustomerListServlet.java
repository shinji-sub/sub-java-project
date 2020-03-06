package sub.lms.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import sub.lms.dao.CustomerDao;
import sub.lms.domain.Customer;

public class CustomerListServlet implements Servlet {

  CustomerDao customerDao;

  public CustomerListServlet(CustomerDao customerDao) {
    this.customerDao = customerDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    List<Customer> customer = customerDao.findAll();
    for(Customer c : customer ) {
      out.printf(
          "%d, %s, %s, %s, %s, %s, %s, %s, %s, %s\n",
          c.getNo(), c.getCartype(), c.getCarNumbel(), c.getPhoto(), c.getDiscountRatr(),
          c.getPayment(), c.getGyeoljeYuhyeong(), c.getParking(), c.getExitStatus(),
          c.getAcceptance());
    }
  }
}
