package sub.lms.servlet;

import java.io.PrintStream;
import java.sql.Date;
import java.util.Scanner;
import sub.lms.dao.CarinforDao;
import sub.lms.domain.Carinfor;

public class CarinforUpdateServlet implements Servlet {

  CarinforDao carinforDao;

  public CarinforUpdateServlet(CarinforDao carinforDao) {
    this.carinforDao = carinforDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("번호? ");
    out.println("!{}!");
    out.flush();
    int no = Integer.parseInt(in.nextLine());

    Carinfor old = CarinforDao.findByNo(no);

    if (old == null) {
      out.println("해당 번호의 주차차량 정보가 없습니다.");
      return;
    }

    Carinfor carinfor = new Carinfor();

    carinfor.setNo(no);

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

    if (carinforDao.update(carinfor) > 0) {
      out.println("주차차량 정보를 변경했습니다.");
    } else {
      out.println("변경에 실패했습니다.");
    }
  }
}

