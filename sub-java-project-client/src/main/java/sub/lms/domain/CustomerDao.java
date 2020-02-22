package sub.lms.domain;

import java.util.List;

public interface CustomerDao {

  public int insert(Customer customer) throws Exception;

  public List<Customer> findAll() throws Exception;

  public Customer findByNo(int no) throws Exception;

  public int update(Customer customer) throws Exception;

  public int delete(int no) throws Exception;
}
