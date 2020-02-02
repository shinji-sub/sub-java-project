package sub.handler;

import java.util.Iterator;
import java.util.List;
import sub.domain.Board;
import sub.util.Prompt;

// "/board/list" 커멘드 실행
public class BoardListCommand implements Command {

  List<Board> boardList;

  Prompt prompt;

  public BoardListCommand(List<Board> list) {
    this.boardList = list;
  }


  @Override
  public void execute() {
    Iterator<Board> iterator = boardList.iterator();
    while (iterator.hasNext()) {
      final Board b = iterator.next();
      System.out.printf("%d, %s, %s, %d\n", b.getNo(), b.getTitle(), b.getDate(), b.getViewCount());
    }
  }
}
