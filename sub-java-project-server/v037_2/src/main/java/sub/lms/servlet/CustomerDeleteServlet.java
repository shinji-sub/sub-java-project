package sub.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import sub.lms.dao.CustomerDao;

public class CustomerDeleteServlet implements Servlet {

  CustomerDao customerDao;

  public CustomerDeleteServlet(CustomerDao customerDao) {
    this.customerDao = customerDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("번호? ");
    out.println("!{}!");
    out.flush();
    int no = Integer.parseInt(in.nextLine());



    if (customerDao.delete(no) > 0) {
      out.println("고객정보를 삭제했습니다");

    } else {
      out.println("해당 번호의 고객정보가 없습니다.");
    }
  }
}
