package sub.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import sub.lms.domain.Carinfor;

// "/carinfor/list" 커멘드 실행
public class CarinforListCommand implements Command {
  ObjectOutputStream out;
  ObjectInputStream in;

  public CarinforListCommand(ObjectOutputStream out, ObjectInputStream in) {
    this.out = out;
    this.in = in;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void execute() {
    try {
      out.writeUTF("/carinfor/list");
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }
      List<Carinfor> carinfors = (List<Carinfor>) in.readObject();
      for (Carinfor c : carinfors) {
        System.out.printf("게시판 번호:%s, 차종:%s\n차량 번호 :%s, 차량 위치:%s\n입차 날짜:%s,출차날짜:%s\n", c.getNo(),
            c.getCarType(), c.getCarNumber(), c.getParking(), c.getDeparture(), c.getDatas(),
            c.getDeparture());
      }
    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}

