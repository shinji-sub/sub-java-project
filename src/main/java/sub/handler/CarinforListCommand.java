package sub.handler;

import java.util.Iterator;
import java.util.List;
import sub.domain.Carinfor;

// "/carinfor/list" 커멘드 실행
public class CarinforListCommand implements Command {


  List<Carinfor> CarinforList;


  public CarinforListCommand(final List<Carinfor> list) {
    this.CarinforList = list;
  }

  @Override
  public void execute() {

    Iterator<Carinfor> iterator = CarinforList.iterator();
    while (iterator.hasNext()) {

      Carinfor c = iterator.next();
      System.out.printf("게시판 번호:%s, 차종:%s\n차량 번호 :%s, 차량 위치:%s\n입차 날짜:%s,출차날짜:%s\n", c.getNo(),
          c.getCarType(), c.getCarNumber(), c.getParking(), c.getDeparture(), c.getDatas(),
          c.getDeparture());
    }
  }
}


