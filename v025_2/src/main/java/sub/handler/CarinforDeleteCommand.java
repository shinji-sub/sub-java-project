package sub.handler;

import java.util.List;
import sub.domain.Carinfor;
import sub.util.Prompt;

// "/carinfor/delete" 커멘드 실행
public class CarinforDeleteCommand implements Command {


  List<Carinfor> CarinforList;

  Prompt prompt;


  public CarinforDeleteCommand(Prompt prompt, List<Carinfor> list) {
    this.prompt = prompt;
    this.CarinforList = list;
  }

  @Override
  public void execute() {

    int index = indexOfCarinfor(prompt.inputInt("번호: "));
    if (index == -1) {
      System.out.println("해당 게시글 정보를 찾을 수 없습니다.");
      return;
    }
    this.CarinforList.remove(index);

    System.out.println("자동차 정보 게시판 정보를 삭제하였습니다.");
  }

  private int indexOfCarinfor(int no) {
    for (int i = 0; i < this.CarinforList.size(); i++) {
      if (this.CarinforList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}


