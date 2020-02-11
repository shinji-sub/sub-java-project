package sub.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sub.lms.domain.Customer;
import sub.lms.util.Prompt;

// "/customer/detail" 커멘드 실행
public class CustomerDetailCommand implements Command {


  ObjectOutputStream out;
  ObjectInputStream in;
  Prompt prompt;

  public CustomerDetailCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
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
      Customer customer = (Customer) in.readObject();
      System.out.printf("번호: %s\n", customer.getNo());
      System.out.printf("차종: %s\n", customer.getCartype());
      System.out.printf("차량 번호: %s\n", customer.getCarNumbel());
      System.out.printf("사진: %s\n", customer.getPhoto());
      System.out.printf("할인율: %s\n", customer.getDiscountRatr());
      System.out.printf("결제금액: %s\n", customer.getPayment());
      System.out.printf("결제 유형: %s\n", customer.getGyeoljeYuhyeong());
      System.out.printf("차량 주차 장소: %s\n", customer.getParking());
      System.out.printf("입·출차 상태: %s\n", customer.getExitStatus());
      System.out.printf("수납구분: %s\n", customer.getAcceptance());
    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}
