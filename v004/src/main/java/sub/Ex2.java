package sub;

import java.util.Scanner;

public class Ex2 {

  public static void main (String[]avgs) {
    Scanner keyboard = new Scanner(System.in);

    class Customer {
      int no;
      String Cartype;
      String CarNumbel;
      String photo;
      String DiscountRatr;
      String Payment;
      String GyeoljeYuhyeong;
      String parking;
      String ExitStatus;
      String acceptance;

    }

    final int SIZE = 100;

    Customer[] customers = new Customer[SIZE]; 
    int count = 0;
    for (int i = 0; i < 100; i++) {
      
      Customer customer = new Customer();
      
      
      System.out.println("번호?: ");
      customer.no =keyboard.nextInt();
      keyboard.nextLine();

      System.out.printf("차종?: ");
      customer.Cartype = keyboard.nextLine();
     

      System.out.printf("차량 번호?: ");
      customer.CarNumbel = keyboard.nextLine();

      System.out.printf("사진?: ");
      customer.photo = keyboard.nextLine();

      System.out.printf("할인률?: ");
      customer.DiscountRatr = keyboard.nextLine();

      System.out.printf("결제 금액?: ");
      customer.Payment = keyboard.nextLine();

      System.out.printf("결제 유형?: ");
      customer.GyeoljeYuhyeong = keyboard.nextLine();

      System.out.print("차량 주차 장소?: ");
      customer.parking = keyboard.nextLine();

      System.out.print("입·출차 상태?: ");
      customer.ExitStatus = keyboard.nextLine();

      System.out.print("수납 구분?: ");
      customer.acceptance = keyboard.nextLine();

      customers[i] = customer;

      count ++;

      System.out.println();


      customers[i] = customer;

      String response;

      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }
    }
    keyboard.close();
    for (int i = 0; i < count; i++) {
      Customer customer = customers[i];
      System.out.printf("번호:%s, 차종:%s\n차량 번호 :%s, 사진:%s\n할인율:%s, 결제금액:%s\n결제유형:%s, "
          + "차량 주차장소:%s\n입·출차 상태:%s, 수납 구분:%s\n",
          customer.no, customer.Cartype, customer.CarNumbel, customer.photo, 
          customer.DiscountRatr, customer.Payment, customer.GyeoljeYuhyeong,
          customer.parking, customer.ExitStatus, customer.acceptance);
    }
  }
}

