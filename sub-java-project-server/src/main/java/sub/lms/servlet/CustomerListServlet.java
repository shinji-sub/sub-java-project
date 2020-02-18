package sub.lms.servlet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import sub.lms.domain.Customer;

public class CustomerListServlet implements Servlet {
  List<Customer> customers;

  public CustomerListServlet(List<Customer> customers) {
    this.customers = customers;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      out.writeUTF("OK");
      out.reset();
      out.writeObject(customers);

    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }

}
