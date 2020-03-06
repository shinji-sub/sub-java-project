package sub.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import sub.lms.dao.CustomerDao;
import sub.lms.domain.Customer;

public class CustomerUpdateServlet implements Servlet {

  CustomerDao customerDao;

  public CustomerUpdateServlet(CustomerDao customerDao) {
    this.customerDao = customerDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("번호? ");
    out.println("!{}!");
    out.flush();
    int no = Integer.parseInt(in.nextLine());

    Customer old = customerDao.findByNo(no);
    if (old == null) {
      out.println("해당 번호의 고객정보가 없습니다.");
      return;
    }

    Customer customer = new Customer();

    customer.setNo(no);

    out.printf("차종(%s)? \n", old.getCartype());
    out.println("!{}!");
    out.flush();
    customer.setCartype(in.nextLine());

    out.printf("차량 번호(%s)? \n", old.getCarNumbel());
    out.println("!{}!");
    out.flush();
    customer.setCarNumbel(in.nextLine());

    out.printf("사진(%s)? \n", old.getPhoto());
    out.println("!{}!");
    out.flush();
    customer.setPhoto(in.nextLine());

    out.printf("할인율(%s)? \n", old.getDiscountRatr());
    out.println("!{}!");
    out.flush();
    customer.setDiscountRatr(in.nextLine());

    out.printf("결제 금액(%s)? \n", old.getDiscountRatr());
    out.println("!{}!");
    out.flush();
    customer.setDiscountRatr(in.nextLine());

    out.printf("결제 유형(%s)? \n", old.getPayment());
    out.println("!{}!");
    out.flush();
    customer.setGyeoljeYuhyeong(in.nextLine());

    out.printf("차량 주차 장소(%s)? \n", old.getParking());
    out.println("!{}!");
    out.flush();
    customer.setParking(in.nextLine());

    out.printf("입·출차 상태(%s)? \n", old.getExitStatus());
    out.println("!{}!");
    out.flush();
    customer.setExitStatus(in.nextLine());

    out.printf("수납 구분(%s)? \n", old.getAcceptance());
    out.println("!{}!");
    out.flush();
    customer.setAcceptance(in.nextLine());


    if (customerDao.update(customer) > 0) {
      out.println("고객정보를 변경했습니다.");
    } else {
      out.println("변경에 실패했습니다.");
    }
  }
}
