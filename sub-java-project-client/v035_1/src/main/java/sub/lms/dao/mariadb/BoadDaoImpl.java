package sub.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sub.lms.dao.BoardDao;
import sub.lms.domain.Board;

public class BoadDaoImpl implements BoardDao{

  @Override
  public int insert(Board board) throws Exception {
    Class.forName("org.mariadb.jdbc.Driver");

    try(Connection con = DriverManager.getConnection(//
        "jdbc:mariadb://localhost:3306/subdb", "subdb", "1111");
        Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate("insert into car_board(conts) values('" //
          + board.getTitle() + "')");
      return result;
    }
  }

  @Override
  public List<Board> findAll() throws Exception {
    Class.forName("org.mariadb.jdbc.Driver");

    try (
        Connection con = DriverManager.getConnection( //
            "jdbc:mariadb://localhost:3306/subdb", "subdb", "1111");

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery( //
            "select board_id, conts, cdt, vw_cnt from car_board")) {
      ArrayList<Board> list = new ArrayList<>();

      while (rs.next()) {
        Board board = new Board();

        board.setNo(rs.getInt("board_id"));
        board.setTitle(rs.getString("conts"));
        board.setDate(rs.getDate("cdt"));
        board.setViewCount(rs.getInt("vw_cnt"));

        list.add(board);
      }
      return list;
    }
  }

  @Override
  public Board findByNo(int no) throws Exception {
    Class.forName("org.mariadb.jdbc.Driver");

    try ( //
        Connection con = DriverManager.getConnection( //
            "jdbc:mariadb://localhost:3306/subdb", "subdb", "1111");
        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery( //
            "select board_id, conts, cdt, vw_cnt from car_board where board_id=" + no)) {
      if  (rs.next()) {
        Board board = new Board();

        board.setNo(rs.getInt("board_id"));
        board.setTitle(rs.getString("conts"));
        board.setDate(rs.getDate("cdt"));
        board.setViewCount(rs.getInt("vw_cnt"));

        return board;

      } else {
        return null;
      }
    }
  }
  @Override
  public int update(Board board) throws Exception {
    Class.forName("org.mariadb.jdbc.Driver");

    try ( //
        Connection con = DriverManager.getConnection( //
            "jdbc:mariadb://localhost:3306/subdb", "subdb", "1111");
        Statement stmt = con.createStatement()) {
      int result = stmt.executeUpdate("update car_board set conts = '" + //
          board.getTitle() + "' where board_id=" + board.getNo());
      return result;
    }
  }

  @Override
  public int delete(int no) throws Exception {
    Class.forName("org.mariadb.jdbc.Driver");

    try ( //
        Connection con = DriverManager.getConnection( //
            "jdbc:mariadb://localhost:3306/subdb", "subdb", "1111");
        Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate("delete from car_board where board_id=" + no);
      return result;
    }
  }

}
