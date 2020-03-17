package sub.lms.servlet;

import java.io.PrintStream;
import java.sql.Date;
import java.util.Scanner;
import sub.lms.dao.CarinforDao;
import sub.lms.domain.Carinfor;

public class CarinforAddServlet implements Servlet {

  CarinforDao carinforDao;

  public CarinforAddServlet(CarinforDao carinforDao) {
    this.carinforDao = carinforDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    Carinfor carinfor = new Carinfor();

    out.println("차종? ");
    out.println("!{}!");
    out.flush();
    carinfor.setCarType(in.nextLine());

    out.println("차량번호? ");
    out.println("!{}!");
    out.flush();
    carinfor.setCarNumber(in.nextLine());

    out.println("주차 위치? ");
    out.println("!{}!");
    out.flush();
    carinfor.setParking(in.nextLine());

    out.println("차량 입차 날짜? ");
    out.println("!{}!");
    out.flush();
    carinfor.setDatas(Date.valueOf(in.nextLine()));

    out.println("차량 출차 날짜? ");
    out.println("!{}!");
    out.flush();
    carinfor.setDeparture(Date.valueOf(in.nextLine()));

    if (carinforDao.insert(carinfor) > 0) {
      out.println("주차장 정보를 저장했습니다.");

    } else {
      out.println("저장에 실패했습니다.");
    }
  }
}
