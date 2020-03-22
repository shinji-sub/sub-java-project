package sub.lms.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import sub.lms.dao.PhotoBoardDao;
import sub.lms.dao.PhotoFileDao;
import sub.lms.domain.PhotoBoard;
import sub.lms.domain.PhotoFile;
import sub.util.Prompt;

public class PhotoBoardDetailServlet implements Servlet {

  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;

  public PhotoBoardDetailServlet(PhotoBoardDao photoBoardDao, PhotoFileDao photoFileDao) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int no = Prompt.getInt(in, out, "사진 게시글 번호? ");

    PhotoBoard photoBoard = photoBoardDao.findByNo(no);

    if (photoBoard != null) {
      out.printf("번호: %d\n", photoBoard.getNo());
      out.printf("제목: %s\n", photoBoard.getTitle());
      out.printf("등록일: %s\n", photoBoard.getDate());
      out.printf("조회수: %d\n", photoBoard.getViewCount());
      out.printf("고객정보: %s\n", photoBoard.getCustomer().getCarNumbel());
      out.println("사진 파일: ");

      List<PhotoFile> photoFiles = photoFileDao.findAll(photoBoard.getNo());
      for (PhotoFile photoFile : photoFiles) {
        out.printf("> %s\n", photoFile.getFilepath());
      }
    } else {
      out.println("해당 번호의 사진 게시글이 없습니다.");
    }
  }
}
