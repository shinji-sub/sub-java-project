// LMS 클라이언트
package sub.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
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

  public void service() {

    String serverAddr = null;
    int port = 0;

    try {
      serverAddr = prompt.inputString("서버? ");
      port = prompt.inputInt("포트? ");

    } catch (Exception e) {
      System.out.println("서버 주소 또는 포트 번호가 유효하지 않습니다!");
      keyboard.close();
      return;

    }
    try (Socket socket = new Socket(serverAddr, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      System.out.println("서버와 연결을 되었음!");

      processCommand(out, in);

      System.out.println("서버와 연결을 끊었음!");

    } catch (Exception e) {
      System.out.println("예외 발생:");
      e.printStackTrace();
    }

    keyboard.close();
  }

  private void processCommand(ObjectOutputStream out, ObjectInputStream in) {
    Deque<String> commandStack = new ArrayDeque<>();
    Queue<String> commandQueue = new LinkedList<>();

    HashMap<String, Command> commandMap = new HashMap<>();

    commandMap.put("/board/list", new BoardListCommand(out, in));
    commandMap.put("/board/add", new BoardAddCommand(out, in, prompt));
    commandMap.put("/board/detail", new BoardDetailCommand(out, in, prompt));
    commandMap.put("/board/update", new BoardUpdateCommand(out, in, prompt));
    commandMap.put("/board/delete", new BoardDeleteCommand(out, in, prompt));

    commandMap.put("/customer/list", new CustomerListCommand(out, in));
    commandMap.put("/customer/add", new CustomerAddCommand(out, in, prompt));
    commandMap.put("/customer/detail", new CustomerDetailCommand(out, in, prompt));
    commandMap.put("/customer/update", new CustomerUpdateCommand(out, in, prompt));
    commandMap.put("/customerember/delete", new CustomerDeleteCommand(out, in, prompt));

    commandMap.put("/carinfor/list", new CarinforListCommand(out, in));
    commandMap.put("/carinfor/add", new CarinforAddCommand(out, in, prompt));
    commandMap.put("/carinfor/detail", new CarinforDetailCommand(out, in, prompt));
    commandMap.put("/carinfor/update", new CarinforUpdateCommand(out, in, prompt));
    commandMap.put("/carinfor/delete", new CarinforDeleteCommand(out, in, prompt));

    try {
      while (true) {
        String command;
        command = prompt.inputString("\n명령> ");

        if (command.length() == 0)
          continue;

        if (command.equals("quit") || command.equals("/server/stop")) {
          out.writeUTF(command);
          out.flush();
          System.out.println("서버: " + in.readUTF());
          System.out.println("안녕!");
          break;
        } else if (command.equals("history")) {
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
            System.out.printf("명령어 실행 중 오류 발생: %s\n", e.getMessage());
          }
        } else {
          System.out.println("실행할 수 없는 명령입니다.");
        }
      }
    } catch (Exception e) {
      System.out.println("프로그램 실행 중 오류 발생!");
    }

    keyboard.close();

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
