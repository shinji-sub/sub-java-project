package sub.lms.handler;

import sub.lms.dao.CustomerDao;
import sub.lms.util.Prompt;

// "customer/delete" 커멘드 실행
public class CustomerDeleteCommand implements Command {

  Prompt prompt;
  CustomerDao customerDao;

  public CustomerDeleteCommand(CustomerDao customerDao, Prompt prompt) {
    this.customerDao = customerDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호: ");
      if (customerDao.delete(no) > 0) {
        System.out.println("고객 정보를 삭제했습니다.");
      } else {
        System.out.println("해당 번호의 고객정보가 없습니다.");
      }

    } catch (Exception e) {
      System.out.println("삭제 실패!");
    }
  }
}
