package sub.handler;

import java.util.Scanner;
import sub.domain.Customer;

public class CustomerHandler {

  Customer[] customers; 
  int customerCount = 0;

  public Scanner input;
  static final int CUSTOMER_SIZE = 100;

public CustomerHandler(Scanner input) {
  this.input = input;
  this.customers = new Customer[CUSTOMER_SIZE];
}


  public void addCustomer() {
    Customer customer = new Customer();


    System.out.printf("번호?: ");
    customer.no =input.nextInt();

    input.nextLine();

    System.out.printf("차종?: ");
    customer.Cartype = input.nextLine();


    System.out.printf("차량 번호?: ");
    customer.CarNumbel = input.nextLine();

    System.out.printf("사진?: ");
    customer.photo = input.nextLine();

    System.out.printf("할인률?: ");
    customer.DiscountRatr = input.nextLine();

    System.out.printf("결제 금액?: ");
    customer.Payment = input.nextLine();

    System.out.printf("결제 유형?: ");
    customer.GyeoljeYuhyeong = input.nextLine();

    System.out.print("차량 주차 장소?: ");
    customer.parking = input.nextLine();

    System.out.print("입·출차 상태?: ");
    customer.ExitStatus = input.nextLine();

    System.out.print("수납 구분?: ");
    customer.acceptance = input.nextLine();

    this.customers[this.customerCount++] = customer;
    System.out.println("저장하였습니다.");

  }

  public void listCustomer(){
    for (int i = 0; i < this.customerCount; i++) {
      Customer m = this.customers[i];
      System.out.printf("번호:%s, 차종:%s\n차량 번호 :%s, 사진:%s\n할인율:%s, 결제금액:%s\n결제유형:%s, "
          + "차량 주차장소:%s\n입·출차 상태:%s, 수납 구분:%s\n",
          m.no, m.Cartype, m.CarNumbel, m.photo, 
          m.DiscountRatr, m.Payment, m.GyeoljeYuhyeong,
          m.parking, m.ExitStatus, m.acceptance);
    }
  }


}
