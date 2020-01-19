package Lambda;

import java.util.function.BiFunction;

public class Lambda {
  public static void main(final String[] args) {
    // 두 개의 인자를 받아 하나의 리턴을 만드는 BiFinction이 있다.
    // BiFunction <T, U, R> 형태이며,
    // 내부 함수는 Function과 통일하게 apply를 사용한다.
    // 앞에서 작성한 max 함수를 사용하기 위해 함수형 인터페이스를 사용하는 예제
    final BiFunction<Integer, Integer, Integer> f = (a, b) -> a > b ? a : b;
    System.out.println(f.apply(3, 10));

    // UnartOperator<T, T>
    // BinaryOperator<T, T, T>
  }
}


