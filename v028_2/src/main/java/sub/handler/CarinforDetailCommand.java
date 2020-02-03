package sub.handler;

import java.util.List;
import sub.domain.Carinfor;
import sub.util.Prompt;

// "/carinfor/detail" 커멘드 실행
public class CarinforDetailCommand implements Command {


  List<Carinfor> CarinforList;

  Prompt prompt;


  public CarinforDetailCommand(Prompt prompt, List<Carinfor> list) {
    this.prompt = prompt;
    this.CarinforList = list;
  }

  @Override
  public void execute() {

    int index = indexOfCarinfor(prompt.inputInt("번호: "));

    if (index == -1) {
      System.out.println("자동차 정보 게시판 정보가 유효하지 않습니다.");
      return;
    }
    Carinfor carinfor = this.CarinforList.get(index);
    System.out.printf("번호: %s\n", carinfor.getNo());
    System.out.printf("차종: %s\n", carinfor.getCarType());
    System.out.printf("차량 번호: %s\n", carinfor.getCarNumber());
    System.out.printf("차량 위치: %s\n", carinfor.getParking());
    System.out.printf("차량 입차 날짜 : %s\n", carinfor.getDatas());
    System.out.printf("차량 출차 날짜: %s\n", carinfor.getDeparture());
  }

  private int indexOfCarinfor(int no) {
    for (int i = 0; i < this.CarinforList.size(); i++) {
      if (this.CarinforList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}


