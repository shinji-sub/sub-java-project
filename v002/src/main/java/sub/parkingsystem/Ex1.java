package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class Ex1 {
  // 주차장 입차 출차 시스템

  public static void main (String[] args) {
    Scanner keyboard = new Scanner(System.in);

    System.out.print("번호?: ");
    int no = keyboard.nextInt();

    keyboard.nextLine();
    
    System.out.print("차종?: ");
    String CarType = keyboard.next();
   
    
    System.out.print("차량번호?: ");
    String CarNumber = keyboard.next();

    System.out.print("차량 위치?: ");
    String parking = keyboard.next();
    
    keyboard.nextLine();
    
    System.out.print("차량 입차 날짜?: ");
    Date today = new Date(System.currentTimeMillis());

    keyboard.nextLine();
    
    System.out.print("차량 출차 날짜?: ");
    String Departure = keyboard.next();

    System.out.println();

    System.out.printf("번호 : %d\n ", no); // 게시판 번호
    System.out.printf("차종 :%s\n ", CarType); 
    System.out.printf("차량 번호 :%s\n ", CarNumber); 
    System.out.printf("차량 주차 위치 :%s\n" , parking);
    System.out.printf("차량 입차  날짜 :%s\n" , today);
    System.out.printf("차량 출차  날짜 :%s\n", Departure);
    
    keyboard.close();
  }
}
