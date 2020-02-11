package sub.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sub.lms.util.Prompt;

// "/carinfor/delete" 커멘드 실행
public class CarinforDeleteCommand implements Command {


  ObjectOutputStream out;
  ObjectInputStream in;
  Prompt prompt;


  public CarinforDeleteCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
    this.out = out;
    this.in = in;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호: ");

      out.writeUTF("/carinfor/delete");
      out.writeInt(no);
      out.flush();

      String response = in.readUTF();

      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }

      System.out.println("자동차 정보 게시판 정보를 삭제하였습니다.");
    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}


