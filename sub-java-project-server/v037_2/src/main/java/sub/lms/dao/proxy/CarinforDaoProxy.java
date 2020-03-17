package sub.lms.dao.proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import sub.lms.dao.CarinforDao;
import sub.lms.domain.Carinfor;

public class CarinforDaoProxy implements CarinforDao {

  ObjectInputStream in;
  ObjectOutputStream out;

  public CarinforDaoProxy(ObjectInputStream in, ObjectOutputStream out) {
    this.in = in;
    this.out = out;
  }

  @Override
  public int insert(Carinfor carinfor) throws Exception {
    out.writeUTF("/carinfor/add");
    out.writeObject(carinfor);
    out.flush();

    String response = in.readUTF();
    if (response.equals("FAIL")) {
      throw new Exception(in.readUTF());
    }
    return 1;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Carinfor> findAll() throws Exception {
    out.writeUTF("/carinfor/list");
    out.flush();

    String response = in.readUTF();
    if (response.equals("FAIL")) {
      throw new Exception(in.readUTF());
    }
    return (List<Carinfor>) in.readObject();
  }

  public Carinfor findByNo(int no) throws Exception {
    out.writeUTF("/carinfor/detail");
    out.writeInt(no);
    out.flush();

    String response = in.readUTF();
    if (response.equals("FAIL")) {
      throw new Exception(in.readUTF());
    }
    return (Carinfor) in.readObject();
  }

  @Override
  public int update(Carinfor carinfor) throws Exception {
    out.writeUTF("/carinfor/update");
    out.writeObject(carinfor);
    out.flush();

    String response = in.readUTF();
    if (response.equals("FAIL")) {
      throw new Exception(in.readUTF());
    }
    return 1;
  }

  @Override
  public int delete(int no) throws Exception {
    out.writeUTF("/carinfor/delete");
    out.writeInt(no);
    out.flush();

    String response = in.readUTF();
    if (response.equals("FAIL")) {
      throw new Exception(in.readUTF());
    }
    return 1;
  }

}
