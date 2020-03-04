package sub.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sub.lms.dao.CustomerDao;
import sub.lms.domain.Customer;

public class CustomerDaoImpl implements CustomerDao{

  Connection con;

  public CustomerDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public int insert(Customer customer) throws Exception {
    try(Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate("insert into customer(car_tp, cnb, photo, discount, pay, gyeoljeyuhyeong, par, exit_car, accep) "
          + " values('" + customer.getCartype() + "' , '" + customer.getCarNumbel() + "','" + customer.getPhoto() + "','"
          + customer.getDiscountRatr() + "','" + customer.getPayment() + "', '" + customer.getGyeoljeYuhyeong() +
          "', '" + customer.getParking() + "', '" + customer.getExitStatus() + "','" + customer.getAcceptance() + "')");

      return result;
    }
  }


  @Override
  public List<Customer> findAll() throws Exception {
    try(Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(//
            "select customer_id, car_tp, cnb, photo, " //
            + "discount, pay, gyeoljeyuhyeong, par, " //
            + "exit_car, accep from customer")) {

      ArrayList<Customer> list = new ArrayList<>();

      while (rs.next()) {
        Customer customer = new Customer();

        customer.setNo(rs.getInt("customer_id"));
        customer.setCartype(rs.getString("car_tp"));
        customer.setCarNumbel(rs.getString("cnb"));
        customer.setPhoto(rs.getString("photo"));
        customer.setDiscountRatr(rs.getNString("discount"));
        customer.setPayment(rs.getString("pay"));
        customer.setGyeoljeYuhyeong(rs.getString("gyeoljeyuhyeong"));
        customer.setParking(rs.getString("par"));
        customer.setExitStatus(rs.getString("exit_car"));
        customer.setAcceptance(rs.getString("accep"));

        list.add(customer);
      }
      return list;
    }
  }

  @Override
  public Customer findByNo(int no) throws Exception {
    try(Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(//
            "select customer_id, car_tp, cnb, photo, " //
            + "discount, pay, gyeoljeyuhyeong, par, " //
            + "exit_car, accep from customer "
            + " where customer_id=" + no)) {

      if (rs.next()) {
        Customer customer = new Customer();

        customer.setNo(rs.getInt("customer_id"));
        customer.setCartype(rs.getString("car_tp"));
        customer.setCarNumbel(rs.getString("cnb"));
        customer.setPhoto(rs.getString("photo"));
        customer.setDiscountRatr(rs.getNString("discount"));
        customer.setPayment(rs.getString("pay"));
        customer.setGyeoljeYuhyeong(rs.getString("gyeoljeyuhyeong"));
        customer.setParking(rs.getString("par"));
        customer.setExitStatus(rs.getString("exit_car"));
        customer.setAcceptance(rs.getString("accep"));

        return customer;


      } else {
        return null;
      }
    }
  }

  @Override
  public int update(Customer customer) throws Exception {
    try(Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate("update customer set" //
          + " car_tp='" + customer.getCartype() //
          + "', cnb='" + customer.getCarNumbel() //
          + "', photo='" + customer.getPhoto() //
          + "', discount='" + customer.getDiscountRatr() //
          + "', pay='" + customer.getPayment() //
          + "', gyeoljeyuhyeong= '" + customer.getGyeoljeYuhyeong() //
          + "', par='" + customer.getParking()//
          + "', exit_car'" + customer.getExitStatus()
          + "', accep'" + customer.getAcceptance()
          + "' where customer_id=" + customer.getNo());
      return result;
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try(Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate("delete from customer where customer_id=" + no);
      return result;
    }
  }
}
