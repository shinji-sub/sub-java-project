package sub.handler;

import java.sql.Date;
import java.util.List;
import sub.domain.Board;
import sub.util.Prompt;

// "/board/update 커멘드 실행
public class BoardUpdateCommand implements Command {

  List<Board> boardList;

  Prompt prompt;

  public BoardUpdateCommand(Prompt prompt, List<Board> list) {
    this.prompt = prompt;
    this.boardList = list;
  }

  @Override
  public void execute() {

    int index = indexOfBoard(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    Board oldBoard = this.boardList.get(index);

    Board newBoard = new Board();

    newBoard.setNo(oldBoard.getNo());

    newBoard.setTitle(
        prompt.inputString(String.format("내용(%s)? ", oldBoard.getTitle()), oldBoard.getTitle()));

    newBoard.setViewCount(oldBoard.getViewCount());

    newBoard.setDate(new Date(System.currentTimeMillis()));

    if (oldBoard.equals(newBoard)) {
      System.out.println("게시물 변경을 취소하였습니다.");
      return;
    }
    this.boardList.set(index, newBoard);
    System.out.println("게시물을 변경했습니다.");
  }

  private int indexOfBoard(int no) {
    for (int i = 0; i < this.boardList.size(); i++) {
      if (this.boardList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
