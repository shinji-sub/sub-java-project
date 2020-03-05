package sub.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sub.lms.dao.CustomerDao;
import sub.lms.domain.Customer;

public class CustomerDetailServlet implements Servlet {
  CustomerDao customerDao;

  public CustomerDetailServlet(CustomerDao customerDao) {
    this.customerDao = customerDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    int no = in.readInt();

    Customer customer = customerDao.findByNo(no);

    if (customer != null) {
      out.writeUTF("OK");
      out.writeObject(customer);

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 번호의 고객정보가 없습니다.");
    }
  }
}

