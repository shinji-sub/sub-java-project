package sub.lms;

import java.sql.Connection;
import java.util.Map;
import sub.lms.context.ApplicationContextListener;
import sub.lms.dao.mariadb.BoardDaoImpl;
import sub.lms.dao.mariadb.CarinforDaoImpl;
import sub.lms.dao.mariadb.CustomerDaoImpl;
import sub.lms.dao.mariadb.PhotoBoardDaoImpl;
import sub.lms.dao.mariadb.PhotoFileDaoImpl;
import sub.util.ConnectionFactory;

public class DataLoaderListener implements ApplicationContextListener {

  public static Connection con;

  @Override
  public void contextInitialized(Map<String, Object> context) {

    try {
      String jdbcUrl = "jdbc:mariadb://localhost:3306/subdb";
      String username = "subdb";
      String password = "1111";

      ConnectionFactory conFactory = new ConnectionFactory(
          jdbcUrl, username, password);

      context.put("boardDao", new BoardDaoImpl(conFactory));
      context.put("lessonDao", new CarinforDaoImpl(conFactory));
      context.put("memberDao", new CustomerDaoImpl(conFactory));
      context.put("photoBoardDao", new PhotoBoardDaoImpl(conFactory));
      context.put("photoFileDao", new PhotoFileDaoImpl(conFactory));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
  }
}