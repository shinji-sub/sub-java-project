package sub.lms;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import sub.lms.context.ApplicationContextListener;
import sub.lms.dao.json.BoardJsonFileDao;
import sub.lms.dao.json.CarinforJsonFileDao;
import sub.lms.dao.json.CustomerJsonFileDao;
import sub.lms.servlet.BoardAddServlet;
import sub.lms.servlet.BoardDeleteServlet;
import sub.lms.servlet.BoardDetailServlet;
import sub.lms.servlet.BoardListServlet;
import sub.lms.servlet.BoardUpdateServlet;
import sub.lms.servlet.CarinforAddServlet;
import sub.lms.servlet.CarinforDeleteServlet;
import sub.lms.servlet.CarinforDetailServlet;
import sub.lms.servlet.CarinforListServlet;
import sub.lms.servlet.CarinforUpdateServlet;
import sub.lms.servlet.CustomerAddServlet;
import sub.lms.servlet.CustomerDeleteServlet;
import sub.lms.servlet.CustomerDetailServlet;
import sub.lms.servlet.CustomerListServlet;
import sub.lms.servlet.CustomerUpdateServlet;
import sub.lms.servlet.Servlet;

public class ServerApp {

  Set<ApplicationContextListener> listeners = new HashSet<>();
  Map<String, Object> context = new HashMap<>();

  Map<String, Servlet> servletMap = new HashMap<>();


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

  public void service() {

    notifyApplicationInitialized();

    BoardJsonFileDao boardDao = (BoardJsonFileDao) context.get("boardDao");
    CustomerJsonFileDao customerDao = (CustomerJsonFileDao) context.get("customerDao");
    CarinforJsonFileDao carinforDao = (CarinforJsonFileDao) context.get("carinforDao");

    servletMap.put("/board/list", new BoardListServlet(boardDao));
    servletMap.put("/board/add", new BoardAddServlet(boardDao));
    servletMap.put("/board/detail", new BoardDetailServlet(boardDao));
    servletMap.put("/board/update", new BoardUpdateServlet(boardDao));
    servletMap.put("/board/delete", new BoardDeleteServlet(boardDao));

    servletMap.put("/carinfor/list", new CarinforListServlet(carinforDao));
    servletMap.put("/carinfor/add", new CarinforAddServlet(carinforDao));
    servletMap.put("/carinfor/detail", new CarinforDetailServlet(carinforDao));
    servletMap.put("/carinfor/updata", new CarinforUpdateServlet(carinforDao));
    servletMap.put("/carinfor/delete", new CarinforDeleteServlet(carinforDao));

    servletMap.put("/customer/list", new CustomerListServlet(customerDao));
    servletMap.put("/customer/add", new CustomerAddServlet(customerDao));
    servletMap.put("/customer/detaile", new CustomerDetailServlet(customerDao));
    servletMap.put("/customer/update", new CustomerUpdateServlet(customerDao));
    servletMap.put("/customer/delete", new CustomerDeleteServlet(customerDao));

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
            quit(out);
            return 0;
          case "/server/stop":
            quit(out);
            return 9;
        }

        Servlet servlet = servletMap.get(request);

        if (servlet != null) {

          try {
            servlet.service(in, out);

          } catch (Exception e) {
            out.writeUTF("FAIL");
            out.writeUTF(e.getMessage());

            System.out.println("클라이언트 요청 처리 중 오류 발생");
            e.printStackTrace();
          }
        } else {
          notFound(out);
        }
        out.flush();
        System.out.println("클라이언트에게 응답하였음!");
        System.out.println("---------------------------");
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

  public static void main(String[] args) {
    System.out.println("주차 관리 시스템입니다.");

    ServerApp app = new ServerApp();
    app.addApplicationContextListener(new DataLoaderListener());
    app.service();
  }
}
