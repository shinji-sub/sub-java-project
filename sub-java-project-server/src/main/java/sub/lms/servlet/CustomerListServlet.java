package sub.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sub.lms.dao.CustomerDao;

public class CustomerListServlet implements Servlet {

  CustomerDao customerDao;

  public CustomerListServlet(CustomerDao customerDao) {
    this.customerDao = customerDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK");
    out.reset();
    out.writeObject(customerDao.findAll());

  }
}

