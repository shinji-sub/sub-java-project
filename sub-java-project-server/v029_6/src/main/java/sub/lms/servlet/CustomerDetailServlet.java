package sub.lms.servlet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import sub.lms.domain.Customer;

public class CustomerDetailServlet implements Servlet {
  List<Customer> customers;

  public CustomerDetailServlet(List<Customer> customers) {
    this.customers = customers;
  }

  public void service(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      int no = in.readInt();

      Customer customer = null;
      for (Customer m : customers) {
        if (m.getNo() == no) {
          customer = m;
          break;
        }
      }

      if (customer != null) {
        out.writeUTF("OK");
        out.writeObject(customer);

      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 번호의 고객정보가 없습니다.");
      }
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }

}
