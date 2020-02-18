package sub.lms.servlet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import sub.lms.domain.Customer;

public class CustomerUpdateServlet implements Servlet {
  List<Customer> customers;

  public CustomerUpdateServlet(List<Customer> customers) {
    this.customers = customers;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      Customer customer = (Customer) in.readObject();

      int index = -1;
      for (int i = 0; i < customers.size(); i++) {
        if (customers.get(i).getNo() == customer.getNo()) {
          index = i;
          break;
        }
      }

      if (index != -1) {
        customers.set(index, customer);
        out.writeUTF("OK");
      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 번호의 회원이 없습니다.");
      }
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }
}
