package sub.lms.dao.json;

import java.util.List;
import sub.lms.dao.CarinforDao;
import sub.lms.domain.Carinfor;

public class CarinforJsonFileDao extends AbstractJsonFileDao<Carinfor> implements CarinforDao {

  public CarinforJsonFileDao(String filename) {
    super(filename);
  }

  // 서블릿 객체들이 데이터를 다룰 때 사용할 메서드를 정의한다.
  @Override
  public int insert(Carinfor carinfor) throws Exception {

    if (indexOf(carinfor.getNo()) > -1) { // 같은 번호의 수업이 있다면,
      return 0;
    }

    list.add(carinfor); // 새 수업을 등록한다.
    saveData();
    return 1;
  }

  @Override
  public List<Carinfor> findAll() throws Exception {
    return list;
  }

  public Carinfor findByNo(int no) throws Exception {
    int index = indexOf(no);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  @Override
  public int update(Carinfor carinfor) throws Exception {
    int index = indexOf(carinfor.getNo());

    if (index == -1) {
      return 0;
    }

    list.set(index, carinfor); // 기존 객체를 파라미터로 받은 객체로 바꾼다.
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

