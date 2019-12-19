package sub;

import java.util.Scanner;
import java.sql.Date;

public class Ex1 {

  public static void main (String[] args) {

    Scanner keyboard = new Scanner(System.in);

    class CarInfor{
      int no;
      String CarType;
      String CarNumber;
      String parking;
      Date datas;
      String Departure;
    }

    final int SIZE = 100;

    CarInfor[] carinfors = new CarInfor[SIZE];

    String response;

    int count = 0;
    for (int i = 0; i < SIZE; i++) {
      CarInfor carinfor = new CarInfor();

      System.out.printf("게시판 번호? ");
      carinfor.no = keyboard.nextInt();
      keyboard.nextLine();

      System.out.printf("차종? ");
      carinfor.CarType = keyboard.nextLine();

      System.out.printf("차량번호? ");
      carinfor.CarNumber = keyboard.nextLine();

      System.out.printf("차량 위치? ");
      carinfor.parking = keyboard.nextLine();

      //System.out.printf("차량 입차 날짜? ");

      carinfor.datas = new Date(System.currentTimeMillis());

      System.out.printf("차량 출차 날짜? ");
      carinfor.Departure = keyboard.nextLine();

      carinfors[i] = carinfor;

      count++;
      System.out.println();

      carinfors[i] = carinfor;

      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      response = keyboard.nextLine();

      if (!response.equalsIgnoreCase("y")) {
        break;
      }
      keyboard.close();
    }
    
    System.out.println();
    for (int i = 0; i < count; i++) {
      CarInfor carinfor = carinfors[i];
      System.out.printf("게시판 번호:%s, 차종:%s\n차량 번호 :%s, 차량 위치:%s\n입차 날짜:%s,출차날짜:%s\n",
          carinfor.no, carinfor.CarType, carinfor.CarNumber, carinfor.parking, 
          carinfor.Departure,carinfor.datas,carinfor.Departure); // 출차 정보는 자동으로 출력 합니다.
    }
  }
}
    






    

