package sub.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import sub.lms.dao.PhotoBoardDao;
import sub.lms.domain.Customer;
import sub.lms.domain.PhotoBoard;

public class PhotoBoardAddServlet implements Servlet {

  PhotoBoardDao photoBoardDao;

  public PhotoBoardAddServlet(PhotoBoardDao photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    PhotoBoard photoBoard = new PhotoBoard();

    out.println("제목? ");
    out.println("!{}!");
    out.flush();
    photoBoard.setTitle(in.nextLine());

    out.println("수업 번호? ");
    out.println("!{}!");
    out.flush();

    Customer customer = new Customer();
    customer.setNo(Integer.parseInt(in.nextLine()));

    photoBoard.setCustomer(customer);

    if (photoBoardDao.insert(photoBoard) > 0) {
      out.println("새 사진 게시글을 등록했습니다.");

    } else {
      out.println("사진 게시글 등록에 실패했습니다.");
    }
  }
}

