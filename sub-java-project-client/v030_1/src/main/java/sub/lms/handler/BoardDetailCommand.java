package sub.lms.handler;

import sub.lms.dao.proxy.BoardDaoProxy;
import sub.lms.domain.Board;
import sub.lms.util.Prompt;

// "/board/detail" 커멘드 실행
public class BoardDetailCommand implements Command {

  BoardDaoProxy boardDao;
  Prompt prompt;

  public BoardDetailCommand(BoardDaoProxy boardDao, Prompt prompt) {
    this.boardDao = boardDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호? ");

      Board board = boardDao.findByNo(no);
      System.out.printf("번호: %d\n", board.getNo());
      System.out.printf("제목: %s\n", board.getTitle());
      System.out.printf("등록일: %s\n", board.getDate());
      System.out.printf("조회수: %d\n", board.getViewCount());
    } catch (Exception e) {
      System.out.println("조회 실패!");
    }
  }
}
