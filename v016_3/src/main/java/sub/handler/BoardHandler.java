// 게시글 번호로 찾는 객체 코드를 관리하기 쉽게 별도의 메소드로 분리한다.
package sub.handler;

import java.sql.Date;
import sub.domain.Board;
import sub.util.ArrayList;
import sub.util.Prompt;


public class BoardHandler {

  ArrayList<Board> boardList;

  Prompt prompt;

  public BoardHandler(Prompt prompt) {
    this.prompt = prompt;
    this.boardList = new ArrayList<>();
  }

  public void addBoard() {
    Board board = new Board();

    board.setNo(prompt.inputInt("번호? "));
    board.setTitle(prompt.inputString("내용? "));
    board.setDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);

    this.boardList.add(board);

    System.out.println("저장하였습니다.");

  }
  public void listBoard() {
    Board[] arr = new Board[this.boardList.size()];
    this.boardList.toArray(arr);

    for (Board b : arr) {
      System.out.printf("%d, %s, %s, %d\n",
          b.getNo(), b.getTitle(), b.getDate(), b.getViewCount());
    }

  }

  public void detailBoard() {
    int index = indexOfBoard(prompt.inputInt("번호: "));

    if (index == -1) {
      System.out.println("해당 번호에 게시글이 없습니다.");
      return;
    }

    Board board = this.boardList.get(index);
    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("등록일: %s\n", board.getDate());
    System.out.printf("조회소: %d\n", board.getViewCount());
  }

  public void updateBoard() {
    int index = indexOfBoard(prompt.inputInt("번호: "));

    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    Board oldBoard = this.boardList.get(index);

    Board newBoard = new Board();

    newBoard.setNo(oldBoard.getNo());

    newBoard.setTitle(prompt.inputString(
        String.format("내용(%s)? ", oldBoard.getTitle()),    
        oldBoard.getTitle()));

    newBoard.setViewCount(oldBoard.getViewCount());

    newBoard.setDate(new Date(System.currentTimeMillis()));
    if (oldBoard.equals(newBoard)) {
      System.out.println("게시물 변경을 취소하였습니다.");
      return;
    }
    this.boardList.set(index, newBoard);
    System.out.println("게시물을 변경했습니다.");
  }

  public void deleteBoard() {

    int index = indexOfBoard(prompt.inputInt("번호: "));

    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    this.boardList.remove(index);

    System.out.println("게시글을 삭제하였습니다.");
  }

  private int indexOfBoard(int no) {
    for (int i =0; i < this.boardList.size(); i++) {
      if (this.boardList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}