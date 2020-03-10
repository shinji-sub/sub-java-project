package sub.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import sub.lms.dao.CarinforDao;

public class CarinforDeleteServlet implements Servlet {

  CarinforDao carinforDao;

  public CarinforDeleteServlet(CarinforDao carinforDao) {
    this.carinforDao = carinforDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("번호? ");
    out.println("!{}!");
    out.flush();
    int no = Integer.parseInt(in.nextLine());

    if (carinforDao.delete(no) > 0) {
      out.println("차량 정보를 삭제했습니다.");

    } else {
      out.println("해당 번호의 차량 정보가 없습니다.");
    }
  }
}


