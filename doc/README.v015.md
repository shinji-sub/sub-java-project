###014 src ###

# 015 - 다형성과 형변환 응용

## 학습 목표

- 다형적 변수를 활용하여 다양한 타입의 데이터를 다룰 수 있다.
- 형변환을 이해하고 다룰 수 있다.

## 실습 소스 및 결과

- src/main/java/sub/handler/ArrayList.java 추가
- src/main/java/sub/handler/BoardList.java 삭제
- src/main/java/sub/handler/BoardHandler.java 변경
- src/main/java/sub/handler/CarinforList.java 삭제
- src/main/java/sub/handler/CarinforHandler.java 변경
- src/main/java/sub/handler/CustomerList.java 삭제
- src/main/java/sub/handler/CustomerHandler.java 변경

## 실습

### 작업1) Carinfor, Cutomer, Board를 모두 다룰 수 있는 List 클래스를 만들기.

 ArrayList.java
  - CarinforList, CustomerList, BoardList 클래스를 합쳐 한 클래스로 만든다.
- CarinfirHandler.java
  - `ArrayList` 클래스를 사용하여 데이터를 처리한다.
- CustomerHandler.java
  - `ArrayList` 클래스를 사용하여 데이터를 처리한다.
- BoardHandler.java
  - `ArrayList` 클래스를 사용하여 데이터를 처리한다.