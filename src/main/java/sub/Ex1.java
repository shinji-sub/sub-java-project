package sub;

import java.util.Scanner;
import sub.handler.BoardHandler;
import sub.handler.BoardHandler2;
import sub.handler.BoardHandler3;
import sub.handler.BoardHandler4;
import sub.handler.BoardHandler5;
import sub.handler.BoardHandler6;
import sub.handler.CarinforHandler;
import sub.handler.CustomerHandler;

public class Ex1 {


  static Scanner keyboard = new Scanner(System.in);

  public static void main (String[] args) {
    CarinforHandler.keyboard = keyboard;
    CustomerHandler.keyboard = keyboard;
    BoardHandler.keyboard = keyboard;
    BoardHandler2.keyboard = keyboard;
    BoardHandler3.keyboard = keyboard;
    BoardHandler4.keyboard = keyboard;
    BoardHandler5.keyboard = keyboard;
    BoardHandler6.keyboard = keyboard;
    String command;
    
    do {
      System.out.print("\n명령 >");
      command = keyboard.nextLine();

      switch (command) {
        case "/carinfor/add" :
          CarinforHandler.addCarinfor();

          break;

        case "/carinfor/list" :
          CarinforHandler.listCarinfor();

          break;

        case "/customer/add" :
          CustomerHandler.addCustomer();
          break;

        case "/customer/list" :
          CustomerHandler.listCustomer();
          break;

        case "/board/add" : 
          BoardHandler.addBoard();
          break;

        case "/board/list":
          BoardHandler.listBoard();
          break;
          
        case "/board/detail":
          BoardHandler.detailBoard();
          break;
        
        case "/board2/add" : 
          BoardHandler2.addBoard();
          break;

        case "/board2/list":
          BoardHandler2.listBoard();
          break;
          
        case "/board2/detail":
          BoardHandler2.detailBoard();
          break;
        
        case "/board3/add" : 
          BoardHandler3.addBoard();
          break;

        case "/board3/list":
          BoardHandler3.listBoard();
          break;
          
        case "/board3/detail":
          BoardHandler3.detailBoard();
          break;
          
        case "/board4/add" : 
          BoardHandler4.addBoard();
          break;

        case "/board4/list":
          BoardHandler4.listBoard();
          break;
          
        case "/board4/detail":
          BoardHandler4.detailBoard();
          break;
          
        case "/board5/add" : 
          BoardHandler5.addBoard();
          break;

        case "/board5/list":
          BoardHandler5.listBoard();
          break;
          
        case "/board5/detail":
          BoardHandler5.detailBoard();
          break;
          
        case "/board6/add" : 
          BoardHandler6.addBoard();
          break;

        case "/board6/list":
          BoardHandler6.listBoard();
          break;
          
        case "/board6/detail":
          BoardHandler6.detailBoard();
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




