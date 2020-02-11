package sub.lms;

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
  // 옵저버 관련코드 끝!

  public void service() {

    notifyApplicationInitialized();

    try (
        // 서버쪽 연결 준비
        // => 클라이언트의 연결을 9999번 포트에서 기다린다.
        ServerSocket serverSocket = new ServerSocket(9999)) {

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

  @SuppressWarnings("unchecked")
  int processRequest(Socket clientSocket) {
    try (Socket socket = clientSocket;
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

      System.out.println("통신을 위한 입출력 스트림을 준비하였음!");

      while (true) {
        String request = in.readUTF();
        System.out.println("클라이언트가 보낸 메시지를 수신하였음!");

        if (request.equals("quit")) {
          out.writeUTF("OK");
          out.flush();
          break;
        }

        if (request.equals("/server/stop")) {
          out.writeUTF("OK");
          out.flush();
          return 9;
        }

        List<Board> boards = (List<Board>) context.get("boardList");
        List<Customer> customers = (List<Customer>) context.get("customerList");
        List<Carinfor> carinfors = (List<Carinfor>) context.get("carinforList");

        if (request.equals("/board/list")) {
          out.writeUTF("OK");

          out.reset();

          out.writeObject(boards);

        } else if (request.equals("/board/add")) {
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
        } else if (request.equals("/board/detail")) {
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
        } else if (request.equals("/board/update")) {
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
        } else if (request.equals("/board/delete")) {
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

        } else if (request.equals("/customer/list")) {
          out.writeUTF("OK");
          out.reset();
          out.writeObject(customers);

        } else if (request.equals("/customer/add")) {
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
        } else if (request.equals("/customer/detail")) {
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
        } else if (request.equals("/customer/update")) {
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
        } else if (request.equals("/customer/delete")) {
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

        } else if (request.equals("/carinfor/list")) {
          out.writeUTF("OK");
          out.reset();
          out.writeObject(carinfors);

        } else if (request.equals("/carinfor/add")) {
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
        } else if (request.equals("/carinfor/detail")) {
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
        } else if (request.equals("/carinfor/update")) {
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
        } else if (request.equals("/carinfor/delete")) {
          try {
            int no = in.readInt();

            int index = -1;
            for (int i = 0; i < carinfors.size(); i++) {
              if (carinfors.get(i).getNo() == no) {
                index = i;
                break;
              }
            }

            if (index != -1) {
              carinfors.remove(index);
              out.writeUTF("OK");

            } else {
              out.writeUTF("FAIL");
              out.writeUTF("해당 번호의 차량정보가 없습니다.");
            }
          } catch (Exception e) {
            out.writeUTF("FAIL");
            out.writeUTF(e.getMessage());
          }

        } else {
          out.writeUTF("FAIL");
          out.writeUTF("요청한 명령을 처리할 수 없습니다.");
        }
        out.flush();
      }

      System.out.println("클라이언트로 메시지를 전송하였음!");

      return 0;

    } catch (Exception e) {
      System.out.println("예외 발생:");
      e.printStackTrace();
      return -1;
    }
  }

  public static void main(String[] args) {
    System.out.println("주차 관리 시스템입니다.");

    ServerApp app = new ServerApp();
    app.addApplicationContextListener(new DataLoaderListener());
    app.service();
  }
}
