package sub.lms.servlet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import sub.lms.domain.Carinfor;

public class CarinforAddServlet implements Servlet {

  List<Carinfor> carinfors;

  public CarinforAddServlet(List<Carinfor> carinfors) {
    this.carinfors = carinfors;
  }

  public void service(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      Carinfor carinfor = (Carinfor) in.readObject();

      int i = 0;
      for (; i < carinfors.size(); i++) {
        if (carinfors.get(i).getNo() == carinfor.getNo()) {
          break;
        }
      }

      if (i == carinfors.size()) {
        carinfors.add(carinfor);
        out.writeUTF("OK");

      } else {
        out.writeUTF("FAIL");
        out.writeUTF("같은 번호의 차량이 있습니다.");
      }

    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }
}
