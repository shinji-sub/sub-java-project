package sub;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import sub.domain.Board;
import sub.domain.Carinfor;
import sub.domain.Customer;
import sub.handler.BoardAddCommand;
import sub.handler.BoardDeleteCommand;
import sub.handler.BoardDetailCommand;
import sub.handler.BoardListCommand;
import sub.handler.BoardUpdateCommand;
import sub.handler.CarinforAddCommand;
import sub.handler.CarinforDeleteCommand;
import sub.handler.CarinforDetailCommand;
import sub.handler.CarinforListCommand;
import sub.handler.CarinforUpdateCommand;
import sub.handler.Command;
import sub.handler.CustomerAddCommand;
import sub.handler.CustomerDeleteCommand;
import sub.handler.CustomerDetailCommand;
import sub.handler.CustomerListCommand;
import sub.handler.CustomerUpdateCommand;
import sub.util.Prompt;

public class Ex1 {


  static Scanner keyboard = new Scanner(System.in);

  static Deque<String> commandStack = new ArrayDeque<>();
  static Queue<String> commandQueue = new LinkedList<>();

  public static void main(String[] args) {

    Prompt prompt = new Prompt(keyboard);
    HashMap<String, Command> commandMap = new HashMap<>();

    LinkedList<Board> boardList = new LinkedList<>();
    commandMap.put("/board/add", new BoardAddCommand(prompt, boardList));
    commandMap.put("/board/list", new BoardListCommand(boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(prompt, boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(prompt, boardList));
    commandMap.put("/boarddelete", new BoardDeleteCommand(prompt, boardList));

    ArrayList<Carinfor> carinforList = new ArrayList<>();
    commandMap.put("/carinfor/add", new CarinforAddCommand(prompt, carinforList));
    commandMap.put("/carinfor/list", new CarinforListCommand(carinforList));
    commandMap.put("/carinfor/detail", new CarinforDetailCommand(prompt, carinforList));
    commandMap.put("/carinfor/update", new CarinforUpdateCommand(prompt, carinforList));
    commandMap.put("/carinfor/delete", new CarinforDeleteCommand(prompt, carinforList));

    LinkedList<Customer> customerList = new LinkedList<>();
    commandMap.put("/customer/add", new CustomerAddCommand(prompt, customerList));
    commandMap.put("/customer/list", new CustomerListCommand(customerList));
    commandMap.put("/customer/detail", new CustomerDetailCommand(prompt, customerList));
    commandMap.put("/customer/update", new CustomerUpdateCommand(prompt, customerList));
    commandMap.put("/customer/delete", new CustomerDeleteCommand(prompt, customerList));
    String command;

    while (true) {
      System.out.print("\n명령 >");
      command = keyboard.nextLine();

      if (command.length() == 0)
        continue;

      if (command.equals("quit")) {
        System.out.println("안녕!");
        break;
      }
      if (command.equals("history")) {
        printCommandHistory(commandStack.iterator());
        continue;
      } else if (command.equals("history2")) {
        printCommandHistory(commandQueue.iterator());
        continue;
      }
      commandStack.push(command);

      commandQueue.offer(command);

      Command commandHandler = commandMap.get(command);

      if (commandHandler != null) {
        commandHandler.execute();
      } else {
        if (!command.equalsIgnoreCase("quit")) {
          System.out.println("실행할 수 없는 명령입니다.");
        }
      }
    }

    keyboard.close();
  }

  private static void printCommandHistory(Iterator<String> iterator) {
    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
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


