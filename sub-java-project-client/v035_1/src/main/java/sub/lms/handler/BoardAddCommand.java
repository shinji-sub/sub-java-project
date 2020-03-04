package sub.lms.handler;

import sub.lms.dao.BoardDao;
import sub.lms.domain.Board;
import sub.lms.util.Prompt;

// "/board/add" 커멘드 실행
public class BoardAddCommand implements Command {

  Prompt prompt;
  BoardDao boardDao;

  public BoardAddCommand(BoardDao boardDao, Prompt prompt) {
    this.boardDao = boardDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    Board board = new Board();
    board.setTitle(prompt.inputString("내용? "));

    try {
      boardDao.insert(board);
      System.out.println("저장하였습니다.");

    } catch (Exception e) {
      System.out.println("저장 실패!");
    }
  }
}
