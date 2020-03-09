package sub.lms.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import sub.lms.dao.CustomerDao;
import sub.lms.domain.Customer;

public class CustomerSearchServlet implements Servlet{

  CustomerDao customerDao;

  public CustomerSearchServlet(CustomerDao customerDao) {
    this.customerDao = customerDao;
  }
  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("검색어? ");
    out.println("!{}!");
    out.flush();

    String keyword = in.nextLine();

    List<Customer> customers = customerDao.findByKeyword(keyword);
    for (Customer c : customers) {
      out.printf(
          "%d, %s, %s, %s, %s, %s, %s, %s, %s, %s\n",
          c.getNo(), c.getCartype(), c.getCarNumbel(), c.getPhoto(), c.getDiscountRatr(),
          c.getPayment(), c.getGyeoljeYuhyeong(), c.getParking(), c.getExitStatus(),
          c.getAcceptance());
    }
  }
}


