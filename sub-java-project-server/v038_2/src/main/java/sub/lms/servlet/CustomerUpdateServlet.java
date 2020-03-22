package sub.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import sub.lms.dao.CustomerDao;
import sub.lms.domain.Customer;
import sub.util.Prompt;

public class CustomerUpdateServlet implements Servlet {

  CustomerDao customerDao;

  public CustomerUpdateServlet(CustomerDao customerDao) {
    this.customerDao = customerDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int no = Prompt.getInt(in, out, "번호? ");

    Customer old = CustomerDao.findByNo(no);
    if (old == null) {
      out.println("해당 번호의 고객정보가 없습니다.");
      return;
    }

    Customer customer = new Customer();

    customer.setNo(no);

    customer.setCartype(Prompt.getString(in, out,
        String.format("차종(%s)? \n", old.getCartype()),
        old.getCartype()));

    customer.setCarNumbel(Prompt.getString(in, out,
        String.format("차량 번호(%s)? \n", old.getCarNumbel()),
        old.getCarNumbel()));

    customer.setPhoto(Prompt.getString(in, out,
        String.format("사진(%s)? \n", old.getPhoto()),
        old.getPhoto()));

    customer.setDiscountRatr(Prompt.getString(in, out,
        String.format("할인율(%s)? \n", old.getDiscountRatr()),
        old.getDiscountRatr()));

    customer.setPayment(Prompt.getString(in, out,
        String.format("결제 금액(%s)? \n", old.getPayment()),
        old.getPayment()));


    customer.setGyeoljeYuhyeong(Prompt.getString(in, out,
        String.format("결제 유형(%s)? \n", old.getGyeoljeYuhyeong()),
        old.getGyeoljeYuhyeong()));

    customer.setParking(Prompt.getString(in, out,
        String.format("차량 주차 장소(%s)? \n", old.getParking()),
        old.getParking()));

    customer.setExitStatus(Prompt.getString(in, out,
        String.format("입·출차 상태(%s)? \n", old.getExitStatus()),
        old.getExitStatus()));

    customer.setAcceptance(Prompt.getString(in, out,
        String.format("수납 구분(%s)? \n", old.getAcceptance()),
        old.getAcceptance()));


    if (customerDao.update(customer) > 0) {
      out.println("고객정보를 변경했습니다.");
    } else {
      out.println("변경에 실패했습니다.");
    }
  }
}
