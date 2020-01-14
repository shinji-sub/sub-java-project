package sub;

import java.util.Scanner;
import sub.handler.BoardHandler;
import sub.handler.CarinforHandler;
import sub.handler.CustomerHandler;
import sub.util.Prompt;
import sub.util.Stack;

public class Ex1 {


  static Scanner keyboard = new Scanner(System.in);
  
  static Stack<String> commandStack = new Stack<>();

  public static void main (String[] args) {
    
    Prompt prompt = new Prompt(keyboard);
    
    BoardHandler BoardHandler = new BoardHandler(prompt);
    CarinforHandler CarinfotHandler = new CarinforHandler(prompt);
    CustomerHandler CustomerHandler = new CustomerHandler(prompt);
    String command;

    do {
      System.out.print("\n명령 >");
      command = keyboard.nextLine();

      if (command.length() == 0)
        continue;
      
      commandStack.push(command);
      
      switch (command) {
        case "/carinfor/add" :
          CarinfotHandler.addCarinfor();
          break;

        case "/carinfor/list" :
          CarinfotHandler.listCarinfor();
          break;
        
        case "/carinfor/detail" :
          CarinfotHandler.detailCarinfor();
          break;
          
        case "/carinfor/update" :
          CarinfotHandler.updateCarinfor();
          break;
          
        case "/carinfor/delete" :
          CarinfotHandler.deleteCarinfor();
          break;
          
        case "/customer/add" :
          CustomerHandler.addCustomer();
          break;

          
        case "/customer/list" :
          CustomerHandler.listCustomer();
          break;

        case "/customer/detail" :
          CustomerHandler.detailCustomer();
          break;
          
        case "/customer/update" :
          CustomerHandler.updateCustomer();
          break;
          
        case "/customer/delete" :
          CustomerHandler.deleteCustomer();
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


        case "/board/update":
          BoardHandler.updateBoard();
          break;

        case "/board/delete":
          BoardHandler.deleteBoard();
          break;
          
        case "history":
         printCommandHistory();
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

  private static void printCommandHistory() {
    Stack<String> historyStack = (Stack<String>) commandStack.clone();
    int count = 0;
    while (!historyStack.empty()) {
      System.out.println(historyStack.pop());
      count++;
      
      if ((count % 5) == 0) {
        System.out.print(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q"))
          break;
      }
    }
  }

}




