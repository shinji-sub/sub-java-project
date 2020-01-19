import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Test201 {
  public static void main(final String[] args) {
    final Queue<Integer> q = new LinkedList<>();

    q.offer(1);
    q.offer(2);
    q.offer(3);

    final Iterator<Integer> it = q.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }

  }
}
