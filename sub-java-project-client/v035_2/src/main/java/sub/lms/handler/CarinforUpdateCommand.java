package sub.lms.handler;

import sub.lms.dao.CarinforDao;
import sub.lms.domain.Carinfor;
import sub.lms.util.Prompt;

// "carinfor/update" 커멘드 실행
public class CarinforUpdateCommand implements Command {

  CarinforDao carinforDao;
  Prompt prompt;


  public CarinforUpdateCommand(CarinforDao carinforDao, Prompt prompt) {
    this.carinforDao = carinforDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호: ");

      Carinfor oldCarinfor = null;
      try {
        oldCarinfor = carinforDao.findByNo(no);
      } catch (Exception e) {
        System.out.println("해당 번호의 게시글이 없습니다!");
        return;
      }

      Carinfor newCarinfor = new Carinfor();

      newCarinfor.setNo(oldCarinfor.getNo());

      newCarinfor.setCarType(prompt.inputString(String.format("차종(%s)", oldCarinfor.getCarType()),
          oldCarinfor.getCarType()));

      newCarinfor.setCarNumber(prompt.inputString(
          String.format("자동차 번호(%s)?", oldCarinfor.getCarNumber()), oldCarinfor.getCarNumber()));
      newCarinfor.setParking(prompt.inputString(
          String.format("차량 위치(%s)?", oldCarinfor.getParking()), oldCarinfor.getParking()));
      newCarinfor.setDatas(prompt.inputDate(String.format("차랑 입차 날짜(%s)?", oldCarinfor.getDatas()),
          oldCarinfor.getDatas()));
      newCarinfor.setDeparture(prompt.inputDate(
          String.format("차랑 출차 날짜(%s)?", oldCarinfor.getDeparture()), oldCarinfor.getDeparture()));


      carinforDao.update(newCarinfor);
      System.out.println("자동차 정보를 변경했습니다.");

    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}
