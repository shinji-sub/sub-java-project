package sub.lms.domain;

import java.util.List;

public interface CarinforDao {
  public int insert(Carinfor carinfor) throws Exception;

  public List<Carinfor> findAll() throws Exception;

  public Carinfor findByNo(int no) throws Exception;

  public int update(Carinfor carinfor) throws Exception;

  public int delete(int no) throws Exception;
}
