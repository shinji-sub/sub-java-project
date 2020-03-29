package sub.lms.dao;

import java.util.List;
import sub.lms.domain.Carinfor;

public interface CarinforDao {
  public int insert(Carinfor carinfor) throws Exception;

  public List<Carinfor> findAll() throws Exception;

  public static Carinfor findByNo(int no) throws Exception {
    return null;
  }

  public int update(Carinfor carinfor) throws Exception;

  public int delete(int no) throws Exception;
}
