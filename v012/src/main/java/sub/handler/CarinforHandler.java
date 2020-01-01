package sub.handler;

import java.sql.Date;
import java.util.Scanner;
import sub.domain.Carinfor;


public class CarinforHandler {


  Carinfor[] carinfors;
  int carinforCount = 0;

  public Scanner input;
  static final int CARINFOR_SIZE = 100;

  public CarinforHandler(Scanner input) {
    this.input = input;
    this.carinfors  = new Carinfor[CARINFOR_SIZE];
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

    this.carinfors[this.carinforCount++] = carinfor;
    System.out.println("저장하였습니다.");
  }

  public  void listCarinfor() {
    for (int i = 0; i < this.carinforCount; i++) {
      Carinfor c = this.carinfors[i];
      System.out.printf("게시판 번호:%s, 차종:%s\n차량 번호 :%s, 차량 위치:%s\n입차 날짜:%s,출차날짜:%s\n",
          c.getNo(), c.getCarType(), c.getCarNumber(), c.getParking(), 
          c.getDeparture(),c.getDatas(),c.getDeparture());
    }
  }



}
