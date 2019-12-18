package sub;

import java.util.Scanner;
import java.sql.Date;

public class Ex2 {

  public static void main (String[]avgs) {
    Scanner keyboard = new Scanner(System.in);
    final int SIZE = 100;
    int[] no = new int[SIZE];
    String[] Cartype = new String[SIZE];
    String[] CarNumbel = new String[SIZE];
    String[] photo = new String[SIZE];
    String[] DiscountRatr = new String[SIZE];
    String[] Payment = new String[SIZE];
    String[] parking = new String[SIZE];
    String[] ExitStatus = new String[SIZE];
    String[] acceptance = new String[SIZE];
    Date[] date = new Date[SIZE];
    

    int count = 0;
    for (int i =0; i < SIZE; i++) {
      count++;

      System.out.print("번호 ?: ");
      no[i] = keyboard.nextInt();
      keyboard.nextLine();

      System.out.print("차종?: ");
      Cartype[i] = keyboard.nextLine();

      System.out.print("차량 번호?: ");
      CarNumbel[i] = keyboard.nextLine();

      System.out.print("사진?: ");
      photo[i] = keyboard.nextLine();

      System.out.print("할인률?: ");
      DiscountRatr[i] = keyboard.nextLine();

      System.out.printf("결제 금액?: ");
      Payment[i] = keyboard.nextLine();

      System.out.print("차량 주차 장소?: ");
      parking[i] = keyboard.nextLine();

      System.out.print("입·출차 상태?: ");
      ExitStatus[i] = keyboard.nextLine();

      System.out.print("수납 구분?: ");
      acceptance[i] = keyboard.nextLine();


      date[i] = new Date(System.currentTimeMillis());

      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      String response;
      response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }
}
    keyboard.close();
    System.out.println();

    for (int i = 0; i < count; i++) {
      System.out.printf("번호:%s, 차종:%s,\n 차량번호:%s, 사진:%s,\n 할인율:%s, 결제 금액:%s,\n 차량 주차 장소:%s,"
          + "입·출차 상태 %s, 수납구분:%s\n 출차 날짜:%s",
          no[i], Cartype[i], CarNumbel[i], photo[i], 
          DiscountRatr[i], Payment[i],  parking[i],
          ExitStatus[i], acceptance[i], date[i]);
    }
  }
}
