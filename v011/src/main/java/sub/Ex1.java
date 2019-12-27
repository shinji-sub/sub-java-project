package sub;

import java.util.Scanner;
import sub.handler.BoardHandler;
import sub.handler.CarinforHandler;
import sub.handler.CustomerHandler;

public class Ex1 {


  static Scanner keyboard = new Scanner(System.in);

  public static void main (String[] args) {
   

    BoardHandler 게시판1 = new BoardHandler(keyboard);
    BoardHandler 게시판2 = new BoardHandler(keyboard, 200);
    BoardHandler 게시판3 = new BoardHandler(keyboard, 1000);
    BoardHandler 게시판4 = new BoardHandler(keyboard);
    BoardHandler 게시판5 = new BoardHandler(keyboard, 9000);
    BoardHandler 게시판6 = new BoardHandler(keyboard, 10000);

    CarinforHandler 주차정보 = new CarinforHandler(keyboard);

    CustomerHandler 고객정보 = new CustomerHandler(keyboard);

    String command;

    do {
      System.out.print("\n명령 >");
      command = keyboard.nextLine();

      switch (command) {
        case "/carinfor/add" :
          주차정보.addCarinfor();
          break;

        case "/carinfor/list" :
          주차정보.listCarinfor();
          break;

        case "/customer/add" :
          고객정보.addCustomer();
          break;

        case "/customer/list" :
          고객정보.listCustomer();
          break;

        case "/board/add" : 
          게시판1.addBoard();
          break;

        case "/board/list":
          게시판1.listBoard();
          break;

        case "/board/detail":
          게시판1.detailBoard();
          break;

        case "/board2/add" : 
          게시판2.addBoard();
          break;

        case "/board2/list":
          게시판2.listBoard();
          break;

        case "/board2/detail":
          게시판2.detailBoard();
          break;

        case "/board3/add" : 
          게시판3.addBoard();
          break;

        case "/board3/list":
          게시판3.listBoard();
          break;

        case "/board3/detail":
          게시판3.detailBoard();
          break;

        case "/board4/add" : 
          게시판4.addBoard();
          break;

        case "/board4/list":
          게시판4.listBoard();
          break;

        case "/board4/detail":
          게시판4.detailBoard();
          break;

        case "/board5/add" : 
          게시판5.addBoard();
          break;

        case "/board5/list":
          게시판5.listBoard();
          break;

        case "/board5/detail":
          게시판5.detailBoard();
          break;

        case "/board6/add" : 
          게시판6.addBoard();
          break;

        case "/board6/list":
          게시판6.listBoard();
          break;

        case "/board6/detail":
          게시판6.detailBoard();
          break;

        default:
          if (!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 명령어입니다.");
          }
      }

    } while (!command.equalsIgnoreCase("quit"));

    System.out.println("안녕!");

    keyboard.close();
  }


}




