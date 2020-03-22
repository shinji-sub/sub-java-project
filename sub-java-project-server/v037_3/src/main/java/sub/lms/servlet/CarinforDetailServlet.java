package sub.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import sub.lms.dao.CarinforDao;
import sub.lms.domain.Carinfor;
import sub.util.Prompt;

public class CarinforDetailServlet implements Servlet {

  CarinforDao carinforDao;

  public CarinforDetailServlet(CarinforDao carinforDao) {
    this.carinforDao = carinforDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int no = Prompt.getInt(in, out, "번호? " );


    Carinfor carinfor = CarinforDao.findByNo(no);

    if (carinfor != null) {
      out.printf("번호: %d\n", carinfor.getNo());
      out.printf("차종: %s\n", carinfor.getCarType());
      out.printf("차량 번호: %s\n", carinfor.getCarNumber());
      out.printf("차량 위치: %s\n", carinfor.getParking());
      out.printf("차량 입차 날짜 : %s\n", carinfor.getDatas());
      out.printf("차량 출차 날짜: %s\n", carinfor.getDeparture());

    } else {
      out.println("해당 번호의 차량정보가 없습니다.");
    }
  }
}


