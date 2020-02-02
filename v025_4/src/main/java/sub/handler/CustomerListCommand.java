package sub.handler;

import java.util.Iterator;
import java.util.List;
import sub.domain.Customer;

// "/customer/list" 커멘드 실행
public class CustomerListCommand implements Command {


  List<Customer> CustomerList;


  public CustomerListCommand(List<Customer> list) {
    this.CustomerList = list;
  }



  @Override
  public void execute() {

    Iterator<Customer> iterator = CustomerList.iterator();
    while (iterator.hasNext()) {
      Customer m = iterator.next();
      System.out.printf(
          "번호:%s, 차종:%s\n차량 번호 :%s, 사진:%s\n할인율:%s, 결제금액:%s\n결제유형:%s, "
              + "차량 주차장소:%s\n입·출차 상태:%s, 수납 구분:%s\n",
          m.getNo(), m.getCartype(), m.getCarNumbel(), m.getPhoto(), m.getDiscountRatr(),
          m.getPayment(), m.getGyeoljeYuhyeong(), m.getParking(), m.getExitStatus(),
          m.getAcceptance());
    }
  }
}
