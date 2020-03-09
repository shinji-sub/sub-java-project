package sub.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import sub.lms.dao.CustomerDao;
import sub.lms.domain.Customer;

public class CustomerAddServlet implements Servlet {

  CustomerDao customerDao;

  public CustomerAddServlet(CustomerDao customerDao) {
    this.customerDao = customerDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    Customer customer = new Customer();

    out.println("차종? ");
    out.println("!{}!");
    out.flush();
    customer.setCartype(in.nextLine());

    out.println("차량 번호? ");
    out.println("!{}!");
    out.flush();
    customer.setCarNumbel(in.nextLine());

    out.println("사진? ");
    out.println("!{}!");
    out.flush();
    customer.setPhoto(in.nextLine());

    out.println("할인율? ");
    out.println("!{}!");
    out.flush();
    customer.setDiscountRatr(in.nextLine());

    out.println("결제 금액? ");
    out.println("!{}!");
    out.flush();
    customer.setDiscountRatr(in.nextLine());

    out.println("결제 유형? ");
    out.println("!{}!");
    out.flush();
    customer.setGyeoljeYuhyeong(in.nextLine());

    out.println("차량 주차 장소? ");
    out.println("!{}!");
    out.flush();
    customer.setParking(in.nextLine());

    out.println("입·출차 상태? ");
    out.println("!{}!");
    out.flush();
    customer.setExitStatus(in.nextLine());

    out.println("수납 구분? ");
    out.println("!{}!");
    out.flush();
    customer.setAcceptance(in.nextLine());


    if (customerDao.insert(customer) > 0) {
      out.println("고객 정보를 저장했습니다.");

    } else {
      out.println("저장에 실패했습니다.");
    }
  }
}
