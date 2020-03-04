package sub.lms.handler;

import java.util.List;
import sub.lms.dao.CarinforDao;
import sub.lms.domain.Carinfor;

// "/carinfor/list" 커멘드 실행
public class CarinforListCommand implements Command {
  CarinforDao carinforDao;

  public CarinforListCommand(CarinforDao carinforDao) {
    this.carinforDao = carinforDao;
  }

  @Override
  public void execute() {
    try {
      List<Carinfor> carinfors = carinforDao.findAll();
      for (Carinfor carinfor : carinfors) {
        System.out.printf("게시판 번호:%s, 차종:%s\n차량 번호 :%s, 차량 위치:%s\n입차 날짜:%s,출차날짜:%s\n", carinfor.getNo(),
            carinfor.getCarType(), carinfor.getCarNumber(), carinfor.getParking(),  carinfor.getDatas(), carinfor.getDeparture(),
            carinfor.getDeparture());
      }
    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}

