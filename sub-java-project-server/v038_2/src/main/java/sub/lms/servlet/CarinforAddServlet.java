package sub.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import sub.lms.dao.CarinforDao;
import sub.lms.domain.Carinfor;
import sub.util.Prompt;

public class CarinforAddServlet implements Servlet {

  CarinforDao carinforDao;

  public CarinforAddServlet(CarinforDao carinforDao) {
    this.carinforDao = carinforDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    Carinfor carinfor = new Carinfor();


    carinfor.setCarType(Prompt.getString(in, out, "차종? "));

    carinfor.setCarNumber(Prompt.getString(in, out, "차량번호?" ));

    carinfor.setParking(Prompt.getString(in, out, "주차위치? "));

    carinfor.setDatas(Prompt.getDate(in, out, "차량 입차 날짜?"));

    carinfor.setDeparture(Prompt.getDate(in, out, "차량 출차 날짜? "));

    if (carinforDao.insert(carinfor) > 0) {
      out.println("주차장 정보를 저장했습니다.");

    } else {
      out.println("저장에 실패했습니다.");
    }
  }
}
