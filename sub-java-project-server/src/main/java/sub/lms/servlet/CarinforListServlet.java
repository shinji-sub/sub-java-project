package sub.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sub.lms.dao.json.CarinforJsonFileDao;

public class CarinforListServlet implements Servlet {

  CarinforJsonFileDao carinforDao;

  public CarinforListServlet(CarinforJsonFileDao carinforDao) {
    this.carinforDao = carinforDao;
  }

  @Override
  public void service(ObjectInputStream In, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK");
    out.reset();
    out.writeObject(carinforDao.findAll());
  }
}

