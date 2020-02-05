// LMS 클라이언트
package sub.lms;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {

  public static void main(String[] args) {
    System.out.println("클라이언트 수업관리 시스템 입니다!");

    String serverAddr = null;
    int port = 0;
    Scanner keyScan = new Scanner(System.in);
    try {
      System.out.println("서버? ");
      serverAddr = keyScan.nextLine();

      System.out.println("포트? ");
      port = Integer.parseInt(keyScan.nextLine());
    } catch (Exception e) {
      System.out.println("서버 주소 또는 포트 번호가 유효하지 않습니다!");
      keyScan.close();
      return;
    }
    try (Socket socket = new Socket(serverAddr, port);

        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream())) {


      System.out.println("서버와 연결되었음!");

      System.out.print("서버에 보낼 메시지: ");
      String sendMsg = keyScan.nextLine();
      out.println(sendMsg);

      System.out.println("서버에 메시지를 전송하였음! ");
      String message = in.nextLine();
      System.out.println("서버로부터 메시지를 수신하였음!");

      System.out.println("서버 : " + message);
    } catch (Exception e) {
      System.out.println("예외 발생: ");
      e.printStackTrace();
    }
    keyScan.close();
  }
}
