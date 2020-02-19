package sub.lms;

import java.util.Map;
import sub.lms.context.ApplicationContextListener;
import sub.lms.dao.BoardObjectFileDao;
import sub.lms.dao.CarinforObjectFileDao;
import sub.lms.dao.CustomerObjectFileDao;

public class DataLoaderListener implements ApplicationContextListener {


  @Override
  public void contextInitialized(Map<String, Object> context) {
    System.out.println("데이터를 로딩합니다.");

    BoardObjectFileDao boardDao = new BoardObjectFileDao("./board.ser2");
    CarinforObjectFileDao carinforDao = new CarinforObjectFileDao("./carinfor.ser2");
    CustomerObjectFileDao customerDao = new CustomerObjectFileDao("./customer.ser2");


    context.put("boardDao", boardDao);
    context.put("carinforDao", carinforDao);
    context.put("customerDao", customerDao);
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {}

}
