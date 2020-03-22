package sub.lms.dao;

import java.util.List;
import sub.lms.domain.PhotoBoard;

public interface PhotoBoardDao {
  int insert(PhotoBoard photoBoard) throws Exception;

  List<PhotoBoard> findAllByCustomerNo(int CustomerNo) throws Exception;

  PhotoBoard findByNo(int no) throws Exception;

  int update(PhotoBoard photoBoard) throws Exception;

  int delete(int no) throws Exception;
}
