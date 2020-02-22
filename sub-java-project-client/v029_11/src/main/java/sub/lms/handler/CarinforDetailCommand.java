package sub.lms.handler;

import sub.lms.dao.proxy.CarinforDaoProxy;
import sub.lms.domain.Carinfor;
import sub.lms.util.Prompt;

// "/carinfor/detail" 커멘드 실행
public class CarinforDetailCommand implements Command {
  CarinforDaoProxy carinforDao;
  Prompt prompt;


  public CarinforDetailCommand(CarinforDaoProxy carinforDao, Prompt prompt) {
    this.carinforDao = carinforDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호: ");

      Carinfor carinfor = carinforDao.findByNo(no);
      System.out.printf("번호: %s\n", carinfor.getNo());
      System.out.printf("차종: %s\n", carinfor.getCarType());
      System.out.printf("차량 번호: %s\n", carinfor.getCarNumber());
      System.out.printf("차량 위치: %s\n", carinfor.getParking());
      System.out.printf("차량 입차 날짜 : %s\n", carinfor.getDatas());
      System.out.printf("차량 출차 날짜: %s\n", carinfor.getDeparture());

    } catch (Exception e) {

      System.out.println("조회 실패!");
    }
  }
}


