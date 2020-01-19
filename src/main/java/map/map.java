package map;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class map {
  public static void main(final String[] args) {
    final Set<String> s = new HashSet<>();
    s.add("A");
    s.add("B");
    s.add("A");
    s.add("B");
    s.add("C");

    final Iterator<String> it = s.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
    System.out.println("-----------------------");
    System.out.println(s.size());
  }
}

