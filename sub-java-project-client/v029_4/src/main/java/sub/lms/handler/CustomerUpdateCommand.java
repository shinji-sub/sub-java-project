package sub.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sub.lms.domain.Customer;
import sub.lms.util.Prompt;

// "/customer/update" 커멘드 실행
public class CustomerUpdateCommand implements Command {


  ObjectOutputStream out;
  ObjectInputStream in;
  Prompt prompt;

  public CustomerUpdateCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
    this.out = out;
    this.in = in;
    this.prompt = prompt;
  }



  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호: ");

      out.writeUTF("/customer/detail");
      out.writeInt(no);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }

      Customer oldCustomer = (Customer) in.readObject();
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
      out.writeUTF("/customer/update");
      out.writeObject(newCustomer);
      out.flush();

      response = in.readUTF();
      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }

      System.out.println("고객 정보를 변경했습니다!");

    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}
