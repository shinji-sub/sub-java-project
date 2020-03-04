// LMS 클라이언트
package sub.lms;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import sub.lms.dao.BoardDao;
import sub.lms.dao.CarinforDao;
import sub.lms.dao.CustomerDao;
import sub.lms.dao.mariadb.BoadDaoImpl;
import sub.lms.dao.mariadb.CarinforDaoImpl;
import sub.lms.dao.mariadb.CustomerDaoImpl;
import sub.lms.handler.BoardAddCommand;
import sub.lms.handler.BoardDeleteCommand;
import sub.lms.handler.BoardDetailCommand;
import sub.lms.handler.BoardListCommand;
import sub.lms.handler.BoardUpdateCommand;
import sub.lms.handler.CarinforAddCommand;
import sub.lms.handler.CarinforDeleteCommand;
import sub.lms.handler.CarinforDetailCommand;
import sub.lms.handler.CarinforListCommand;
import sub.lms.handler.CarinforUpdateCommand;
import sub.lms.handler.Command;
import sub.lms.handler.CustomerAddCommand;
import sub.lms.handler.CustomerDeleteCommand;
import sub.lms.handler.CustomerDetailCommand;
import sub.lms.handler.CustomerListCommand;
import sub.lms.handler.CustomerUpdateCommand;
import sub.lms.util.Prompt;

public class ClientApp {

  Scanner keyboard = new Scanner(System.in);
  Prompt prompt = new Prompt(keyboard);

  Deque<String> commandStack;
  Queue<String> commandQueue;

  HashMap<String, Command> commandMap = new HashMap<>();

  public ClientApp() {

    commandStack = new ArrayDeque<>();
    commandQueue = new LinkedList<>( );


    BoardDao boardDao = new BoadDaoImpl();
    CustomerDao customerDao = new CustomerDaoImpl();
    CarinforDao carinforDao = new CarinforDaoImpl();

    commandMap.put("/board/list", new BoardListCommand(boardDao));
    commandMap.put("/board/add", new BoardAddCommand(boardDao, prompt));
    commandMap.put("/board/detail", new BoardDetailCommand(boardDao, prompt));
    commandMap.put("/board/update", new BoardUpdateCommand(boardDao, prompt));
    commandMap.put("/board/delete", new BoardDeleteCommand(boardDao, prompt));

    commandMap.put("/customer/list", new CustomerListCommand(customerDao));
    commandMap.put("/customer/add", new CustomerAddCommand(customerDao, prompt));
    commandMap.put("/customer/detail", new CustomerDetailCommand(customerDao, prompt));
    commandMap.put("/customer/update", new CustomerUpdateCommand(customerDao, prompt));
    commandMap.put("/customer/delete", new CustomerDeleteCommand(customerDao, prompt));

    commandMap.put("/carinfor/list", new CarinforListCommand(carinforDao));
    commandMap.put("/carinfor/add", new CarinforAddCommand(carinforDao, prompt));
    commandMap.put("/carinfor/detail", new CarinforDetailCommand(carinforDao, prompt));
    commandMap.put("/carinfor/update", new CarinforUpdateCommand(carinforDao, prompt));
    commandMap.put("/carinfor/delete", new CarinforDeleteCommand(carinforDao, prompt));
  }

  public void service() {

    while (true) {
      String command;
      command = prompt.inputString("\n명령> ");

      if (command.length() == 0) {
        continue;
      }

      if (command.equals("history")) {
        printCommandHistory(commandStack.iterator());
        continue;
      } else if (command.equals("history2")) {
        printCommandHistory(commandQueue.iterator());
        continue;
      } else if (command.equals("quit")) {
        break;
      }

      commandStack.push(command);
      commandQueue.offer(command);

      processCommand(command);
    }
    keyboard.close();
  }

  private void processCommand(String command) {
    Command commandHandler = commandMap.get(command);
    if (commandHandler == null) {
      System.out.println("실행할 수 없는 명령입니다.");
      return;
    }
    commandHandler.execute();
  }

  private void printCommandHistory(Iterator<String> iterator) {
    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      count++;

      if ((count % 5) == 0) {
        String str = prompt.inputString(":");
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    System.out.println("클라이언트 수업 관리 시스템입니다.");

    ClientApp app = new ClientApp();
    app.service();
  }
}