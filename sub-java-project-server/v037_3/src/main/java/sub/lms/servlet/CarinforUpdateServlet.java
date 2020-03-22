package sub.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import sub.lms.dao.CarinforDao;
import sub.lms.domain.Carinfor;
import sub.util.Prompt;

public class CarinforUpdateServlet implements Servlet {

  CarinforDao carinforDao;

  public CarinforUpdateServlet(CarinforDao carinforDao) {
    this.carinforDao = carinforDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    int no = Prompt.getInt(in, out, "번호? ");

    Carinfor old = CarinforDao.findByNo(no);
    if (old == null) {
      out.println("해당 번호의 주차차량 정보가 없습니다.");
      return;
    }

    Carinfor carinfor = new Carinfor();

    carinfor.setNo(no);

    out.println("차종? ");

    carinfor.setCarType(Prompt.getString(in, out,//
        String.format("차종(%s)? \n",old.getCarType()),
        old.getCarType()));

    carinfor.setCarNumber(Prompt.getString(in, out,//
        String.format("차량번호(%s)? \n",  old.getCarNumber()),
        old.getCarNumber()));

    carinfor.setParking(Prompt.getString(in, out,//
        String.format("주차위치(%s)? \n",  old.getParking()),
        old.getParking()));

    carinfor.setDatas(Prompt.getDate(in, out,//
        String.format("차량 입차 날짜(%s)? \n",  old.getDatas()),
        old.getDatas().toString()));

    carinfor.setDeparture(Prompt.getDate(in, out,//
        String.format("차량 입차 날짜(%s)? \n",  old.getDeparture()),
        old.getDeparture().toString()));

    if (carinforDao.update(carinfor) > 0) {
      out.println("주차차량 정보를 변경했습니다.");
    } else {
      out.println("변경에 실패했습니다.");
    }
  }
}

