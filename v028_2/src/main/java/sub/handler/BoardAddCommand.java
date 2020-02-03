package sub.handler;

import java.sql.Date;
import java.util.List;
import sub.domain.Board;
import sub.util.Prompt;

// "/board/add" 커멘드 실행
public class BoardAddCommand implements Command {

  List<Board> boardList;

  Prompt prompt;

  public BoardAddCommand(Prompt prompt, List<Board> list) {
    this.prompt = prompt;
    this.boardList = list;
  }

  @Override
  public void execute() {
    Board board = new Board();

    board.setNo(prompt.inputInt("번호? "));
    board.setTitle(prompt.inputString("내용? "));
    board.setDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);

    this.boardList.add(board);

    System.out.println("저장하였습니다.");
  }

}
