package sub.lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
import sub.lms.context.ApplicationContextListener;
import sub.lms.dao.mariadb.BoardDaoImpl;
import sub.lms.dao.mariadb.CarinforDaoImpl;
import sub.lms.dao.mariadb.CustomerDaoImpl;
import sub.lms.dao.mariadb.PhotoBoardDaoImpl;
import sub.lms.dao.mariadb.PhotoFileDaoImpl;

public class DataLoaderListener implements ApplicationContextListener {

  Connection con;

  @Override
  public void contextInitialized(Map<String, Object> context) {

    try {
      Class.forName("org.mariadb.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/subdb", "subdb", "1111");

      context.put("boardDao", new BoardDaoImpl(con));
      context.put("carinforDao", new CarinforDaoImpl(con));
      context.put("customerDao", new CustomerDaoImpl(con));
      context.put("photoBoardDao", new PhotoBoardDaoImpl(con));
      context.put("photoFileDao", new PhotoFileDaoImpl(con));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    try {
      con.close();
    } catch (Exception e) {
    }
  }
}
