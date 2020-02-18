package sub.lms.servlet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import sub.lms.domain.Carinfor;

public class CarinforUpdateServlet implements Servlet {

  List<Carinfor> carinfors;

  public CarinforUpdateServlet(List<Carinfor> carinfors) {
    this.carinfors = carinfors;
  }

  public void service(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      Carinfor carinfor = (Carinfor) in.readObject();

      int index = -1;
      for (int i = 0; i < carinfors.size(); i++) {
        if (carinfors.get(i).getNo() == carinfor.getNo()) {
          index = i;
          break;
        }
      }

      if (index != -1) {
        carinfors.set(index, carinfor);
        out.writeUTF("OK");
      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 번호의 차량정보가 없습니다.");
      }

    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }

}
