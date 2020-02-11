package sub.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sub.lms.util.Prompt;

// "customer/delete" 커멘드 실행
public class CustomerDeleteCommand implements Command {


  ObjectOutputStream out;
  ObjectInputStream in;
  Prompt prompt;

  public CustomerDeleteCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
    this.out = out;
    this.in = in;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호: ");

      out.writeUTF("/customer/delete");
      out.writeInt(no);
      out.flush();

      String response = in.readUTF();

      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }
      System.out.println("고객 정보를 삭제했습니다.");
    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}
