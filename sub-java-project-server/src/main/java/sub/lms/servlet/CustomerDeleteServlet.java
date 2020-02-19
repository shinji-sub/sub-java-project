package sub.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sub.lms.dao.json.CustomerJsonFileDao;

public class CustomerDeleteServlet implements Servlet {
  CustomerJsonFileDao customerDao;

  public CustomerDeleteServlet(CustomerJsonFileDao customerDao) {
    this.customerDao = customerDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    int no = in.readInt();


    if (customerDao.delete(no) > 0) {
      out.writeUTF("OK");

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 번호의 고객정보가 없습니다.");
    }
  }
}
