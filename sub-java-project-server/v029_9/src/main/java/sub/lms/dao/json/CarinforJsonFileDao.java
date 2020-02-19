package sub.lms.dao.json;

import java.util.List;
import sub.lms.domain.Carinfor;

public class CarinforJsonFileDao extends AbstractJsonFileDao<Carinfor> {

  public CarinforJsonFileDao(String filename) {
    super(filename);
  }

  public int insert(Carinfor carinfor) throws Exception {

    if (indexOf(carinfor.getNo()) > -1) {
      return 0;
    }
    list.add(carinfor);
    saveData();
    return 1;
  }

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

  public int update(Carinfor carinfor) throws Exception {
    int index = indexOf(carinfor.getNo());

    if (index == -1) {
      return 0;
    }

    list.set(index, carinfor);
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
