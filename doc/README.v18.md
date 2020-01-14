###017 src ###

// 

# 018 배열 대신 연결 리스트 자료구조 사용하기

## 학습 목표



## 실습 소스 및 결과

- src/main/java/sub/util/LinkedList.java 추가
- src/main/java/sub/handler/BoardHandler.java 변경
- src/main/java/sub/handler/CarinforHandler.java 변경
- src/main/java/sub/handler/CustomerHandler.java 변경

## 실습

### 작업1) 연결 리스트 자료구조를 구현하라.

- LinkedList.java.01
     - 연결 리스트 자료 구조를 구현한 클래스를 정의한다.

### 작업2) LinkedList 클래스에 제네릭을 적용하라

- LinkedList.java
    -ArrayList처럼 특정 타입의 값을 다루도록 제네릭을 적용한다.

### 작업3) 핸들러 클래스는 ArrayList 대신 LinkedList를 사용하라.
- CustomerHandler.java
    - 고객 데이터를 저장하는 ArrayList를 LinkedList로 교체해준다.

- CarinforHandler.java
    - 자동차 주차 데이터를 저장하는 ArrayList를 LinkedList로 교체해준다.
    
- BoardHandler.java
    - 게시글 데이터를 저장하는 ArrayList를 LinkedList로 교체해준다.    