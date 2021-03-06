package sub.util;

public class Queue<E> extends LinkedList<E> {

  public void offer(E value) {
    this.add(value);
  }

  public E poll() {
    return remove(0);
  }

  public Queue<E> clone() {
    Queue<E> temp = new Queue<E>();

    for (int i = 0; i < size(); i++) {
      temp.offer(get(i));
    }
    return temp;
  }
  public Iterator<E> iterator() {
    return new QueueIterator <E>(this);
  }
}
