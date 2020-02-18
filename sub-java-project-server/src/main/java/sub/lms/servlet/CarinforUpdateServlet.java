package sub.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sub.lms.dao.CarinforObjectFileDao;
import sub.lms.domain.Carinfor;

public class CarinforUpdateServlet implements Servlet {

  CarinforObjectFileDao carinforDao;

  public CarinforUpdateServlet(CarinforObjectFileDao carinforDao) {
    this.carinforDao = carinforDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    Carinfor carinfor = (Carinfor) in.readObject();


    if (carinforDao.update(carinfor) > 0) {

      out.writeUTF("OK");
    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 번호의 차량정보가 없습니다.");
    }
  }
}

