package sub.lms.handler;

import sub.lms.dao.proxy.CarinforDaoProxy;
import sub.lms.domain.Carinfor;
import sub.lms.util.Prompt;

// "/carinfor/add 커멘드 실행
public class CarinforAddCommand implements Command {

  CarinforDaoProxy carinforDao;
  Prompt prompt;


  public CarinforAddCommand(CarinforDaoProxy carinforDao, Prompt prompt) {
    this.carinforDao = carinforDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    Carinfor carinfor = new Carinfor();

    carinfor.setNo(prompt.inputInt("게시판 번호?"));
    carinfor.setCarType(prompt.inputString("차종? "));
    carinfor.setCarNumber(prompt.inputString("차량번호? "));
    carinfor.setParking(prompt.inputString("차량 위치? "));
    carinfor.setDatas(prompt.inputDate("차량 입차 날짜? "));
    carinfor.setDeparture(prompt.inputDate("차량 출차 날짜? "));

    try {
      System.out.println("저장하였습니다.");
    } catch (Exception e) {
      System.out.println("저장 실패!");
    }
  }

}
