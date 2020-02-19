package sub.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sub.lms.dao.json.CarinforJsonFileDao;
import sub.lms.domain.Carinfor;

public class CarinforAddServlet implements Servlet {

  CarinforJsonFileDao carinforDao;

  public CarinforAddServlet(CarinforJsonFileDao carinforDao) {
    this.carinforDao = carinforDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    Carinfor carinfor = (Carinfor) in.readObject();


    if (carinforDao.insert(carinfor) > 0) {
      out.writeUTF("OK");

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("같은 번호의 차량이 있습니다.");
    }
  }
}
