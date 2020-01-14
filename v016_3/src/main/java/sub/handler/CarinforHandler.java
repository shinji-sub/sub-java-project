package sub.handler;

import sub.domain.Carinfor;
import sub.util.ArrayList;
import sub.util.Prompt;


public class CarinforHandler {


  ArrayList<Carinfor> CarinforList;

  Prompt prompt;


  public CarinforHandler(Prompt prompt) {
    this.prompt = prompt;
    this.CarinforList = new ArrayList<>();
  }

  public void listCarinfor() {
    // LessonList의 보관된 값을 받을 배열을 준비한다.
    Carinfor[] arr = this.CarinforList.toArray(new Carinfor[this.CarinforList.size()]);
    for (Carinfor c : arr) {
      System.out.printf("게시판 번호:%s, 차종:%s\n차량 번호 :%s, 차량 위치:%s\n입차 날짜:%s,출차날짜:%s\n",
          c.getNo(), c.getCarType(), c.getCarNumber(), c.getParking(), 
          c.getDeparture(),c.getDatas(),c.getDeparture());
    }
  }

  public void  addCarinfor() {
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

  public void detailCarinfor() {

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

  public void updateCarinfor() {

    int index = indexOfCarinfor(prompt.inputInt("번호: "));

    if (index == -1) {
      System.out.println("자동차 정보 게시판 정보가 유효하지 않습니다. ");
      return;
    }

    Carinfor oldCarinfor = this.CarinforList.get(index);
    Carinfor newCarinfor = new Carinfor();

    newCarinfor.setNo(oldCarinfor.getNo());

    newCarinfor.setCarType(prompt.inputString(
        String.format("차종(%s)", oldCarinfor.getCarType()),
        oldCarinfor.getCarType()));

    newCarinfor.setCarNumber(prompt.inputString(
        String.format("자동차 번호(%s)?", oldCarinfor.getCarNumber()),
        oldCarinfor.getCarNumber()));

    newCarinfor.setParking(prompt.inputString(
        String.format("차량 위치(%s)?", oldCarinfor.getParking()),
        oldCarinfor.getParking()));

    newCarinfor.setDatas(prompt.inputDate(
        String.format("차랑 입차 날짜(%s)?" , oldCarinfor.getDatas()),
        oldCarinfor.getDatas()));

    newCarinfor.setDeparture(prompt.inputDate(
        String.format("차랑 출차 날짜(%s)?" , oldCarinfor.getDeparture()),
        oldCarinfor.getDeparture()));


    if (oldCarinfor.equals(newCarinfor)) {
      System.out.println("자동차 정보를 변경했습니다.");
      return;
    }
    this.CarinforList.set(index, newCarinfor);
    System.out.println("자동차 정보 변경을 취소하였습니다.");
  }


  public void deleteCarinfor() {

    int index = indexOfCarinfor(prompt.inputInt("번호: "));
    if (index == -1) {
      System.out.println("해당 게시글 정보를 찾을 수 없습니다.");
      return;
    }
    this.CarinforList.remove(index);

    System.out.println("자동차 정보 게시판 정보를 삭제하였습니다.");
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



