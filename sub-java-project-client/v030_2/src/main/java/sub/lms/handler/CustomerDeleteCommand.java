package sub.lms.handler;

import sub.lms.dao.proxy.CustomerDaoProxy;
import sub.lms.util.Prompt;

// "customer/delete" 커멘드 실행
public class CustomerDeleteCommand implements Command {

  Prompt prompt;
  CustomerDaoProxy customerDao;

  public CustomerDeleteCommand(CustomerDaoProxy customerDao, Prompt prompt) {
    this.customerDao = customerDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호: ");
      customerDao.delete(no);

      System.out.println("고객 정보를 삭제했습니다.");
    } catch (Exception e) {
      System.out.println("삭제 실패!");
    }
  }
}
