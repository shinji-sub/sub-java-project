package sub.handler;

import java.util.List;
import sub.domain.Customer;
import sub.util.Prompt;

// "/customer/update" 커멘드 실행
public class CustomerUpdateCommand implements Command {


  List<Customer> CustomerList;

  Prompt prompt;

  public CustomerUpdateCommand(Prompt prompt, List<Customer> list) {
    this.prompt = prompt;
    this.CustomerList = list;
  }



  @Override
  public void execute() {

    int index = indexOfCustomer(prompt.inputInt("번호: "));

    if (index == -1) {
      System.out.println("해당 고객 정보를 찾을수 없습니다.");
      return;
    }

    Customer oldCustomer = this.CustomerList.get(index);
    Customer newCustomer = new Customer();

    newCustomer.setNo(oldCustomer.getNo());

    newCustomer.setCartype(prompt.inputString(String.format("차종(%s)? ", oldCustomer.getCartype()),
        oldCustomer.getCartype()));

    newCustomer.setCarNumbel(prompt.inputString(
        String.format("차량 번호(%s)? ", oldCustomer.getCarNumbel()), oldCustomer.getCarNumbel()));

    newCustomer.setPhoto(prompt.inputString(String.format("사진(%s)? ", oldCustomer.getPhoto()),
        oldCustomer.getPhoto()));

    newCustomer.setDiscountRatr(prompt.inputString(
        String.format("할인율(%s)?", oldCustomer.getDiscountRatr()), oldCustomer.getDiscountRatr()));

    newCustomer.setPayment(prompt.inputString(
        String.format("결제 금액(%s)? ", oldCustomer.getPayment()), oldCustomer.getPayment()));

    newCustomer.setGyeoljeYuhyeong(
        prompt.inputString(String.format("결제 유형(%s)? ", oldCustomer.getGyeoljeYuhyeong()),
            oldCustomer.getGyeoljeYuhyeong()));

    newCustomer.setParking(prompt.inputString(
        String.format("차량 주차장소(%s)?", oldCustomer.getParking()), oldCustomer.getParking()));

    newCustomer.setExitStatus(prompt.inputString(
        String.format("입·출차 장소(%s)?", oldCustomer.getExitStatus()), oldCustomer.getExitStatus()));

    newCustomer.setAcceptance(prompt.inputString(
        String.format("수납구분(%s)? ", oldCustomer.getAcceptance()), oldCustomer.getAcceptance()));


    if (oldCustomer.equals(newCustomer)) {
      System.out.println("고객 정보 변경을 취소 하였습니다.");
      return;
    }
    this.CustomerList.set(index, newCustomer);
    System.out.println("고객 정보를 변경했습니다.");
  }

  private int indexOfCustomer(int no) {
    for (int i = 0; i < this.CustomerList.size(); i++) {
      if (this.CustomerList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
