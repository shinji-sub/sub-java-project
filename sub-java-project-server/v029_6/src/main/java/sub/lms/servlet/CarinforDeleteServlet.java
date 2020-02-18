package sub.lms.servlet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import sub.lms.domain.Carinfor;

public class CarinforDeleteServlet implements Servlet {

  List<Carinfor> carinfors;

  public CarinforDeleteServlet(List<Carinfor> carinfors) {
    this.carinfors = carinfors;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      int no = in.readInt();

      int index = -1;
      for (int i = 0; i < carinfors.size(); i++) {
        if (carinfors.get(i).getNo() == no) {
          index = i;
          break;
        }
      }

      if (index != -1) {
        carinfors.remove(index);
        out.writeUTF("OK");

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
