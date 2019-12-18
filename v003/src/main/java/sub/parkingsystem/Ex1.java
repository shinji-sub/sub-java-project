package sub;

import java.util.Scanner;
import java.sql.Date;

public class Ex1 {

  public static void main (String[] args) {
    Scanner keyboard = new Scanner(System.in);

    final int SIZE = 100;

    int[] no = new int[SIZE];
    String[] CarType = new String[SIZE];
    String[] CarNumber = new String[SIZE];
    String[] parking = new String[SIZE];
    Date[] date = new Date[SIZE];
    String[] Departure = new String[SIZE];
    //String[] EnteringAvehicle = new String[100];
    String response;

    int count = 0;
    for (int i = 0; i < SIZE; i++) {
      count++;

      System.out.printf("번호? ");
      no[i] = keyboard.nextInt();

      keyboard.nextLine();

      System.out.printf("차종? ");
      CarType[i] = keyboard.nextLine();

      System.out.printf("차량번호? ");
      CarNumber[i] = keyboard.nextLine();

      System.out.printf("차량 위치? ");
      parking[i] = keyboard.nextLine();

      //System.out.printf("차량 입차 날짜? ");

      date[i] = new Date(System.currentTimeMillis());


      System.out.printf("차량 출차 날짜? ");
      Departure[i] = keyboard.nextLine();

      System.out.println();

      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      String reponse;
      response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }
    }

    keyboard.close();
    System.out.println();

    for (int i = 0; i < count; i++) {
      System.out.printf("번호:%s, 차종:%s\n차량 번호 :%s, 차량 위치:%s\n입차 날짜:%s,출차날짜:%s\n",
          no[i], CarType[i], CarNumber[i], parking[i], 
          Departure[i],date[i],Departure[i]);
    }
  }
}



