package sub.util;

public class Queue<E> extends LinkedList<E> implements Cloneable{

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
     
  return  new Iterator<E>() {

      Queue<E> queue;

       {
        this.queue = queue.clone();
      }
      @Override
      public boolean hasNext() {
        return queue.size() > 0;
      }

      @Override
      public E next() {
        return queue.poll();
      }
    };

    
  }
//Queue 객체에서 Iterator 규칙에 따라 값을 꺼내주는 클래스를 정의

}
