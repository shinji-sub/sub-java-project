package sub.lms.dao.proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import sub.lms.domain.Customer;
import sub.lms.domain.CustomerDao;

public class CustomerDaoProxy implements CustomerDao {

  DaoProxyHelper daoProxyHelper;

  public CustomerDaoProxy(DaoProxyHelper daoProxyHelper) {
    this.daoProxyHelper = daoProxyHelper;
  }

  @Override
  public int insert(Customer customer) throws Exception {
    class InsertWorker implements Worker {

      @Override
      public Object execute(ObjectInputStream in, ObjectOutputStream out) throws Exception {
        out.writeUTF("/customer/add");
        out.writeObject(customer);
        out.flush();

        String response = in.readUTF();
        if (response.equals("FAIL")) {
          throw new Exception(in.readUTF());
        }
        return 1;
      }
    }
    InsertWorker worker = new InsertWorker();

    int resultStat = (int) daoProxyHelper.request(worker);

    return resultStat;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Customer> findAll() throws Exception {
    Worker worker = new Worker() {

      @Override
      public Object execute(ObjectInputStream in, ObjectOutputStream out) throws Exception {
        out.writeUTF("/customer/list");
        out.flush();
        String response = in.readUTF();
        if (response.equals("FAIL")) {
          throw new Exception(in.readUTF());
        }
        return in.readObject();
      }
    };

    Object result = daoProxyHelper.request(worker);
    return (List<Customer>) result;
  }

  @Override
  public Customer findByNo(int no) throws Exception {
    Object result = daoProxyHelper.request(new Worker() {

      @Override
      public Object execute(ObjectInputStream in, ObjectOutputStream out) throws Exception {
        out.writeUTF("/customer/detail");
        out.writeInt(no);
        out.flush();

        String response = in.readUTF();
        if (response.equals("FAIL")) {
          throw new Exception(in.readUTF());
        }
        return in.readObject();
      }
    });
    return (Customer) result;
  }

  @Override
  public int update(Customer customer) throws Exception {
    return (int) daoProxyHelper.request(new Worker() {

      @Override
      public Object execute(ObjectInputStream in, ObjectOutputStream out) throws Exception {
        out.writeUTF("/customer/update");
        out.writeObject(customer);
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
      out.writeUTF("/customer/delete");
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
