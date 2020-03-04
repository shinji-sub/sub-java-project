package sub.lms.handler;

import java.util.List;
import sub.lms.dao.BoardDao;
import sub.lms.domain.Board;

// "/board/list" 커멘드 실행
public class BoardListCommand implements Command {

  BoardDao boardDao;

  public BoardListCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }


  @Override
  public void execute() {
    try {
      List<Board> boards = boardDao.findAll();
      for (Board board : boards) {
        System.out.printf("%d, %s, %s, %s, %d\n", //
            board.getNo(), board.getTitle(), board.getDate(),board.getWriter(),
            board.getViewCount());
      }
    } catch (Exception e) {
      System.out.println("목록 조회 실패!");
    }
  }
}
