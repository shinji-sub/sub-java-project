package sub.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sub.lms.dao.CarinforDao;
import sub.lms.domain.Carinfor;

public class CarinforDaoImpl implements CarinforDao {

  String jdbcUrl;
  String username;
  String password;

  public CarinforDaoImpl(String jdbcUrl, String username,String password) {
    this.jdbcUrl = jdbcUrl;
    this.username = username;
    this.password = password;
  }


  @Override
  public int insert(Carinfor carinfor) throws Exception {

    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate( //
          "insert into carinfor(datas, departure,cdt, cnb, par)" + " values( ' "
          + carinfor.getDatas().toString() + "', '" + carinfor.getDeparture().toString()
          + "' , '" + carinfor.getCarType() + "', '" + carinfor.getCarNumber() + "', '"
          + carinfor.getParking() + "'" + ")");
      return result;
    }
  }

  @Override
  public List<Carinfor> findAll() throws Exception {

    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery( //
            "select carinfor_id, cdt, cnb, par, datas, departure from carinfor")) {
      ArrayList<Carinfor> list = new ArrayList<>();

      while (rs.next()) {
        Carinfor carinfor = new Carinfor();

        carinfor.setNo(rs.getInt("carinfor_id"));
        carinfor.setCarType(rs.getString("cdt"));
        carinfor.setCarNumber(rs.getString("cnb"));
        carinfor.setParking(rs.getString("par"));
        carinfor.setDatas(rs.getDate("datas"));
        carinfor.setDeparture(rs.getDate("departure"));

        list.add(carinfor);
      }
      return list;
    }
  }

  public Carinfor findByNo(int no) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery( //
            "select carinfor_id, cdt, cnb, par, datas, departure" + " from carinfor"
            + " where carinfor_id=" + no)) {

      if (rs.next()) { // 데이터를 한 개 가져왔으면 true를 리턴한다.
        Carinfor carinfor = new Carinfor();
        carinfor.setNo(rs.getInt("carinfor_id"));
        carinfor.setCarType(rs.getString("cdt"));
        carinfor.setCarNumber(rs.getString("cnb"));
        carinfor.setParking(rs.getString("par"));
        carinfor.setDatas(rs.getDate("datas"));
        carinfor.setDeparture(rs.getDate("departure"));
        return carinfor;

      } else {
        return null;
      }
    }
  }


  @Override
  public int update(Carinfor carinfor) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate("update carinfor set" //
          + " cdt='" + carinfor.getCarType() //
          + "', cnb='" + carinfor.getCarNumber() //
          + "', par='" + carinfor.getParking() //
          + "', datas='" + carinfor.getDatas() //
          + "', departure='" + carinfor.getDeparture() //
          + "' where carinfor_id=" + carinfor.getNo());
      return result;
    }
  }


  @Override
  public int delete(int no) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate("delete from carinfor where carinfor_id=" + no);
      return result;
    }
  }

}
