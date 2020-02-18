package sub.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import sub.lms.domain.Customer;

public class CustomerAddServlet implements Servlet {

  List<Customer> customers;

  public CustomerAddServlet(List<Customer> customers) {
    this.customers = customers;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    try {
      Customer customer = (Customer) in.readObject();

      int i = 0;
      for (; i < customers.size(); i++) {
        if (customers.get(i).getNo() == customer.getNo()) {
          break;
        }
      }

      if (i == customers.size()) {
        customers.add(customer);
        out.writeUTF("OK");

      } else {
        out.writeUTF("FAIL");
        out.writeUTF("같은 번호의 고객이 있습니다.");
      }
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }
}
