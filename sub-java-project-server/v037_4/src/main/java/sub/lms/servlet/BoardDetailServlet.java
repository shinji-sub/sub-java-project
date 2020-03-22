package sub.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import sub.lms.dao.BoardDao;
import sub.lms.domain.Board;
import sub.util.Prompt;

public class BoardDetailServlet implements Servlet {

  BoardDao boardDao;

  public BoardDetailServlet(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {


    int no = Prompt.getInt(in, out, "번호? ");

    Board board = boardDao.findByNo(no);

    if (board != null) {
      out.printf("번호: %d\n", board.getNo());
      out.printf("제목: %s\n", board.getTitle());
      out.printf("등록일: %s\n", board.getDate());
      out.printf("조회수: %d\n", board.getViewCount());

    } else {
      out.println("해당 번호의 게시물이 없습니다.");
    }

  }
}

