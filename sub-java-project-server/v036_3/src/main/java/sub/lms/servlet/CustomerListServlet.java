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
    for(Customer m : customer ) {
      out.printf(
          "%d, %s, %s, %s, %s, %s, %s, %s, %s, %s\n",
          m.getNo(), m.getCartype(), m.getCarNumbel(), m.getPhoto(), m.getDiscountRatr(),
          m.getPayment(), m.getGyeoljeYuhyeong(), m.getParking(), m.getExitStatus(),
          m.getAcceptance());
    }
  }
}
