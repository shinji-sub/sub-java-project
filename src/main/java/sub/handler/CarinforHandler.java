package sub.handler;

import java.sql.Date;
import java.util.Scanner;
import sub.domain.Carinfor;
import sub.util.ArrayList;


public class CarinforHandler {


  ArrayList<Carinfor> carinforList;

  Scanner input;
  Scanner nextLine() {
    return null;
  }

  public CarinforHandler(Scanner input) {
    this.input = input;
    this.carinforList = new ArrayList<>();
  }
  public CarinforHandler(Scanner input,int capacity) {
    this.input = input;
    this.carinforList = new ArrayList<>();
  }
  
  public void listCarinfor() {
    // LessonList의 보관된 값을 받을 배열을 준비한다.
    Carinfor[] arr = this.carinforList.toArray(new Carinfor[this.carinforList.size()]);
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

    //System.out.printf("차량 입차 날짜? ");

    carinfor.setDatas(new Date(System.currentTimeMillis()));

    System.out.print("차량 출차 날짜? ");
    carinfor.setDeparture(input.nextLine());

    carinforList.add(carinfor);
    System.out.println("저장하였습니다.");
  }

}





