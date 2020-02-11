package sub.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import sub.lms.domain.Customer;

// "/customer/list" 커멘드 실행
public class CustomerListCommand implements Command {

  ObjectOutputStream out;
  ObjectInputStream in;


  public CustomerListCommand(ObjectOutputStream out, ObjectInputStream in) {
    this.out = out;
    this.in = in;
  }



  @SuppressWarnings("unchecked")
  @Override
  public void execute() {
    try {
      out.writeUTF("/customer/list");
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }


      List<Customer> customers = (List<Customer>) in.readObject();
      for (Customer m : customers) {
        System.out.printf(
            "번호:%s, 차종:%s\n차량 번호 :%s, 사진:%s\n할인율:%s, 결제금액:%s\n결제유형:%s, "
                + "차량 주차장소:%s\n입·출차 상태:%s, 수납 구분:%s\n",
            m.getNo(), m.getCartype(), m.getCarNumbel(), m.getPhoto(), m.getDiscountRatr(),
            m.getPayment(), m.getGyeoljeYuhyeong(), m.getParking(), m.getExitStatus(),
            m.getAcceptance());
      }
    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}
