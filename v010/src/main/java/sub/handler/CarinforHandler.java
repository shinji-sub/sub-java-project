package sub.handler;

import java.sql.Date;
import java.util.Scanner;
import sub.domain.Carinfor;


public class CarinforHandler {


  Carinfor[] carinfors = new Carinfor[CARINFOR_SIZE];
  int carinforCount = 0;

  static final int CARINFOR_SIZE = 100;
  public static Scanner keyboard;


  public void  addCarinfor() {
    Carinfor carinfor = new Carinfor();

    System.out.print("게시판 번호? ");
    carinfor.no = keyboard.nextInt();

    keyboard.nextLine();

    System.out.print("차종? ");
    carinfor.CarType = keyboard.nextLine();

    System.out.print("차량번호? ");
    carinfor.CarNumber = keyboard.nextLine();

    System.out.print("차량 위치? ");
    carinfor.parking = keyboard.nextLine();

    //System.out.printf("차량 입차 날짜? ");

    carinfor.datas = new Date(System.currentTimeMillis());

    System.out.print("차량 출차 날짜? ");
    carinfor.Departure = keyboard.nextLine();

    this.carinfors[this.carinforCount++] = carinfor;
    System.out.println("저장하였습니다.");
  }

  public  void listCarinfor() {
    for (int i = 0; i < this.carinforCount; i++) {
      Carinfor c = this.carinfors[i];
      System.out.printf("게시판 번호:%s, 차종:%s\n차량 번호 :%s, 차량 위치:%s\n입차 날짜:%s,출차날짜:%s\n",
          c.no, c.CarType, c.CarNumber, c.parking, 
          c.Departure,c.datas,c.Departure);
    }
  }



}
