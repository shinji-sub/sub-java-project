package sub.handler;

import java.util.Scanner;
import sub.domain.Customer;
import sub.util.ArrayList;

public class CustomerHandler {


  ArrayList<Customer> customerlist;

  Scanner input;


  public CustomerHandler(Scanner input) {
    this.input = input;
    this.customerlist = new ArrayList<>();
  }


  public void addCustomer() {
    Customer customer = new Customer();


    System.out.printf("번호?: ");
    customer.setNo(input.nextInt());

    input.nextLine();

    System.out.printf("차종?: ");
    customer.setCartype(input.nextLine());


    System.out.printf("차량 번호?: ");
    customer.setCarNumbel(input.nextLine());

    System.out.printf("사진?: ");
    customer.setPhoto(input.nextLine());

    System.out.printf("할인률?: ");
    customer.setDiscountRatr(input.nextLine());

    System.out.printf("결제 금액?: ");
    customer.setPayment(input.nextLine());

    System.out.printf("결제 유형?: ");
    customer.setGyeoljeYuhyeong(input.nextLine());

    System.out.print("차량 주차 장소?: ");
    customer.setParking(input.nextLine());

    System.out.print("입·출차 상태?: ");
    customer.setExitStatus(input.nextLine());

    System.out.print("수납 구분?: ");
    customer.setAcceptance(input.nextLine());

    customerlist.add(customer);

    System.out.println("저장하였습니다.");

  }

  public void listCustomer(){
    Customer[] arr = new Customer[this.customerlist.size()];
    
    this.customerlist.toArray(arr);
    
    for (Object obj : arr) {
      Customer m = (Customer)obj;
      System.out.printf("번호:%s, 차종:%s\n차량 번호 :%s, 사진:%s\n할인율:%s, 결제금액:%s\n결제유형:%s, "
          + "차량 주차장소:%s\n입·출차 상태:%s, 수납 구분:%s\n",
          m.getNo(), m.getCartype(), m.getCarNumbel(), m.getPhoto(), 
          m.getDiscountRatr(), m.getPayment(), m.getGyeoljeYuhyeong(),
          m.getParking(), m.getExitStatus(), m.getAcceptance());
    }
  }


}
