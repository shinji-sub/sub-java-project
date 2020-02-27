package sub.lms.dao.proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import sub.lms.domain.Carinfor;
import sub.lms.domain.CarinforDao;

public class CarinforDaoProxy implements CarinforDao {

  DaoProxyHelper daoProxyHelper;

  public CarinforDaoProxy(DaoProxyHelper daoProxyHelper) {
    this.daoProxyHelper = daoProxyHelper;
  }

  @Override
  public int insert(Carinfor carinfor) throws Exception {
    class InsertWorker implements Worker {

      @Override
      public Object execute(ObjectInputStream in, ObjectOutputStream out) throws Exception {

        out.writeUTF("/carinfor/add");
        out.writeObject(carinfor);
        out.flush();

        String response = in.readUTF();
        if (response.equals("FAIL")) {
          throw new Exception(in.readUTF());
        }
        return 1;
      }
    }

    InsertWorker worker = new InsertWorker();

    int resultStata = (int) daoProxyHelper.request(worker);

    return resultStata;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Carinfor> findAll() throws Exception {
    Worker worker = new Worker() {

      @Override
      public Object execute(ObjectInputStream in, ObjectOutputStream out) throws Exception {
        out.writeUTF("/carinfor/list");
        out.flush();
        String response = in.readUTF();
        if (response.equals("FAIL")) {
          throw new Exception(in.readUTF());
        }
        return in.readObject();
      }
    };

    Object result = daoProxyHelper.request(worker);
    return (List<Carinfor>) result;
  }

  @Override
  public Carinfor findByNo(int no) throws Exception {
    Object result = daoProxyHelper.request(new Worker() {

      @Override
      public Object execute(ObjectInputStream in, ObjectOutputStream out) throws Exception {
        out.writeUTF("/carinfor/detail");
        out.writeInt(no);
        out.flush();

        String response = in.readUTF();
        if (response.equals("FAIL")) {
          throw new Exception(in.readUTF());
        }
        return in.readObject();
      }
    });
    return (Carinfor) result;
  }

  @Override
  public int update(Carinfor carinfor) throws Exception {
    return (int) daoProxyHelper.request(new Worker() {

      @Override
      public Object execute(ObjectInputStream in, ObjectOutputStream out) throws Exception {
        out.writeUTF("/carinfor/update");
        out.writeObject(carinfor);
        out.flush();

        String response = in.readUTF();
        if (response.equals("FAIL")) {
          throw new Exception(in.readUTF());
        }
        return 1;
      }
    });
  }

  @Override
  public int delete(int no) throws Exception {
    return (int) daoProxyHelper.request((in, out) -> {
      out.writeUTF("/carinfor/delete");
      out.writeInt(no);
      out.flush();

      String response = in.readUTF();

      if (response.equals("FAIL")) {
        throw new Exception(in.readUTF());
      }
      return 1;
    });
  }
}
