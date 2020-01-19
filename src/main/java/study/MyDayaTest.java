package study;

class MyData<E> {
  int[] arr;

  public MyData(final int[] arr) {
    this.arr = arr;
  }

  public int getItem(final int index) {
    return arr[index];
  }

  public Iterator<E> iterator() {
    return new MyDataIterator<>(this);
  }

  public int size() {
    return arr.length;
  }

}


class MyDataIterator<E> implements Iterator<E> {
  MyData<E> d;
  int cursor;

  public MyDataIterator(final MyData<E> d) {
    this.d = d;
    cursor = 0;
  }

  @Override
  public boolean hasNext() {
    return cursor < d.size();
  }

  @Override
  public int next() {
    return d.getItem(cursor++);
  }
}


public class MyDayaTest {
  public static void main(final String[] args) {
    final MyData<Integer> data = new MyData<>(new int[] {2, 3, 1, 4, 5, 6, 11});
    final Iterator<Integer> it = data.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }
}
