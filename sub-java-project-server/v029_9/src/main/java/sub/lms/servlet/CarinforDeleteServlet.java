package sub.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sub.lms.dao.json.CarinforJsonFileDao;

public class CarinforDeleteServlet implements Servlet {

  CarinforJsonFileDao carinforDao;

  public CarinforDeleteServlet(CarinforJsonFileDao carinforDao) {
    this.carinforDao = carinforDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    int no = in.readInt();


    if (carinforDao.delete(no) > 0) {
      out.writeUTF("OK");

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 번호의 차량 정보가 없습니다.");
    }
  }
}


