package map;

import java.util.HashMap;
import java.util.Map;

public class map {
  public static void main(final String[] args) {
    final Map<String, String> m = new HashMap<>();
    m.put("이름", "신지섭");
    m.put("메일", "wltjq2006@naver.com");
    m.put("전화번호", "010-4923-6753");

    for (final String key : m.keySet()) {
      System.out.printf("%s : %s\n", key, m.get(key));
    }
  }
}
