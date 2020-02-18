package sub.lms.servlet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import sub.lms.domain.Carinfor;

public class CarinforListServlet implements Servlet {

  List<Carinfor> carinfors;

  public CarinforListServlet(List<Carinfor> carinfors) {
    this.carinfors = carinfors;
  }

  @Override
  public void service(ObjectInputStream In, ObjectOutputStream out) throws IOException {
    try {
      out.writeUTF("OK");
      out.reset();
      out.writeObject(carinfors);
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }
}
