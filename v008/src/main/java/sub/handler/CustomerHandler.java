package sub.handler;

import java.util.Scanner;

public class CustomerHandler {
  static class Customer {
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
  static  final int CUSTOMER_SIZE = 100;
  static  Customer[] customers = new Customer[CUSTOMER_SIZE]; 
  static  int customerCount = 0;


  public static Scanner keyboard;


  public static void addCustomer() {
    Customer customer = new Customer();


    System.out.printf("번호?: ");
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

    customers[customerCount++] = customer;
    System.out.println("저장하였습니다.");

  }

  public static void listCustomer(){
    for (int i = 0; i < customerCount; i++) {
      Customer m = customers[i];
      System.out.printf("번호:%s, 차종:%s\n차량 번호 :%s, 사진:%s\n할인율:%s, 결제금액:%s\n결제유형:%s, "
          + "차량 주차장소:%s\n입·출차 상태:%s, 수납 구분:%s\n",
          m.no, m.Cartype, m.CarNumbel, m.photo, 
          m.DiscountRatr, m.Payment, m.GyeoljeYuhyeong,
          m.parking, m.ExitStatus, m.acceptance);
    }
  }


}
