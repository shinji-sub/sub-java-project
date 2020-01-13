package sub.handler;

import java.sql.Date;
import java.util.Scanner;
import sub.domain.Carinfor;
import sub.util.ArrayList;


public class CarinforHandler {


  ArrayList<Carinfor> CarinforList;

  Scanner input;
  Scanner nextLine() {
    return null;
  }

  public CarinforHandler(Scanner input) {
    this.input = input;
    this.CarinforList = new ArrayList<>();
  }
  public CarinforHandler(Scanner input,int capacity) {
    this.input = input;
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

    System.out.print("게시판 번호? ");
    carinfor.setNo(input.nextInt());

    input.nextLine();

    System.out.print("차종? ");
    carinfor.setCarType(input.nextLine());

    System.out.print("차량번호? ");
    carinfor.setCarNumber(input.nextLine());

    System.out.print("차량 위치? ");
    carinfor.setParking(input.nextLine());

    System.out.printf("차량 입차 날짜? ");
    carinfor.setDatas(Date.valueOf(input.next()));

    System.out.print("차량 출차 날짜? ");
    carinfor.setDeparture(Date.valueOf(input.next()));
    input.nextLine();

    CarinforList.add(carinfor);
    System.out.println("저장하였습니다.");

  }

  public void detailCarinfor() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine();

    int index = indexOfCarinfor(no);
    
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
    System.out.print("번호 ? ");
    int no = input.nextInt();
    input.nextLine();

    int index = indexOfCarinfor(no);

    if (index == -1) {
      System.out.println("자동차 정보 게시판 정보가 유효하지 않습니다. ");
      return;
    }
    Carinfor oldCarinfor = this.CarinforList.get(index);
    boolean changed = false;
    String inputStr = null;
    Carinfor newCarinfor = new Carinfor();

    newCarinfor.setNo(oldCarinfor.getNo());

    System.out.printf("차종(%s)? ", oldCarinfor.getCarType());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newCarinfor.setCarType(oldCarinfor.getCarType());
    } else {
      newCarinfor.setCarType(inputStr);
      changed = true;
    }

    System.out.printf("차량 번호(%s)? ",oldCarinfor.getCarNumber());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newCarinfor.setCarNumber(oldCarinfor.getCarNumber());
    } else {
      newCarinfor.setCarNumber(inputStr);
      changed = true;
    }
    System.out.printf("차량 위치(%s)? ", oldCarinfor.getParking());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newCarinfor.setParking(oldCarinfor.getParking());
    } else {
      newCarinfor.setParking(inputStr);
      changed = true;
    }
    System.out.printf("차량 입차 날짜(%s)? ",oldCarinfor.getDatas());
    inputStr = input.nextLine();
    if (inputStr.length() == 0 ) {
      newCarinfor.setDatas(oldCarinfor.getDatas());
    } else {
      newCarinfor.setDatas(Date.valueOf(inputStr));
      changed = true;
    }
    System.out.printf("차량 출차 날짜(%s)?", oldCarinfor.getDeparture());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newCarinfor.setDeparture(oldCarinfor.getDeparture());
    } else {
      newCarinfor.setDeparture(Date.valueOf(inputStr));
      changed = true;
    }

    if (changed) {
      this.CarinforList.set(index, newCarinfor);
      System.out.println("자동차 정보를 변경했습니다.");
    } else {
      System.out.println("자동차 정보 변경을 취소하였습니다.");
    }
  }

  public void deleteCarinfor() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine();

    
    int index = indexOfCarinfor(no);
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



