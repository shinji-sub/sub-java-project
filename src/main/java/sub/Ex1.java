package sub;

import java.util.Scanner;

public class Ex1 {


  static Scanner keyboard = new Scanner(System.in);

  public static void main (String[] args) {
    CarinforHandler.keyboard = keyboard;
    CustomerHandler.keyboard = keyboard;
    BoardHandler.keyboard = keyboard;
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




