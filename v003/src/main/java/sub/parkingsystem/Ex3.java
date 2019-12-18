package sub.parkingsystem;

import java.sql.Date;

import java.util.Scanner;

public class Ex3 {

  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    
    System.out.print("번호? ");
    int no = keyboard.nextInt();
    
    keyboard.nextLine(); 
    System.out.print("내용 ?: ");
    String title = keyboard.nextLine();

    Date today = new Date(System.currentTimeMillis());
        int count = 0;
    
    keyboard.close();
    
  
    System.out.println();
    System.out.printf("번호:%d \n" , no);
    System.out.printf("내용:%s \n",title );
    System.out.printf("작성일:%s \n",today);
    System.out.printf("조회수:%d \n", count);
    
  }
}
// Date = new Date(System.currentTimeMillis());
