package sub.handler;

import java.sql.Date;
import java.util.Scanner;
import sub.domain.Board;
import sub.util.ArrayList;


public class BoardHandler {

  ArrayList<Board> boardList;

  Scanner input;

  public BoardHandler(Scanner input) {
    this.input = input;
    this.boardList = new ArrayList<>();
  }

  public BoardHandler(Scanner input, int capacity) {
    this.input = input;
    boardList = new ArrayList<>();
  }



  public void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.setNo(input.nextInt());
    input.nextLine();

    System.out.print("내용? ");
    board.setTitle(input.nextLine());

    board.setDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);

    this.boardList.add(board);
    
    System.out.println("저장하였습니다.");

  }
  public void listBoard() {
    Board[] arr = new Board[this.boardList.size()];
   this.boardList.toArray(arr);
   
    for (Object obj : arr) {
    Board b = (Board)obj;
      System.out.printf("%d, %s, %s, %d\n",
          b.getNo(), b.getTitle(), b.getDate(), b.getViewCount());
    }

  }

  public void detailBoard() {
    System.out.print("게시물 번호? ");
    int index = input.nextInt();
    input.nextLine();

    Board board = (Board) this.boardList.get(index);
    
    
    if (board == null) {
      System.out.println("게시물이 번호가 유효하지 않습니다.");
      return;
    }
    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("등록일: %s\n", board.getDate());
    System.out.printf("조회소: %d\n", board.getViewCount());
  }


}
