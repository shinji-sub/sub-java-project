package sub.lms.dao.json;

import java.util.List;
import sub.lms.dao.CustomerDao;
import sub.lms.domain.Customer;

public class CustomerJsonFileDao extends AbstractJsonFileDao<Customer> implements CustomerDao {
  public CustomerJsonFileDao(String filename) {
    super(filename);
  }

  @Override
  public int insert(Customer customer) throws Exception {

    if (indexOf(customer.getNo()) > -1) {
      return 0;
    }
    list.add(customer);
    saveData();
    return 1;
  }

  @Override
  public List<Customer> findAll() throws Exception {
    return list;
  }

  @Override
  public Customer findByNo(int no) throws Exception {
    int index = indexOf(no);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  @Override
  public int update(Customer customer) throws Exception {
    int index = indexOf(customer.getNo());

    if (index == -1) {
      return 0;
    }

    list.set(index, customer);
    saveData();
    return 1;
  }

  @Override
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
