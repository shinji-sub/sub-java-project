package sub.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sub.lms.dao.CustomerObjectFileDao;

public class CustomerListServlet implements Servlet {

  CustomerObjectFileDao customerDao;

  public CustomerListServlet(CustomerObjectFileDao customerDao) {
    this.customerDao = customerDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK");
    out.reset();
    out.writeObject(customerDao.findAll());

  }
}

