package sub.lms.servlet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import sub.lms.domain.Board;

public class BoardListServlet implements Servlet {

  List<Board> boards;

  public BoardListServlet(List<Board> boards) {
    this.boards = boards;
  }

  public void service(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      out.writeUTF("OK");

      out.reset();

      out.writeObject(boards);
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }

}
