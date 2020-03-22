package sub.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sub.lms.dao.PhotoBoardDao;
import sub.lms.domain.Customer;
import sub.lms.domain.PhotoBoard;

public class PhotoBoardDaoImpl implements PhotoBoardDao {

  String jdbcUrl;
  String username;
  String password;

  public PhotoBoardDaoImpl(String jdbcUrl, String username,String password) {
    this.jdbcUrl = jdbcUrl;
    this.username = username;
    this.password = password;
  }

  @Override
  public int insert(PhotoBoard photoBoard) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate( //
          "insert into info_customer(titl,customer_id) values('" //
          + photoBoard.getTitle() + "', " + photoBoard.getCustomer().getNo() //
          + ")");

      return result;
    }
  }


  @Override
  public List<PhotoBoard> findAllByCustomerNo(int CustomerNo) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery( //
            "select photo_id, conts, cdt, vw_cnt, customer_id" //
            + " from info_customer" //
            + " where customer_id=" + CustomerNo //
            + " order by photo_id desc")) {

      ArrayList<PhotoBoard> list = new ArrayList<>();

      while (rs.next()) {
        PhotoBoard photoBoard = new PhotoBoard();
        photoBoard.setNo(rs.getInt("photo_id"));
        photoBoard.setTitle(rs.getString("conts"));
        photoBoard.setDate(rs.getDate("cdt"));
        photoBoard.setViewCount(rs.getInt("vw_cnt"));

        list.add(photoBoard);
      }

      return list;
    }
  }


  @Override
  public PhotoBoard findByNo(int no) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery( //
            "select" //
            + " p.photo_id," //
            + " p.conts," //
            + " p.cdt," //
            + " p.vw_cnt,"//
            + " c.customer_id,"//
            + " c.conts customer_conts" //
            + " from info_photo_customer c" //
            + " inner join customer c on p.customer_id=c.customer_id" //
            + " where photo_id=" + no)) {

      if (rs.next()) {
        PhotoBoard photoBoard = new PhotoBoard();
        photoBoard.setNo(rs.getInt("photo_id"));
        photoBoard.setTitle(rs.getString("titl"));
        photoBoard.setDate(rs.getDate("cdt"));
        photoBoard.setViewCount(rs.getInt("vw_cnt"));

        Customer customer = new Customer();
        customer.setNo(rs.getInt("customer_id"));
        customer.setCartype(rs.getString("car_tp"));

        // Lesson을 PhotoBoard에 저장한다.
        photoBoard.setCustomer(customer);

        return photoBoard;

      } else {
        return null;
      }
    }
  }

  @Override
  public int update(PhotoBoard photoBoard) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement()) {
      int result = stmt.executeUpdate( //
          "update customer set conts='" //
          + photoBoard.getTitle() //
          + "' where photo_id=" + photoBoard.getNo());
      return result;
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement()) {
      int result = stmt.executeUpdate( //
          "delete from customer" //
          + " where photo_id=" + no);
      return result;
    }
  }
}
