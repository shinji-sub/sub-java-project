package sub.handler;

import java.util.List;
import sub.domain.Customer;
import sub.util.Prompt;

// "/customer/add" 커멘드 실행
public class CustomerAddCommand implements Command {


  List<Customer> CustomerList;

  Prompt prompt;

  public CustomerAddCommand(Prompt prompt, List<Customer> list) {
    this.prompt = prompt;
    this.CustomerList = list;
  }


  @Override
  public void execute() {
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

    CustomerList.add(customer);

    System.out.println("저장하였습니다.");

  }

}

