package sub.handler;

import java.util.List;
import sub.domain.Carinfor;
import sub.util.Prompt;

// "carinfor/update" 커멘드 실행
public class CarinforUpdateCommand implements Command {


  List<Carinfor> CarinforList;

  Prompt prompt;


  public CarinforUpdateCommand(Prompt prompt, List<Carinfor> list) {
    this.prompt = prompt;
    this.CarinforList = list;
  }


  @Override
  public void execute() {

    int index = indexOfCarinfor(prompt.inputInt("번호: "));

    if (index == -1) {
      System.out.println("자동차 정보 게시판 정보가 유효하지 않습니다. ");
      return;
    }

    Carinfor oldCarinfor = this.CarinforList.get(index);
    Carinfor newCarinfor = new Carinfor();

    newCarinfor.setNo(oldCarinfor.getNo());

    newCarinfor.setCarType(prompt.inputString(String.format("차종(%s)", oldCarinfor.getCarType()),
        oldCarinfor.getCarType()));

    newCarinfor.setCarNumber(prompt.inputString(
        String.format("자동차 번호(%s)?", oldCarinfor.getCarNumber()), oldCarinfor.getCarNumber()));

    newCarinfor.setParking(prompt.inputString(String.format("차량 위치(%s)?", oldCarinfor.getParking()),
        oldCarinfor.getParking()));

    newCarinfor.setDatas(prompt.inputDate(String.format("차랑 입차 날짜(%s)?", oldCarinfor.getDatas()),
        oldCarinfor.getDatas()));

    newCarinfor.setDeparture(prompt.inputDate(
        String.format("차랑 출차 날짜(%s)?", oldCarinfor.getDeparture()), oldCarinfor.getDeparture()));


    if (oldCarinfor.equals(newCarinfor)) {
      System.out.println("자동차 정보 변경을 취소하였습니다.");
      return;
    }
    this.CarinforList.set(index, newCarinfor);
    System.out.println("자동차 정보를 변경했습니다.");
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


