package sub.lms;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import sub.lms.context.ApplicationContextListener;
import sub.lms.domain.Board;
import sub.lms.domain.Carinfor;
import sub.lms.domain.Customer;

public class ServerApp {

  Set<ApplicationContextListener> listeners = new HashSet<>();
  Map<String, Object> context = new HashMap<>();

  List<Board> boards;
  List<Customer> customers;
  List<Carinfor> carinfors;

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void removeApplicationContextListener(ApplicationContextListener listener) {
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

    boards = (List<Board>) context.get("boardList");
    customers = (List<Customer>) context.get("customerList");
    carinfors = (List<Carinfor>) context.get("carinforList");

    try (ServerSocket serverSocket = new ServerSocket(9999)) {

      System.out.println("클라이언트 연결 대기중...");

      while (true) {
        Socket socket = serverSocket.accept();
        System.out.println("클라이언트와 연결되었음!");

        if (processRequest(socket) == 9) {
          break;
        }

        System.out.println("--------------------------------------");
      }

    } catch (Exception e) {
      System.out.println("서버 준비 중 오류 발생!");
    }

    notifyApplicationDestroyed();

  }

  int processRequest(Socket clientSocket) {

    try (Socket socket = clientSocket;
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

      System.out.println("통신을 위한 입출력 스트림을 준비하였음!");

      while (true) {
        String request = in.readUTF();
        System.out.println("클라이언트가 보낸 메시지를 수신하였음!");

        switch (request) {
          case "quit":
            return 0;
          case "/server/stop":
            quit(out);
            return 9;
          case "/board/list":
            listBoard(out);
            break;
          case "/board/add":
            addBoard(in, out);
            break;
          case "/board/detail":
            detailBoard(in, out);
            break;
          case "/board/update":
            updateBoard(in, out);
            break;
          case "/board/delete":
            deleteBoard(in, out);
            break;
          case "/customer/list":
            listCustomer(out);
            break;
          case "/customer/add":
            addCustomer(in, out);
            break;
          case "/customer/detail":
            detailCustomer(in, out);
            break;
          case "/customer/update":
            updateCustomer(in, out);
            break;
          case "/customer/delete":
            deleteCustomer(in, out);
            break;
          case "/carinfor/list":
            listCarinfor(out);
            break;
          case "/carinfor/add":
            addCarinfor(in, out);
            break;
          case "/carinfor/detail":
            detailCarinfor(in, out);
            break;
          case "/carinfor/update":
            updateCarinfor(in, out);
            break;
          case "/carinfor/delete":
            deleteCarinfor(in, out);
            break;
          default:
            notFound(out);
        }
        out.flush();
        System.out.println("클라이언트에게 응답하였음!");
      }
    } catch (Exception e) {
      System.out.println("예외 발생:");
      e.printStackTrace();
      return -1;
    }
  }

  private void notFound(ObjectOutputStream out) throws IOException {
    out.writeUTF("FAIL");
    out.writeUTF("요청한 명령을 처리할 수 없습니다.");
  }

  private void quit(ObjectOutputStream out) throws IOException {
    out.writeUTF("OK");
    out.flush();
  }


  private void updateCarinfor(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      Carinfor carinfor = (Carinfor) in.readObject();

      int index = -1;
      for (int i = 0; i < carinfors.size(); i++) {
        if (carinfors.get(i).getNo() == carinfor.getNo()) {
          index = i;
          break;
        }
      }

      if (index != -1) {
        carinfors.set(index, carinfor);
        out.writeUTF("OK");
      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 번호의 차량정보가 없습니다.");
      }

    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }

  private void detailCarinfor(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      int no = in.readInt();

      Carinfor carinfor = null;
      for (Carinfor c : carinfors) {
        if (c.getNo() == no) {
          carinfor = c;
          break;
        }
      }

      if (carinfor != null) {
        out.writeUTF("OK");
        out.writeObject(carinfor);

      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 번호의 차량정보가 없습니다.");
      }
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }

  private void addCarinfor(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      Carinfor carinfor = (Carinfor) in.readObject();

      int i = 0;
      for (; i < carinfors.size(); i++) {
        if (carinfors.get(i).getNo() == carinfor.getNo()) {
          break;
        }
      }

      if (i == carinfors.size()) {
        carinfors.add(carinfor);
        out.writeUTF("OK");

      } else {
        out.writeUTF("FAIL");
        out.writeUTF("같은 번호의 차량이 있습니다.");
      }

    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }

