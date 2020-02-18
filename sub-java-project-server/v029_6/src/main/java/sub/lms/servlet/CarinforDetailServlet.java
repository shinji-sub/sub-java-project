package sub.lms.servlet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import sub.lms.domain.Carinfor;

public class CarinforDetailServlet implements Servlet {

  List<Carinfor> carinfors;

  public CarinforDetailServlet(List<Carinfor> carinfors) {
    this.carinfors = carinfors;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      int no = in.readInt();

      Carinfor carinfor = null;
      for (Carinfor c : carinfors) {
        if (c.getNo() == no) {
          carinfor = c;
          break;
        }
      }

      if (carinfor != null) {
        out.writeUTF("OK");
        out.writeObject(carinfor);

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
