package sub.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import sub.lms.dao.CustomerDao;
import sub.lms.domain.Customer;
import sub.util.Prompt;

public class CustomerDetailServlet implements Servlet {
  CustomerDao customerDao;

  public CustomerDetailServlet(CustomerDao customerDao) {
    this.customerDao = customerDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int no = Prompt.getInt(in, out, "번호? ");

    Customer customer = customerDao.findByNo(no);

    if (customer != null) {
      out.printf("번호: %s\n", customer.getNo());
      out.printf("차종: %s\n", customer.getCartype());
      out.printf("차량 번호: %s\n", customer.getCarNumbel());
      out.printf("사진: %s\n", customer.getPhoto());
      out.printf("할인율: %s\n", customer.getDiscountRatr());
      out.printf("결제금액: %s\n", customer.getPayment());
      out.printf("결제 유형: %s\n", customer.getGyeoljeYuhyeong());
      out.printf("차량 주차 장소: %s\n", customer.getParking());
      out.printf("입·출차 상태: %s\n", customer.getExitStatus());
      out.printf("수납구분: %s\n", customer.getAcceptance());

    } else {
      out.println("해당 번호의 고객정보가 없습니다.");
    }
  }
}

