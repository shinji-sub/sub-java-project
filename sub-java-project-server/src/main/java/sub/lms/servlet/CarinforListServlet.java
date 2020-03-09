package sub.lms.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import sub.lms.dao.CarinforDao;
import sub.lms.domain.Carinfor;

public class CarinforListServlet implements Servlet {

  CarinforDao carinforDao;

  public CarinforListServlet(CarinforDao carinforDao) {
    this.carinforDao = carinforDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    List<Carinfor> carinfor = carinforDao.findAll();
    for (Carinfor c : carinfor) {
      out.printf("%d, %s, %s, %s, %s, %s, %s\n", c.getNo(),c.getCarType(), c.getCarNumber(), c.getParking(), c.getDatas(), c.getDeparture(),c.getDeparture());
    }
  }
}

