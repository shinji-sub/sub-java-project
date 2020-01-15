package sub.handler;

import sub.domain.Customer;
import sub.util.LinkedList;
import sub.util.List;
import sub.util.Prompt;

public class CustomerHandler {


  List<Customer> customerlist;

  Prompt prompt;

  public CustomerHandler(Prompt prompt, List<Customer> list) {
    this.prompt = prompt;
    this.customerlist = new LinkedList<>();
  }


  public void addCustomer() {
    Customer customer = new Customer();

    customer.setNo(prompt.inputInt("번호?: "));
    customer.setCartype(prompt.inputString("차종?: "));
    customer.setCarNumbel(prompt.inputString("차량 번호?: "));
    customer.setPhoto(prompt.inputString("사진?: "));
    customer.setDiscountRatr(prompt.inputString("할인률?: "));
    customer.setPayment(prompt.inputString("결제 금액?: "));
    customer.setGyeoljeYuhyeong(prompt.inputString("결제 유형?: "));
    customer.setParking(prompt.inputString("차량 주차 장소?: "));
    customer.setExitStatus(prompt.inputString("입·출차 상태?: "));
    customer.setAcceptance(prompt.inputString("수납 구분?: "));

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
    int index = indexOfCustomer(prompt.inputInt("번호: "));

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

    int index = indexOfCustomer(prompt.inputInt("번호: "));

    if (index == -1) {
      System.out.println("해당 고객 정보를 찾을수 없습니다.");
      return;
    }
    
    Customer oldCustomer = this.customerlist.get(index);
    Customer newCustomer = new Customer();

    newCustomer.setNo(oldCustomer.getNo());

    newCustomer.setCartype(prompt.inputString(
        String.format("차종(%s)? ", oldCustomer.getCartype()),
        oldCustomer.getCartype()));

    newCustomer.setCarNumbel(prompt.inputString(
        String.format("차량 번호(%s)? ", oldCustomer.getCarNumbel()),
        oldCustomer.getCarNumbel()));

    newCustomer.setPhoto(prompt.inputString(
        String.format("사진(%s)? ", oldCustomer.getPhoto()),
        oldCustomer.getPhoto()));

    newCustomer.setExitStatus(prompt.inputString(
        String.format("할인율(%s)?", oldCustomer.getExitStatus()),
        oldCustomer.getExitStatus()));

    newCustomer.setPayment(prompt.inputString(
        String.format("결제 금액(%s)? ", oldCustomer.getPayment()),
        oldCustomer.getPayment()));

    newCustomer.setGyeoljeYuhyeong(prompt.inputString(
        String.format("결제 유형(%s)? ", oldCustomer.getGyeoljeYuhyeong()),
        oldCustomer.getGyeoljeYuhyeong()));

    newCustomer.setParking(prompt.inputString(
        String.format("차량 주차장소(%s)?", oldCustomer.getParking()), 
        oldCustomer.getParking()));

    newCustomer.setExitStatus(prompt.inputString(
        String.format("입·출차 장소(%s)?", oldCustomer.getExitStatus()),
        oldCustomer.getExitStatus()));
    newCustomer.setAcceptance(prompt.inputString(
        String.format("수납구분(%s)? ", oldCustomer.getAcceptance()),
        oldCustomer.getAcceptance()));


    if (oldCustomer.equals(newCustomer)) {
      System.out.println("고객 정보를 변경했습니다.");
      return;
    }
    this.customerlist.set(index, newCustomer);
    System.out.println("고객 정보 변경을 취소하였습니다.");
  }



public void deleteCustomer () {
  int index = indexOfCustomer(prompt.inputInt("번호: "));

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
