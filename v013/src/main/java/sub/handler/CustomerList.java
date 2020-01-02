package sub.handler;

import java.util.Arrays;
import sub.domain.Customer;

public class CustomerList {
  static final int CUSTOMER_SIZE = 3;

  Customer[] list; 

  int size;

  public CustomerList() {
    this.list = new Customer[CUSTOMER_SIZE];
  }

  public CustomerList(int capacity) {
    if (capacity < CUSTOMER_SIZE || capacity > 10000)
      this.list = new Customer[CUSTOMER_SIZE];
    else
      this.list = new Customer[capacity];
  }

  public Customer[] toArray() {
    Customer[] arr = Arrays.copyOf(this.list, this.size);
    return arr;
  }


  public void add(Customer customer) {
    if (this.size == this.list.length) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);

      this.list = Arrays.copyOf(this.list, newCapacity);
    }
    this.list[this.size++] = customer;
  }
}
