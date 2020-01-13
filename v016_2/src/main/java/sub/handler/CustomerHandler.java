package sub.handler;

import java.util.Scanner;
import sub.domain.Customer;
import sub.util.ArrayList;

public class CustomerHandler {


  ArrayList<Customer> customerlist;

  Scanner input;
  Scanner nextLine() {
    return null;
  }

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
  public void detailCustomer() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine();

    int index = indexOfCustomer(no);

    if (index == -1) {
      System.out.println("게시글 인덱스가 유효하지 않습니다.");
      return;
    }

    Customer customer = this.customerlist.get(index);
    System.out.printf("번호: %s\n", customer.getNo());
    System.out.printf("차종: %s\n", customer.getCartype());
    System.out.printf("차량 번호: %s\n", customer.getCarNumbel());
    System.out.printf("사진: %s\n", customer.getPhoto());
    System.out.printf("할인율: %s\n", customer.getDiscountRatr());
    System.out.printf("결제금액: %s\n", customer.getPayment());
    System.out.printf("결제 유형: %s\n", customer.getGyeoljeYuhyeong());
    System.out.printf("차량 주차 장소: %s\n",customer.getParking());
    System.out.printf("입·출차 상태: %s\n", customer.getExitStatus());
    System.out.printf("수납구분: %s\n", customer.getAcceptance());
  }

  public void updateCustomer() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine();

    int index = indexOfCustomer(no);

    if (index == -1) {
      System.out.println("해당 고객 정보를 찾을수 없습니다.");
      return;
    }
    Customer oldCustomer = this.customerlist.get(index);
    boolean changed = false;
    String inputStr = null;
    Customer newCustomer = new Customer();

    newCustomer.setNo(oldCustomer.getNo());

    System.out.printf("차종(%s)? ", oldCustomer.getCartype());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newCustomer.setCartype(oldCustomer.getCartype());
    } else {
      newCustomer.setCartype(inputStr);
      changed = true;
    }

    System.out.printf("차량 번호(%s)? ", oldCustomer.getCarNumbel());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newCustomer.setCarNumbel(oldCustomer.getCarNumbel());
    } else {
      newCustomer.setCarNumbel(inputStr);
      changed = true;
    }

    System.out.printf("사진(%s)? ", oldCustomer.getPhoto());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newCustomer.setPhoto(oldCustomer.getPhoto());
    } else {
      newCustomer.setPhoto(inputStr);
      changed = true;
    }

    System.out.printf("할인율(%s)?", oldCustomer.getExitStatus());
    inputStr = input.nextLine();
    if (inputStr.length() == 0 ) {
      newCustomer.setExitStatus(oldCustomer.getExitStatus());
    } else {
      newCustomer.setExitStatus(inputStr);
      changed = true;
    }

    System.out.printf("결제 금액(%s)? ", oldCustomer.getPayment());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newCustomer.setPayment(oldCustomer.getPayment());
    } else {
      newCustomer.setPayment(inputStr);
      changed = true;
    }

    System.out.printf("결제 유형(%s)? ", oldCustomer.getGyeoljeYuhyeong());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newCustomer.setGyeoljeYuhyeong(oldCustomer.getGyeoljeYuhyeong());
    } else {
      newCustomer.setGyeoljeYuhyeong(inputStr);
      changed = true;
    }

    System.out.printf("차량 주차장소(%s)?", oldCustomer.getParking());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newCustomer.setParking(oldCustomer.getParking());
    } else {
      newCustomer.setParking(inputStr);
      changed = true;
    }

    System.out.printf("입·출차 장소(%s)?", oldCustomer.getExitStatus());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newCustomer.setExitStatus(oldCustomer.getExitStatus());
    } else {
      newCustomer.setExitStatus(inputStr);
      changed = true;
    }
    System.out.printf("수납구분(%s)? ", oldCustomer.getAcceptance());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newCustomer.setAcceptance(oldCustomer.getAcceptance());
    } else {
      newCustomer.setAcceptance(inputStr);
      changed = true;
    }

    if (changed) {
      this.customerlist.set(index, newCustomer);
      System.out.println("고객 정보를 변경했습니다.");
    } else {
      System.out.println("고객 정보 변경을 취소하였습니다.");
    }


  }
  public void deleteCustomer () {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine();

    int index = indexOfCustomer(no);
    
    if (index == -1) {
      System.out.println("해당 고객 정보를 찾을수 없습니다.");
      return;
    }
    this.customerlist.remove(index);
    
    System.out.println("고객 정보를 삭제했습니다.");
  }


  private int indexOfCustomer(int no) {
    for (int i = 0; i < this.customerlist.size(); i++) {
      if (this.customerlist.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
