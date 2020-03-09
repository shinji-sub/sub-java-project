package sub.lms.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import sub.lms.dao.CustomerDao;
import sub.lms.dao.PhotoBoardDao;
import sub.lms.domain.Customer;
import sub.lms.domain.PhotoBoard;

public class PhotoBoardListServlet implements Servlet {

  PhotoBoardDao photoBoardDao;
  CustomerDao customerDao;

  public PhotoBoardListServlet(PhotoBoardDao photoBoardDao, CustomerDao customerDao) {
    this.photoBoardDao = photoBoardDao;
    this.customerDao = customerDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("고객 번호? ");
    out.println("!{}!");
    out.flush();

    int customerNo = Integer.parseInt(in.nextLine());

    Customer customer = customerDao.findByNo(customerNo);

    if (customer == null) {
      out.println("고객 번호가 유효하지 않습니다.");
      return;
    }

    out.printf("차종: %s\n", customer.getCartype());
    out.println("-----------------------------------------------");

    List<PhotoBoard> photoBoards = photoBoardDao.findAllByCustomerNo(customerNo);
    for (PhotoBoard photoBoard : photoBoards) {
      out.printf("%d, %s, %s, %d\n", //
          photoBoard.getNo(), //
          photoBoard.getTitle(), //
          photoBoard.getDate(), //
          photoBoard.getViewCount() //
      );
    }
  }
}
