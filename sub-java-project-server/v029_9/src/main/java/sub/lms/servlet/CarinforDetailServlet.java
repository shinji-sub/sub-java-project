package sub.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sub.lms.dao.json.CarinforJsonFileDao;
import sub.lms.domain.Carinfor;

public class CarinforDetailServlet implements Servlet {

  CarinforJsonFileDao carinforDao;

  public CarinforDetailServlet(CarinforJsonFileDao carinforDao) {
    this.carinforDao = carinforDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    int no = in.readInt();

    Carinfor carinfor = carinforDao.findByNo(no);

    if (carinfor != null) {
      out.writeUTF("OK");
      out.writeObject(carinfor);

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 번호의 차량정보가 없습니다.");
    }
  }
}


