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
    this.boardList = new ArrayList<>();
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
   
    for (Board b : arr) {
      System.out.printf("%d, %s, %s, %d\n",
          b.getNo(), b.getTitle(), b.getDate(), b.getViewCount());
    }

  }

  public void detailBoard() {
    System.out.print("게시물 번호? ");
    int index = input.nextInt();
    input.nextLine();

    Board board = this.boardList.get(index);
    
    
    if (board == null) {
      System.out.println("게시물이 번호가 유효하지 않습니다.");
      return;
    }
    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("등록일: %s\n", board.getDate());
    System.out.printf("조회소: %d\n", board.getViewCount());
  }
  
  public void updateBoard() {
    System.out.print("게시물 인덱스? ");
    int index = input.nextInt();
    input.nextLine();

    Board oldBoard = this.boardList.get(index);
    
    if (oldBoard == null) {
      System.out.println("게시물이 인덱스가 유효하지 않습니다.");
      return;
    }
    
    System.out.printf("내용(%s)? ", oldBoard.getTitle());
    String title = input.nextLine();
    
    if (title.length() == 0) {
      System.out.println("게시글 변경을 취소합니다.");
      return;
    }
    
    Board newBoard = new Board();
    newBoard.setNo(oldBoard.getNo());
    newBoard.setViewCount(oldBoard.getViewCount());
    newBoard.setTitle(title);
    newBoard.setDate(new Date(System.currentTimeMillis()));
    
    this.boardList.set(index, newBoard);
    System.out.println("게시글을 변경했습니다");

    System.out.println("저장하였습니다.");
}
  public void deleteBoard() {
    System.out.print("게시글 인덱스? ");
    int index = input.nextInt();
    input.nextLine();
    
    Board board = this.boardList.get(index);
    
    if (board == null) {
      System.out.println("게시글 인덱스가 유효하지 않습니다.");
      return;
    }
    this.boardList.remove(index);
    
    System.out.println("게시글을 삭제하였습니다.");
  }
}