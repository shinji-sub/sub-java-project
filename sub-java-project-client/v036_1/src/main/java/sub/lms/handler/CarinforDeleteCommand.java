package sub.lms.handler;

import sub.lms.dao.CarinforDao;
import sub.lms.util.Prompt;

// "/carinfor/delete" 커멘드 실행
public class CarinforDeleteCommand implements Command {

  Prompt prompt;
  CarinforDao carinforDao;

  public CarinforDeleteCommand(CarinforDao carinforDao, Prompt prompt) {
    this.carinforDao = carinforDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호: ");

      if (carinforDao.delete(no) > 0) {
        System.out.println("자동차 정보 게시판을 삭제했습니다.");
      }else {
        System.out.println("해당 번호의 자동차 정보 게시판이 없습니다.");
      }
    } catch (Exception e) {
      System.out.println("삭제 실패!");
    }
  }
}


