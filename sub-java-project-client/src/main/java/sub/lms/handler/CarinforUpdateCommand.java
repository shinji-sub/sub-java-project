package sub.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sub.lms.domain.Carinfor;
import sub.lms.util.Prompt;

// "carinfor/update" 커멘드 실행
public class CarinforUpdateCommand implements Command {


  ObjectOutputStream out;
  ObjectInputStream in;
  Prompt prompt;


  public CarinforUpdateCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
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
      Carinfor oldCarinfor = (Carinfor) in.readObject();
      Carinfor newCarinfor = new Carinfor();

      newCarinfor.setNo(oldCarinfor.getNo());
      newCarinfor.setCarType(prompt.inputString(String.format("차종(%s)", oldCarinfor.getCarType()),
          oldCarinfor.getCarType()));
      newCarinfor.setCarNumber(prompt.inputString(
          String.format("자동차 번호(%s)?", oldCarinfor.getCarNumber()), oldCarinfor.getCarNumber()));
      newCarinfor.setParking(prompt.inputString(
          String.format("차량 위치(%s)?", oldCarinfor.getParking()), oldCarinfor.getParking()));
      newCarinfor.setDatas(prompt.inputDate(String.format("차랑 입차 날짜(%s)?", oldCarinfor.getDatas()),
          oldCarinfor.getDatas()));
      newCarinfor.setDeparture(prompt.inputDate(
          String.format("차랑 출차 날짜(%s)?", oldCarinfor.getDeparture()), oldCarinfor.getDeparture()));


      if (newCarinfor.equals(oldCarinfor)) {
        System.out.println("자동차 정보 변경을 취소하였습니다.");
        return;
      }
      out.writeUTF("/carinfor/update");
      out.writeInt(no);
      out.flush();

      response = in.readUTF();
      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
      }

      System.out.println("자동차 정보를 변경했습니다.");
    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}
