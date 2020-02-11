package sub.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sub.lms.domain.Carinfor;
import sub.lms.util.Prompt;

// "/carinfor/detail" 커멘드 실행
public class CarinforDetailCommand implements Command {
  ObjectOutputStream out;
  ObjectInputStream in;
  Prompt prompt;


  public CarinforDetailCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
    this.out = out;
    this.in = in;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호: ");

      out.writeUTF("/carinfor/detail");
      out.writeInt(no);
      out.flush();

      String response = in.readUTF();

      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }

      Carinfor carinfor = (Carinfor) in.readObject();
      System.out.printf("번호: %s\n", carinfor.getNo());
      System.out.printf("차종: %s\n", carinfor.getCarType());
      System.out.printf("차량 번호: %s\n", carinfor.getCarNumber());
      System.out.printf("차량 위치: %s\n", carinfor.getParking());
      System.out.printf("차량 입차 날짜 : %s\n", carinfor.getDatas());
      System.out.printf("차량 출차 날짜: %s\n", carinfor.getDeparture());
    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}