  private void listCarinfor(ObjectOutputStream out) throws IOException {
    try {
      out.writeUTF("OK");
      out.reset();
      out.writeObject(carinfors);
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }

  private void deleteCarinfor(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      int no = in.readInt();

      int index = -1;
      for (int i = 0; i < customers.size(); i++) {
        if (customers.get(i).getNo() == no) {
          index = i;
          break;
        }
      }

      if (index != -1) {
        customers.remove(index);
        out.writeUTF("OK");

      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 번호의 고객정보가 없습니다.");
      }
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }


  private void deleteCustomer(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      int no = in.readInt();

      int index = -1;
      for (int i = 0; i < customers.size(); i++) {
        if (customers.get(i).getNo() == no) {
          index = i;
          break;
        }
      }

      if (index != -1) {
        customers.remove(index);
        out.writeUTF("OK");

      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 번호의 고객정보가 없습니다.");
      }
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }


  private void updateCustomer(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      Customer customer = (Customer) in.readObject();

      int index = -1;
      for (int i = 0; i < customers.size(); i++) {
        if (customers.get(i).getNo() == customer.getNo()) {
          index = i;
          break;
        }
      }

      if (index != -1) {
        customers.set(index, customer);
        out.writeUTF("OK");
      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 번호의 회원이 없습니다.");
      }
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }


  private void detailCustomer(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      int no = in.readInt();

      Customer customer = null;
      for (Customer m : customers) {
        if (m.getNo() == no) {
          customer = m;
          break;
        }
      }

      if (customer != null) {
        out.writeUTF("OK");
        out.writeObject(customer);

      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 번호의 고객정보가 없습니다.");
      }
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }

  private void addCustomer(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      Customer customer = (Customer) in.readObject();

      int i = 0;
      for (; i < customers.size(); i++) {
        if (customers.get(i).getNo() == customer.getNo()) {
          break;
        }
      }

      if (i == customers.size()) {
        customers.add(customer);
        out.writeUTF("OK");

      } else {
        out.writeUTF("FAIL");
        out.writeUTF("같은 번호의 고객이 있습니다.");
      }
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }


  private void listCustomer(ObjectOutputStream out) throws IOException {
    try {
      out.writeUTF("OK");
      out.reset();
      out.writeObject(customers);

    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }


  private void deleteBoard(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      int no = in.readInt();

      int index = -1;
      for (int i = 0; i < boards.size(); i++) {
        if (boards.get(i).getNo() == no) {
          index = i;
          break;
        }
      }

      if (index != -1) {
        boards.remove(index);
        out.writeUTF("OK");

      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 번호의 게시물이 없습니다.");
      }
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }


  private void updateBoard(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      Board board = (Board) in.readObject();

      int index = -1;
      for (int i = 0; i < boards.size(); i++) {
        if (boards.get(i).getNo() == board.getNo()) {
          index = i;
          break;
        }
      }

      if (index != -1) {
        boards.set(index, board);
        out.writeUTF("OK");
      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 번호의 게시물이 없습니다.");
      }
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }


  private void detailBoard(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      int no = in.readInt();

      Board board = null;
      for (Board b : boards) {
        if (b.getNo() == no) {
          board = b;
          break;
        }
      }

      if (board != null) {
        out.writeUTF("OK");
        out.writeObject(board);

      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 번호의 게시물이 없습니다.");
      }
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }


  private void addBoard(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      Board board = (Board) in.readObject();

      int i = 0;
      for (; i < boards.size(); i++) {
        if (boards.get(i).getNo() == board.getNo()) {
          break;
        }
      }

      if (i == boards.size()) {
        boards.add(board);
        out.writeUTF("OK");

      } else {
        out.writeUTF("FAIL");
        out.writeUTF("같은 번호의 게시물이 있습니다.");
      }
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }



  private void listBoard(ObjectOutputStream out) throws IOException {
    try {
      out.writeUTF("OK");

      out.reset();

      out.writeObject(boards);
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }


  public static void main(String[] args) {
    System.out.println("주차 관리 시스템입니다.");

    ServerApp app = new ServerApp();
    app.addApplicationContextListener(new DataLoaderListener());
    app.service();
  }
}
