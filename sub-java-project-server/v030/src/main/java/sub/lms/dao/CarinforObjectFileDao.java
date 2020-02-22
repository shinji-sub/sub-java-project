package sub.lms.dao;

import java.util.List;
import sub.lms.domain.Carinfor;

public class CarinforObjectFileDao extends AbstractObjectFileDao<Carinfor> implements CarinforDao {

  public CarinforObjectFileDao(String filename) {
    super(filename);
  }

  @Override
  public int insert(Carinfor carinfor) throws Exception {

    if (indexOf(carinfor.getNo()) > -1) {
      return 0;
    }
    list.add(carinfor);
    saveData();
    return 1;
  }

  @Override
  public List<Carinfor> findAll() throws Exception {
    return list;
  }

  @Override
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

    list.set(index, carinfor);
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
