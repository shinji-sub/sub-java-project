package sub.util;

import java.util.Arrays;

public class Stack<E> implements Cloneable {

  private static final int DEFALT_CAPACITY = 10;

  Object[] elementData;
  int size;

  public Stack() {
    this.elementData = new Object[DEFALT_CAPACITY];
    this.size = 0;
  }

  public void push(E value) {
    if (this.size == elementData.length) {
      grow();
    }
    this.elementData[size++] = value;
  }

  private void grow() {

    this.elementData = Arrays.copyOf(elementData, newCapacity());
  }

  private int newCapacity() {
    int oldCapacity = elementData.length;
    return oldCapacity + (oldCapacity >> 1);
  }
  @SuppressWarnings("unchecked")
  public E pop() {
    if (this.empty())
      return null;
    E value = (E) this.elementData[--this.size];
    return value;
  }

  public boolean empty() {
    return this.size == 0;
  }
  /*
  @Override
  public Stack clone() {
    try {
      return (Stack)super.clone();
    } catch (CloneNotSupportedException ex) {
      System.out.println(ex);
      return null;
    }
  }
   */

  @SuppressWarnings("unchecked")
  @Override
  public Stack<E> clone() {
    try {
      Stack<E> temp = (Stack<E>) super.clone();
      Object[] arr = new Object[this.size];
      for (int i = 0; i < this.size; i++) {
        arr[i] = this.elementData[i];
      }
      temp.elementData = arr;

      return temp;

    } catch (CloneNotSupportedException ex) {
      System.out.println(ex);
      return null;
    }
  }
  public Iterator<E> iterator() {
    class StackIterator<T> implements Iterator<T> {

      Stack<T> stack;
      
      @SuppressWarnings("unchecked")
      public StackIterator() {
        this.stack = (Stack<T>)Stack.this.clone();
      }
      @Override
      public boolean hasNext() {
        return !stack.empty();
      }

      @Override
      public T next() {
        return stack.pop();
      }

    }

    return new StackIterator<E>();
  }
  
}
