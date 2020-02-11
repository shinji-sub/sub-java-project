package sub.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sub.lms.domain.Carinfor;
import sub.lms.util.Prompt;

// "/carinfor/add 커멘드 실행
public class CarinforAddCommand implements Command {


  ObjectOutputStream out;
  ObjectInputStream in;
  Prompt prompt;


  public CarinforAddCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
    this.out = out;
    this.in = in;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    Carinfor carinfor = new Carinfor();

    carinfor.setNo(prompt.inputInt("게시판 번호?"));
    carinfor.setCarType(prompt.inputString("차종? "));
    carinfor.setCarNumber(prompt.inputString("차량번호? "));
    carinfor.setParking(prompt.inputString("차량 위치? "));
    carinfor.setDatas(prompt.inputDate("차량 입차 날짜? "));
    carinfor.setDeparture(prompt.inputDate("차량 출차 날짜? "));

    try {
      out.writeUTF("/carinfor/add");
      out.writeObject(carinfor);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }
      System.out.println("저장하였습니다.");
    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}

