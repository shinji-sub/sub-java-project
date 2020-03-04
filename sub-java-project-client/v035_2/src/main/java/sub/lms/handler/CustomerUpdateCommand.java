package sub.lms.handler;

import sub.lms.dao.CustomerDao;
import sub.lms.domain.Customer;
import sub.lms.util.Prompt;

// "/customer/update" 커멘드 실행
public class CustomerUpdateCommand implements Command {


  CustomerDao customerDao;
  Prompt prompt;

  public CustomerUpdateCommand(CustomerDao customerDao, Prompt prompt) {
    this.customerDao = customerDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호: ");

      Customer oldCustomer = null;
      try {
        oldCustomer = customerDao.findByNo(no);
      } catch (Exception e) {
        System.out.println("해당 번호의 게시글이 없습니다!");
        return;
      }
      Customer newCustomer = new Customer();

      newCustomer.setNo(oldCustomer.getNo());
      newCustomer.setCartype(prompt.inputString(String.format("차종(%s)? ", oldCustomer.getCartype()),
          oldCustomer.getCartype()));
      newCustomer.setCarNumbel(prompt.inputString(
          String.format("차량 번호(%s)? ", oldCustomer.getCarNumbel()), oldCustomer.getCarNumbel()));
      newCustomer.setPhoto(prompt.inputString(String.format("사진(%s)? ", oldCustomer.getPhoto()),
          oldCustomer.getPhoto()));
      newCustomer.setDiscountRatr(prompt.inputString(
          String.format("할인율(%s)?", oldCustomer.getDiscountRatr()), oldCustomer.getDiscountRatr()));
      newCustomer.setPayment(prompt.inputString(
          String.format("결제 금액(%s)? ", oldCustomer.getPayment()), oldCustomer.getPayment()));
      newCustomer.setGyeoljeYuhyeong(
          prompt.inputString(String.format("결제 유형(%s)? ", oldCustomer.getGyeoljeYuhyeong()),
              oldCustomer.getGyeoljeYuhyeong()));
      newCustomer.setParking(prompt.inputString(
          String.format("차량 주차장소(%s)?", oldCustomer.getParking()), oldCustomer.getParking()));
      newCustomer.setExitStatus(prompt.inputString(
          String.format("입·출차 장소(%s)?", oldCustomer.getExitStatus()), oldCustomer.getExitStatus()));
      newCustomer.setAcceptance(prompt.inputString(
          String.format("수납구분(%s)? ", oldCustomer.getAcceptance()), oldCustomer.getAcceptance()));


      if (newCustomer.equals(oldCustomer)) {
        System.out.println("고객 정보 변경을 취소 하였습니다.");
        return;
      }

      customerDao.update(newCustomer);
      System.out.println("고객 정보를 변경했습니다!");

    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}
