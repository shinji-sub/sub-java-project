package sub.lms.handler;

import java.util.List;
import sub.lms.dao.proxy.BoardDaoProxy;
import sub.lms.domain.Board;

// "/board/list" 커멘드 실행
public class BoardListCommand implements Command {

  BoardDaoProxy boardDao;

  public BoardListCommand(BoardDaoProxy boardDao) {
    this.boardDao = boardDao;
  }


  @Override
  public void execute() {
    try {

      List<Board> boards = boardDao.findAll();
      for (Board b : boards) {
        System.out.printf("%d, %s, %s, %d\n", b.getNo(), b.getTitle(), b.getDate(),
            b.getViewCount());
      }
    } catch (Exception e) {
      System.out.println("조회 실패!");
    }
  }
}
