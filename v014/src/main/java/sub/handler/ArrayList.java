package sub.handler;

import java.util.Arrays;

public class ArrayList {
  
  static final int BOARD_SIZE = 3;

  Object[] list;
  int size = 0;

  public ArrayList() {
    this.list = new Object[BOARD_SIZE];
  }

  public ArrayList(int capacity) {
    if (capacity < BOARD_SIZE || capacity > 10000)
      this.list = new Object[BOARD_SIZE];
    else
      this.list = new Object[capacity];
  }

  public Object[] toArray() {
    Object[] arr = Arrays.copyOf(this.list, this.size);
    return arr;
  }
  public void add(Object obj) {
    if (this.size == this.list.length) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
      System.out.printf("새 배열을 %d 개 생성하였음!", newCapacity);
    }
    this.list[this.size++] = obj;
    
  }
  public Object get(int idx) {
      if (idx >= 0 && idx < this.size) {
        return this.list[idx];
      }else
        return null;
  }
}
    
