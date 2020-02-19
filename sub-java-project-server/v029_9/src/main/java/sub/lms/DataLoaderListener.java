package sub.lms;

import java.util.Map;
import sub.lms.context.ApplicationContextListener;
import sub.lms.dao.json.BoardJsonFileDao;
import sub.lms.dao.json.CarinforJsonFileDao;
import sub.lms.dao.json.CustomerJsonFileDao;

public class DataLoaderListener implements ApplicationContextListener {


  @Override
  public void contextInitialized(Map<String, Object> context) {
    System.out.println("데이터를 로딩합니다.");

    BoardJsonFileDao boardDao = new BoardJsonFileDao("./board.json");
    CarinforJsonFileDao carinforDao = new CarinforJsonFileDao("./carinfor.json");
    CustomerJsonFileDao customerDao = new CustomerJsonFileDao("./customer.json");


    context.put("boardDao", boardDao);
    context.put("carinforDao", carinforDao);
    context.put("customerDao", customerDao);
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {}

}
