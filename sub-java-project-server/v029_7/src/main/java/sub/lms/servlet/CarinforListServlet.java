package sub.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sub.lms.dao.CarinforObjectFileDao;

public class CarinforListServlet implements Servlet {

  CarinforObjectFileDao carinforDao;

  public CarinforListServlet(CarinforObjectFileDao carinforDao) {
    this.carinforDao = carinforDao;
  }

  @Override
  public void service(ObjectInputStream In, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK");
    out.reset();
    out.writeObject(carinforDao.findAll());
  }
}

