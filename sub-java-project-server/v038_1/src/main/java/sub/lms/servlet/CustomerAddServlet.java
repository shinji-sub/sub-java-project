package sub.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import sub.lms.dao.CustomerDao;
import sub.lms.domain.Customer;
import sub.util.Prompt;

public class CustomerAddServlet implements Servlet {

  CustomerDao customerDao;

  public CustomerAddServlet(CustomerDao customerDao) {
    this.customerDao = customerDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    Customer customer = new Customer();

    customer.setCartype(Prompt.getString(in, out, "차종? "));

    customer.setCarNumbel(Prompt.getString(in, out, "차량 번호? "));

    customer.setPhoto(Prompt.getString(in, out, "사진? "));

    customer.setDiscountRatr(Prompt.getString(in, out, "할인율? "));

    customer.setDiscountRatr(Prompt.getString(in, out, "결제 금액? "));

    customer.setGyeoljeYuhyeong(Prompt.getString(in, out, "결제 유형? "));

    customer.setParking(Prompt.getString(in, out, "차량 주차 장소? "));

    customer.setExitStatus(Prompt.getString(in, out, "입·출차 상태? "));

    customer.setAcceptance(Prompt.getString(in, out, "수납 구분? "));


    if (customerDao.insert(customer) > 0) {
      out.println("고객 정보를 저장했습니다.");

    } else {
      out.println("저장에 실패했습니다.");
    }
  }
}
