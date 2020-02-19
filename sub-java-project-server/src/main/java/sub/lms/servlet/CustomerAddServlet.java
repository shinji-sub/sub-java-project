package sub.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sub.lms.dao.json.CustomerJsonFileDao;
import sub.lms.domain.Customer;

public class CustomerAddServlet implements Servlet {

  CustomerJsonFileDao customerDao;

  public CustomerAddServlet(CustomerJsonFileDao customerDao) {
    this.customerDao = customerDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    Customer customer = (Customer) in.readObject();


    if (customerDao.insert(customer) > 0) {
      out.writeUTF("OK");

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("같은 번호의 고객이 있습니다.");
    }
  }
}
