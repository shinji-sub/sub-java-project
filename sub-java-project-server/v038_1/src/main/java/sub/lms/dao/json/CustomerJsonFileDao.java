package sub.lms.dao.json;

import java.util.List;
import sub.lms.dao.CustomerDao;
import sub.lms.domain.Customer;

public class CustomerJsonFileDao extends AbstractJsonFileDao<Customer> implements CustomerDao {

  public CustomerJsonFileDao(String filename) {
    super(filename);
  }

  // 서블릿 객체들이 데이터를 다룰 때 사용할 메서드를 정의한다.
  public int insert(Customer customer) throws Exception {

    if (indexOf(customer.getNo()) > -1) { // 같은 번호의 회원이 있다면,
      return 0;
    }

    list.add(customer); // 새 회원을 등록한다.
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

    list.set(index, customer); // 기존 객체를 파라미터로 받은 객체로 바꾼다.
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

