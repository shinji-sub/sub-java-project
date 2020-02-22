package sub.lms.dao.proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import sub.lms.domain.Customer;
import sub.lms.domain.CustomerDao;

public class CustomerDaoProxy implements CustomerDao {

  ObjectInputStream in;
  ObjectOutputStream out;

  public CustomerDaoProxy(ObjectInputStream in, ObjectOutputStream out) {
    this.in = in;
    this.out = out;
  }

  @Override
  public int insert(Customer customer) throws Exception {
    out.writeUTF("/customer/add");
    out.writeObject(customer);
    out.flush();

    String response = in.readUTF();
    if (response.equals("FAIL")) {
      throw new Exception(in.readUTF());
    }
    return 1;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Customer> findAll() throws Exception {
    out.writeUTF("/customer/list");
    out.flush();
    String response = in.readUTF();
    if (response.equals("FAIL")) {
      throw new Exception(in.readUTF());
    }
    return (List<Customer>) in.readObject();
  }

  @Override
  public Customer findByNo(int no) throws Exception {
    out.writeUTF("/customer/detail");
    out.writeInt(no);
    out.flush();

    String response = in.readUTF();
    if (response.equals("FAIL")) {
      throw new Exception(in.readUTF());
    }
    return (Customer) in.readObject();
  }

  @Override
  public int update(Customer customer) throws Exception {
    out.writeUTF("/customer/update");
    out.writeObject(customer);
    out.flush();

    String response = in.readUTF();
    if (response.equals("FAIL")) {
      throw new Exception(in.readUTF());
    }
    return 1;
  }

  @Override
  public int delete(int no) throws Exception {
    out.writeUTF("/customer/delete");
    out.writeInt(no);
    out.flush();

    String response = in.readUTF();
    if (response.equals("FAIL")) {
      throw new Exception(in.readUTF());
    }
    return 1;
  }

}
