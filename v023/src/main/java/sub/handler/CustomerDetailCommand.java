package sub.handler;

import java.util.List;
import sub.domain.Customer;
import sub.util.Prompt;

// "/customer/detail" 커멘드 실행
public class CustomerDetailCommand implements Command {


  List<Customer> CustomerList;

  Prompt prompt;

  public CustomerDetailCommand(Prompt prompt, List<Customer> list) {
    this.prompt = prompt;
    this.CustomerList = list;
  }

  @Override
  public void execute() {
    int index = indexOfCustomer(prompt.inputInt("번호: "));

    if (index == -1) {
      System.out.println("게시글 인덱스가 유효하지 않습니다.");
      return;
    }

    Customer customer = this.CustomerList.get(index);
    System.out.printf("번호: %s\n", customer.getNo());
    System.out.printf("차종: %s\n", customer.getCartype());
    System.out.printf("차량 번호: %s\n", customer.getCarNumbel());
    System.out.printf("사진: %s\n", customer.getPhoto());
    System.out.printf("할인율: %s\n", customer.getDiscountRatr());
    System.out.printf("결제금액: %s\n", customer.getPayment());
    System.out.printf("결제 유형: %s\n", customer.getGyeoljeYuhyeong());
    System.out.printf("차량 주차 장소: %s\n", customer.getParking());
    System.out.printf("입·출차 상태: %s\n", customer.getExitStatus());
    System.out.printf("수납구분: %s\n", customer.getAcceptance());
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
