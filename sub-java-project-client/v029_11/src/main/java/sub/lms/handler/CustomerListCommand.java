package sub.lms.handler;

import java.util.List;
import sub.lms.dao.proxy.CustomerDaoProxy;
import sub.lms.domain.Customer;

// "/customer/list" 커멘드 실행
public class CustomerListCommand implements Command {

  CustomerDaoProxy customerDao;

  public CustomerListCommand(CustomerDaoProxy customerDao) {
    this.customerDao = customerDao;
  }

  @Override
  public void execute() {
    try {

      List<Customer> customers = customerDao.findAll();
      for (Customer m : customers) {
        System.out.printf(
            "번호:%s, 차종:%s\n차량 번호 :%s, 사진:%s\n할인율:%s, 결제금액:%s\n결제유형:%s, "
                + "차량 주차장소:%s\n입·출차 상태:%s, 수납 구분:%s\n",
            m.getNo(), m.getCartype(), m.getCarNumbel(), m.getPhoto(), m.getDiscountRatr(),
            m.getPayment(), m.getGyeoljeYuhyeong(), m.getParking(), m.getExitStatus(),
            m.getAcceptance());
      }
    } catch (Exception e) {
      System.out.println("조회 실패!");
    }
  }
}
