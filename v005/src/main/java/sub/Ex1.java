package sub;

import java.util.Scanner;
import java.sql.Date;

public class Ex1 {

  public static void main (String[] args) {

    Scanner keyboard = new Scanner(System.in);

    class CarInfor{
      int no;
      String CarType;
      String CarNumber;
      String parking;
      Date datas;
      String Departure;
    }

    final int CARINFOR_SIZE = 100;
   
    CarInfor[] carinfors = new CarInfor[CARINFOR_SIZE];
    int carinforCount = 0;


    class Customer {
      int no;
      String Cartype;
      String CarNumbel;
      String photo;
      String DiscountRatr;
      String Payment;
      String GyeoljeYuhyeong;
      String parking;
      String ExitStatus;
      String acceptance;
    }
    final int CUSTOMER_SIZE = 100;

    Customer[] customers = new Customer[CUSTOMER_SIZE]; 
    int customerCount = 0;

    class Board{
      int no;
      String title;
      Date date;
      int viewCount;
    }

    final int BOARD_SIZE = 100;

    Board[] boards = new Board[BOARD_SIZE];
    Date data;
    int boardCount = 0;

    String response;
    String command;

    do {
      System.out.print("\n명령 >");
      command = keyboard.nextLine();

      switch (command) {
        case "/cartype/add" :
          CarInfor carinfor = new CarInfor();

          System.out.printf("게시판 번호? ");
          carinfor.no = keyboard.nextInt();

          keyboard.nextLine();

          System.out.printf("차종? ");
          carinfor.CarType = keyboard.nextLine();

          System.out.printf("차량번호? ");
          carinfor.CarNumber = keyboard.nextLine();

          System.out.printf("차량 위치? ");
          carinfor.parking = keyboard.nextLine();

          //System.out.printf("차량 입차 날짜? ");

          carinfor.datas = new Date(System.currentTimeMillis());

          System.out.printf("차량 출차 날짜? ");
          carinfor.Departure = keyboard.nextLine();

          carinfors[carinforCount++] = carinfor;
          System.out.println("저장하였습니다.");

          break;

        case "/cartype/list" :
          for (int i = 0; i < carinforCount; i++) {
            CarInfor c = carinfors[i];
            System.out.printf("게시판 번호:%s, 차종:%s\n차량 번호 :%s, 차량 위치:%s\n입차 날짜:%s,출차날짜:%s\n",
                c.no, c.CarType, c.CarNumber, c.parking, 
                c.Departure,c.datas,c.Departure);
           
          }
          break;
        case "/customer/add" :

          Customer customer = new Customer();


          System.out.printf("번호?: ");
          customer.no =keyboard.nextInt();

          keyboard.nextLine();
          
          System.out.printf("차종?: ");
          customer.Cartype = keyboard.nextLine();


          System.out.printf("차량 번호?: ");
          customer.CarNumbel = keyboard.nextLine();

          System.out.printf("사진?: ");
          customer.photo = keyboard.nextLine();

          System.out.printf("할인률?: ");
          customer.DiscountRatr = keyboard.nextLine();

          System.out.printf("결제 금액?: ");
          customer.Payment = keyboard.nextLine();

          System.out.printf("결제 유형?: ");
          customer.GyeoljeYuhyeong = keyboard.nextLine();

          System.out.print("차량 주차 장소?: ");
          customer.parking = keyboard.nextLine();

          System.out.print("입·출차 상태?: ");
          customer.ExitStatus = keyboard.nextLine();

          System.out.print("수납 구분?: ");
          customer.acceptance = keyboard.nextLine();

          customers[customerCount++] = customer;
          System.out.println("저장하였습니다.");

          break;

        case "/customer/list" :
          for (int i = 0; i < customerCount; i++) {
            Customer m = customers[i];
            System.out.printf("번호:%s, 차종:%s\n차량 번호 :%s, 사진:%s\n할인율:%s, 결제금액:%s\n결제유형:%s, "
                + "차량 주차장소:%s\n입·출차 상태:%s, 수납 구분:%s\n",
                m.no, m.Cartype, m.CarNumbel, m.photo, 
                m.DiscountRatr, m.Payment, m.GyeoljeYuhyeong,
                m.parking, m.ExitStatus, m.acceptance);
          }

          break;

        case "/board/add" : 
          Board board = new Board();

          System.out.print("번호? ");
          board.no = keyboard.nextInt();
          keyboard.nextLine();

          System.out.print("내용? ");
          board.title = keyboard.nextLine();

          board.date = new Date(System.currentTimeMillis());
          board.viewCount = 0;

          boards[boardCount++] = board;

          break;

        case "/board/list":
          for (int i = 0; i < boardCount; i++) {
            Board b = boards[i];
            System.out.printf("%d, %s, %s, %d\n",
                b.no, b.title, b.date, b.viewCount);
          }
          break;

        default:
          if (!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 명령어입니다.");
          }
      }

    } while (!command.equalsIgnoreCase("quit"));

    System.out.println("안녕!");
    keyboard.close();
  }
}
