package sub.handler;

import java.util.Arrays;
import sub.domain.Board;

public class BoardList {
  
  static final int BOARD_SIZE = 3;
  
  Board[] list;
  int size = 0;
  
  public BoardList() {
    this.list = new Board[BOARD_SIZE];
  }
  
  public BoardList(int capacity) {
    if (capacity < BOARD_SIZE || capacity > 10000)
      this.list = new Board[BOARD_SIZE];
    else
      this.list = new Board[capacity];
  }

  public Board[] toArray() {
    Board[] arr = Arrays.copyOf(this.list, this.size);
    return arr;
  }
    public void add(Board board) {
      if (this.size == this.list.length) {
        int oldCapacity = this.list.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
          this.list = Arrays.copyOf(this.list, newCapacity);
          System.out.printf("새 배열을 %d 개 생성하였음!", newCapacity);
}
      this.list[this.size++] = board;
    }
    public Board get(int no) {
      for (int i = 0; i < this.size; i++) {
        if (this.list[i].getNo() == no) {
          return this.list[i];
        }
      }
      return null;
    }
  }

