package sub.handler;

import java.util.List;
import sub.domain.Carinfor;
import sub.util.Prompt;

// "/carinfor/add 커멘드 실행
public class CarinforAddCommand implements Command {


  List<Carinfor> CarinforList;

  Prompt prompt;


  public CarinforAddCommand(Prompt prompt, List<Carinfor> list) {
    this.prompt = prompt;
    this.CarinforList = list;
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

    this.CarinforList.add(carinfor);

    System.out.println("저장하였습니다.");
  }
}


