package sub.lms.servlet;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import sub.lms.dao.CarinforDao;
import sub.lms.dao.PhotoBoardDao;
import sub.lms.dao.PhotoFileDao;
import sub.lms.domain.Carinfor;
import sub.lms.domain.PhotoBoard;
import sub.lms.domain.PhotoFile;
import sub.util.Prompt;

public class PhotoBoardAddServlet implements Servlet {

  PhotoBoardDao photoBoardDao;
  CarinforDao carinforDao;
  PhotoFileDao photoFileDao;

  public PhotoBoardAddServlet(PhotoBoardDao photoBoardDao, CarinforDao carinforDao,
      PhotoFileDao photoFileDao) {
    this.photoBoardDao = photoBoardDao;
    this.carinforDao = carinforDao;
    this.photoFileDao = photoFileDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    PhotoBoard photoBoard = new PhotoBoard();
    photoBoard.setTitle(Prompt.getString(in, out, "제목? "));

    int CarinforNo = Prompt.getInt(in, out, "주차 번호? ");

    Carinfor carinfor = CarinforDao.findByNo(CarinforNo);
    if (carinfor == null) {
      out.println("고객 번호가 유효하지 않습니다.");
      return;
    }


    if (photoBoardDao.insert(photoBoard) > 0) {
      out.println("최소 한 개의 사진 파일을 등록해야 합니다.");
      out.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");

      ArrayList<PhotoFile> photoFiles = new ArrayList<>();

      while (true) {
        out.println("사진 파일? ");
        out.println("!{}!");
        out.flush();
        String filepath = in.nextLine();

        if (filepath.length() == 0) {
          if (photoFiles.size() > 0) {
            break;
          } else {
            out.println("최소 한 개의 사진 파일을 등록해야 합니다.");
            continue;
          }
        }

        photoFiles.add(new PhotoFile().setFilepath(filepath).setBoardNo(photoBoard.getNo()));
      }
      for (PhotoFile photoFile : photoFiles) {
        photoFileDao.insert(photoFile);
      }
      out.println("새 사진 게시글을 등록했습니다.");

    } else {
      out.println("사진 게시글 등록에 실패했습니다.");
    }
  }
}
