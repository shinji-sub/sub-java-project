package sub.lms.dao;

import java.util.List;
import sub.lms.domain.Customer;

public interface CustomerDao {

  public int insert(Customer customer) throws Exception;

  public List<Customer> findAll() throws Exception;

  public Customer findByNo(int no) throws Exception;

  public int update(Customer customer) throws Exception;

  public int delete(int no) throws Exception;

  default List<Customer> findByKeyword(String keyword) throws Exception {
    return null;
  }
}