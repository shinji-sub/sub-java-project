package study;

import java.util.ListIterator;
import java.util.Stack;

public class Iterator1 {
  public static void main(final String[] args) {
    final Stack<Integer> s = new Stack<>();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.push(5);

    ListIterator<Integer> it = s.listIterator(s.size());
    while (it.hasPrevious()) {
      System.out.println(it.previous());
    }
  }
}
