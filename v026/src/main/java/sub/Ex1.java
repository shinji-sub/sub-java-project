package sub;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
        if (str.equalsIgnoreCase("q")) {
            break;
        }
      }
    }
  }

  private static void loadCarinforData() {
    File file = new File("./carinfor.data");

    try (DataInputStream in = 
         new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {
        int size = in.readInt();
        for (int i = 0; i < size; i++) {
            Carinfor carinfor = new Carinfor();
            carinfor.setNo(in.readInt());
            carinfor.setCarType(in.readUTF());
            carinfor.setCarNumber(in.readUTF());
            carinfor.setParking(in.readUTF());
            carinfor.setDatas(Date.valueOf(in.readUTF()));
            carinfor.setDeparture(Date.valueOf(in.readUTF()));
            carinforList.add(carinfor);
        }
      System.out.printf("총 %d 개의 자동차 정보 데이터를 로딩했습니다.\n", carinforList.size());

    } catch (IOException e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  private static void saveCarinforData() {
    File file = new File("./carinfor.data");

    try (DataOutputStream out = 
       new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
        out.writeInt(carinforList.size());
        for (Carinfor carinfor : carinforList) {
            out.writeInt(carinfor.getNo());
            out.writeUTF(carinfor.getCarType());
            out.writeUTF(carinfor.getCarNumber());
            out.writeUTF(carinfor.getParking());
            out.writeUTF(carinfor.getDatas().toString());
            out.writeUTF(carinfor.getDeparture().toString());
        }
        System.out.printf("총 %d 개의 자동차 정보 데이터를 저장했습니다.\n", carinforList.size());
        
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }


  private static void loadCustomerData() {
    File file = new File("./customer.data");

    try (DataInputStream in = 
        new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {
        int size = in.readInt();
        for (int i = 0; i < size; i++) {
            Customer customer = new Customer();
            customer.setNo(in.readInt());
            customer.setCartype(in.readUTF());
            customer.setCarNumbel(in.readUTF());
            customer.setPhoto(in.readUTF());
            customer.setDiscountRatr(in.readUTF());
            customer.setPayment(in.readUTF());
            customer.setGyeoljeYuhyeong(in.readUTF());
            customer.setParking(in.readUTF());
            customer.setExitStatus(in.readUTF());
            customer.setAcceptance(in.readUTF());
            customerList.add(customer);
        }
      System.out.printf("총 %d 개의 고객 정보 데이터를 로딩했습니다.\n", customerList.size());

    } catch (IOException e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  private static void saveCustomerData() {
    File file = new File("./customer.data");

    try (DataOutputStream out =
        new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
     out.writeInt(customerList.size());
     for (Customer customer : customerList) {
         out.writeInt(customer.getNo());
         out.writeUTF(customer.getCartype());
         out.writeUTF(customer.getCarNumbel());
         out.writeUTF(customer.getPhoto());
         out.writeUTF(customer.getDiscountRatr());
         out.writeUTF(customer.getPayment());
         out.writeUTF(customer.getGyeoljeYuhyeong());
         out.writeUTF(customer.getParking());
         out.writeUTF(customer.getExitStatus());
         out.writeUTF(customer.getAcceptance());
     }
      System.out.printf("총 %d 개의 고객 정보 데이터를 저장했습니다.\n", customerList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생!- " + e.getMessage());

    }
  }

  private static void loadBoardData() {
    File file = new File("./board.data");

    try (DataInputStream in = 
           new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {
        int size = in.readInt();
        for (int i = 0; i < size; i++) {
            Board board = new Board();
            board.setNo(in.readInt());
            board.setTitle(in.readUTF());
            board.setDate(Date.valueOf(in.readUTF()));
            board.setViewCount(in.readInt());
            String writer = in.readUTF();
            if (writer.length() > 0) {
                board.setWriter(writer);
            }
            boardList.add(board);
        }
      System.out.printf("총 %d 개의 게시물 데이터를 로딩했습니다.\n", boardList.size());

    } catch (IOException e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    } 
  }

  private static void saveBoardData() {
    File file = new File("./board.data");           

    try (DataOutputStream out =
      new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
     out.writeInt(boardList.size());
     for (Board board : boardList) {
         out.writeInt(board.getNo());
         out.writeUTF(board.getTitle());
         out.writeUTF(board.getDate().toString());
         out.writeInt(board.getViewCount());
         out.writeUTF(board.getWriter() == null ? "" : board.getWriter());
     }
      System.out.printf("총 %d 개의 게시물 데이터를 저장했습니다.\n", boardList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

    }
  }
}
