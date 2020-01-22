package sub.handler;

import java.util.List;
import sub.domain.Customer;
import sub.util.Prompt;

// "customer/delete" 커멘드 실행
public class CustomerDeleteCommand implements Command {


  List<Customer> CustomerList;

  Prompt prompt;

  public CustomerDeleteCommand(Prompt prompt, List<Customer> list) {
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

    this.CustomerList.remove(index);

    System.out.println("고객 정보를 삭제했습니다.");
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
