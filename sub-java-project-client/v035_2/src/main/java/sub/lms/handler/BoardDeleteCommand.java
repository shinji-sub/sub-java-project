package sub.lms.handler;

import sub.lms.dao.BoardDao;
import sub.lms.util.Prompt;

// "/board/delete" 커멘드 실행
public class BoardDeleteCommand implements Command {

  Prompt prompt;
  BoardDao boardDao;

  public BoardDeleteCommand(BoardDao boardDao, Prompt prompt) {
    this.boardDao = boardDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호? ");
      if(boardDao.delete(no) > 0) {
        System.out.println("게시글을 삭제하였습니다.");
      } else {
        System.out.println("해당 번호의 게시글이 없습니다.");
      }

    } catch (Exception e) {
      System.out.println("삭제 실패!");
    }
  }
}
