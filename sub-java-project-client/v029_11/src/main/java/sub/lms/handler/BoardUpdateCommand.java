package sub.lms.handler;

import java.sql.Date;
import sub.lms.dao.proxy.BoardDaoProxy;
import sub.lms.domain.Board;
import sub.lms.util.Prompt;

// "/board/update 커멘드 실행
public class BoardUpdateCommand implements Command {

  BoardDaoProxy boardDao;
  Prompt prompt;

  public BoardUpdateCommand(BoardDaoProxy boardDao, Prompt prompt) {
    this.boardDao = boardDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호? ");

      Board oldBoard = null;
      try {
        oldBoard = boardDao.findByNo(no);
      } catch (Exception e) {
        System.out.println("해당 번호의 게시글이 없습니다!");
        return;
      }

      Board newBoard = new Board();

      newBoard.setNo(oldBoard.getNo());
      newBoard.setTitle(
          prompt.inputString(String.format("내용(%s)? ", oldBoard.getTitle()), oldBoard.getTitle()));
      newBoard.setViewCount(oldBoard.getViewCount());
      newBoard.setDate(new Date(System.currentTimeMillis()));

      if (newBoard.equals(oldBoard)) {
        System.out.println("게시물 변경을 취소하였습니다.");
        return;
      }

      boardDao.update(newBoard);
      System.out.println("게시물을 변경했습니다.");

    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }

  }
}
