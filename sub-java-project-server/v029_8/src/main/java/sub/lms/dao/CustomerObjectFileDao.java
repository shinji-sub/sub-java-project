package sub.lms.dao;

import java.util.List;
import sub.lms.domain.Customer;

public class CustomerObjectFileDao extends AbstractObjectFileDao<Customer> {

  public CustomerObjectFileDao(String filename) {
    super(filename);
  }

  public int insert(Customer customer) throws Exception {

    if (indexOf(customer.getNo()) > -1) {
      return 0;
    }
    list.add(customer);
    saveData();
    return 1;
  }

  public List<Customer> findAll() throws Exception {
    return list;
  }

  public Customer findByNo(int no) throws Exception {
    int index = indexOf(no);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  public int update(Customer customer) throws Exception {
    int index = indexOf(customer.getNo());

    if (index == -1) {
      return 0;
    }

    list.set(index, customer);
    saveData();
    return 1;
  }

  public int delete(int no) throws Exception {
    int index = indexOf(no);
    if (index == -1) {
      return 0;
    }
    list.remove(index);
    saveData();
    return 1;
  }

  @Override
  protected <K> int indexOf(K key) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == (int) key) {
        return i;
      }
    }
    return -1;
  }

}
