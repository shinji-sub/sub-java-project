package sub.lms.handler;

import sub.lms.dao.proxy.CustomerDaoProxy;
import sub.lms.domain.Customer;
import sub.lms.util.Prompt;

// "/customer/add" 커멘드 실행
public class CustomerAddCommand implements Command {

  CustomerDaoProxy customerDao;
  Prompt prompt;

  public CustomerAddCommand(CustomerDaoProxy customerDao, Prompt prompt) {
    this.customerDao = customerDao;
    this.prompt = prompt;
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
    try {
      
      customerDao.insert(customer);
      System.out.println("저장하였습니다.");
    } catch (Exception e) {
      System.out.println("저장 실패!");
    }
  }
}

