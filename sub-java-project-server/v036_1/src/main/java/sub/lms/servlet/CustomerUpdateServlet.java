package sub.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sub.lms.dao.CustomerDao;
import sub.lms.domain.Customer;

public class CustomerUpdateServlet implements Servlet {

  CustomerDao customerDao;

  public CustomerUpdateServlet(CustomerDao customerDao) {
    this.customerDao = customerDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    Customer customer = (Customer) in.readObject();


    if (customerDao.update(customer) > 0) {
      out.writeUTF("OK");

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 번호의 회원이 없습니다.");
    }
  }
}
