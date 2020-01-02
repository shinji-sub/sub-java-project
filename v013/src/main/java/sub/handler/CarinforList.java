package sub.handler;

import java.util.Arrays;
import sub.domain.Carinfor;

public class CarinforList {

  static final int CARINFOR_SIZE = 3;

  Carinfor[] list;
  int size = 0;

  public CarinforList() {
    this.list  = new Carinfor[CARINFOR_SIZE];
  }

  public CarinforList(int capacity) {
    if (capacity < CARINFOR_SIZE || capacity > 10000)
      this.list = new Carinfor[CARINFOR_SIZE];
    else
      this.list = new Carinfor[capacity];
  }
  public Carinfor[] toArray() {
    Carinfor[] arr = Arrays.copyOf(this.list,this.size);
    return arr;
  }

  public void add(Carinfor carinfor) {
    if (this.size == this.list.length) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);

      this.list = Arrays.copyOf(this.list,newCapacity);
    }
    this.list[this.size++] = carinfor;
  }
}
