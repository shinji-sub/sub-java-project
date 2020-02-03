package sub;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import sub.context.ApplicationContextListener;
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


  Scanner keyboard = new Scanner(System.in);

  Deque<String> commandStack = new ArrayDeque<>();
  Queue<String> commandQueue = new LinkedList<>();


  Set<ApplicationContextListener> listeners = new HashSet<>();

  Map<String, Object> context = new HashMap<>();

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void removeApplivationContextListener(ApplicationContextListener listener) {
    listeners.remove(listener);
  }

  private void notifyApplicationInitialized() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized(context);
    }
  }

  private void notifyApplicationDestroyed() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed(context);
    }
  }

  @SuppressWarnings("unchecked")
  public void service() {

    notifyApplicationInitialized();

    List<Carinfor> carinforList = (List<Carinfor>) context.get("carinforList");
    List<Board> boardList = (List<Board>) context.get("boardList");
    List<Customer> customerList = (List<Customer>) context.get("customerList");

    Prompt prompt = new Prompt(keyboard);
    HashMap<String, Command> commandMap = new HashMap<>();


    commandMap.put("/board/add", new BoardAddCommand(prompt, boardList));
    commandMap.put("/board/list", new BoardListCommand(boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(prompt, boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(prompt, boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(prompt, boardList));

    commandMap.put("/carinfor/add", new CarinforAddCommand(prompt, carinforList));
    commandMap.put("/carinfor/list", new CarinforListCommand(carinforList));
    commandMap.put("/carinfor/detail", new CarinforDetailCommand(prompt, carinforList));
    commandMap.put("/carinfor/update", new CarinforUpdateCommand(prompt, carinforList));
    commandMap.put("/carinfor/delete", new CarinforDeleteCommand(prompt, carinforList));


    commandMap.put("/customer/add", new CustomerAddCommand(prompt, customerList));
    commandMap.put("/customer/list", new CustomerListCommand(customerList));
    commandMap.put("/customer/detail", new CustomerDetailCommand(prompt, customerList));
    commandMap.put("/customer/update", new CustomerUpdateCommand(prompt, customerList));
    commandMap.put("/customer/delete", new CustomerDeleteCommand(prompt, customerList));

    String command;

    while (true) {
      System.out.print("\n명령 >");
      command = keyboard.nextLine();

      if (command.length() == 0) {
        continue;
      }

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
        try {
          commandHandler.execute();
        } catch (Exception e) {
          e.printStackTrace();
          System.out.printf("명령어 실행 중 오류발생 : %s\n", e.getMessage());
        }
      } else {
        if (!command.equalsIgnoreCase("quit")) {
          System.out.println("실행할 수 없는 명령입니다.");
        }
      }
    }

    keyboard.close();


    notifyApplicationDestroyed();
  }

  private void printCommandHistory(Iterator<String> iterator) {
    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      count++;

      if ((count % 5) == 0) {
        System.out.print(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }


  public static void main(String[] args) {
    Ex1 ex1 = new Ex1();

    ex1.addApplicationContextListener(new DataLoaderListener());
    ex1.addApplicationContextListener(new GreetinListener());
    ex1.service();
  }
}
