package sub.lms.handler;

import sub.lms.dao.proxy.CarinforDaoProxy;
import sub.lms.util.Prompt;

// "/carinfor/delete" 커멘드 실행
public class CarinforDeleteCommand implements Command {

  Prompt prompt;
  CarinforDaoProxy carinforDao;

  public CarinforDeleteCommand(CarinforDaoProxy carinforDao, Prompt prompt) {
    this.carinforDao = carinforDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호: ");
      carinforDao.delete(no);

      System.out.println("자동차 정보 게시판 정보를 삭제하였습니다.");
    } catch (Exception e) {
      System.out.println("삭제 실패!");
    }
  }
}


