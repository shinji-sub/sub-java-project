package sub.parkingsystem;

import java.util.Scanner;
public class Ex2 {

  public static void main (String[]avgs) {
    Scanner keyboard = new Scanner(System.in);
    
    System.out.print("번호 ?: ");
    String no = keyboard.nextLine();
    
    System.out.print("차종?: ");
    String CarType = keyboard.nextLine();
    
    System.out.print("차량 번호?: ");
    String CarNunbel = keyboard.nextLine();
    
    System.out.print("사진?: ");
    String photo = keyboard.nextLine();
    
    System.out.print("할인률?: ");
    String DiscountRate = keyboard.nextLine();

    System.out.printf("결제 금액?: ");
    String Payment = keyboard.nextLine();
    
    System.out.print("결제 유형?: ");
    String GyeoljeYuhyeong = keyboard.nextLine();
    
    System.out.print("차량 주차 장소?: ");
    String parking = keyboard.nextLine();
    
    System.out.print("입·출차 상태?: ");
    String ExitStatus = keyboard.nextLine();
    
    System.out.print("수납 구분?: ");
    String acceptance = keyboard.nextLine();
    
    System.out.println();
    
    System.out.printf("번호 : %s\n" , no);
    System.out.printf("차종 : %s\n" , CarType);
    System.out.printf("차량 번호 : %s\n" , CarNunbel);
    System.out.printf("사진 : %s\n" , photo);
    System.out.printf("할인률 : %s" , DiscountRate);
    System.out.println("%");
    System.out.printf("결제 금액 : %s" , Payment);
    System.out.println("원");
    System.out.printf("결제 유형 : %s" , GyeoljeYuhyeong);
    System.out.printf("차량 주차 장소 : %s\n" , parking);
    System.out.printf("차량 상태 : %s\n" , ExitStatus);
    System.out.printf("차량 구분 : %s\n" , acceptance);
      keyboard.close();
  }
}
