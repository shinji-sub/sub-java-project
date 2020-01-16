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
    
    class QueueIterator<T> implements Iterator<T> {

      Queue<T> queue;

      public QueueIterator()  {
        this.queue = queue.clone();
      }
      @Override
      public boolean hasNext() {
        return queue.size() > 0;
      }

      @Override
      public T next() {
        return queue.poll();
      }
    }

    return new QueueIterator <E>();
  }
//Queue 객체에서 Iterator 규칙에 따라 값을 꺼내주는 클래스를 정의

}
