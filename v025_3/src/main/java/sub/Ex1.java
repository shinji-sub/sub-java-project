package sub;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import com.google.gson.Gson;
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

  static List<Carinfor> carinforList = new ArrayList<>();
  static List<Board> boardList = new ArrayList<>();
  static List<Customer> customerList = new ArrayList<>();

  public static void main(String[] args) {

    loadCarinforData();
    loadCustomerData();
    loadBoardData();

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
        try {
          commandHandler.execute();
        } catch (Exception e) {
          System.out.printf("명령어 실행 중 오류발생 : %s\n", e.getMessage());
        }
      } else {
        if (!command.equalsIgnoreCase("quit")) {
          System.out.println("실행할 수 없는 명령입니다.");
        }
      }
    }

    keyboard.close();
    saveCarinforData();
    saveCustomerData();
    saveBoardData();
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

  private static void loadCarinforData() {
    File file = new File("./carinfor.json");

    try (FileReader in = new FileReader(file)) {

      carinforList.addAll(Arrays.asList(new Gson().fromJson(in, Carinfor[].class)));
      System.out.printf("총 %d 개의 자동차 정보 데이터를 로딩했습니다.\n", carinforList.size());

    } catch (IOException e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  private static void saveCarinforData() {
    File file = new File("./carinfor.json");


    try (FileWriter out = new FileWriter(file)) {
      out.write(new Gson().toJson(carinforList));

      System.out.printf("총 %d 개의 자동차 정보 데이터를 저장했습니다.\n", carinforList.size());

    } catch (IOException e) {

    }
  }


  private static void loadCustomerData() {
    File file = new File("./customer.json");


    try (FileReader in = new FileReader(file)) {
      customerList.addAll(Arrays.asList(new Gson().fromJson(in, Customer[].class)));
      System.out.printf("총 %d 개의 고객 정보 데이터를 로딩했습니다.\n", customerList.size());

    } catch (IOException e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  private static void saveCustomerData() {
    File file = new File("./customer.json");

    try (FileWriter out = new FileWriter(file)) {
      out.write(new Gson().toJson(customerList));
      System.out.printf("총 %d 개의 고객 정보 데이터를 저장했습니다.\n", customerList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생!- " + e.getMessage());

    }
  }

  private static void loadBoardData() {
    File file = new File("./board.json");

    try (FileReader in = new FileReader(file)) {
      boardList.addAll(Arrays.asList(new Gson().fromJson(in, Board[].class)));
      System.out.printf("총 %d 개의 게시물 데이터를 로딩했습니다.\n", boardList.size());

    } catch (IOException e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  private static void saveBoardData() {
    File file = new File("./board.json");

    try (FileWriter out = new FileWriter(file)) {
      out.write(new Gson().toJson(boardList));

      System.out.printf("총 %d 개의 게시물 데이터를 저장했습니다.\n", boardList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());


    }
  }
}
