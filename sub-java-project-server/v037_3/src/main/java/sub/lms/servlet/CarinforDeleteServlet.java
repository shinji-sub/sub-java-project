package sub.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import sub.lms.dao.CarinforDao;
import sub.util.Prompt;

public class CarinforDeleteServlet implements Servlet {

  CarinforDao carinforDao;

  public CarinforDeleteServlet(CarinforDao carinforDao) {
    this.carinforDao = carinforDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int no = Prompt.getInt(in, out, "번호?");

    if (carinforDao.delete(no) > 0) {
      out.println("차량 정보를 삭제했습니다.");

    } else {
      out.println("해당 번호의 차량 정보가 없습니다.");
    }
  }
}


