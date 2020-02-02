###027 src ###

# 028 - 직렬화와 역직렬화를 이용하여 객체를 통체 읽고 쓰기

## 실습 소스 및 결과

- src/main/java/sub/Ex1.java 변경
- src/main/java/sub/domain/Carinfor.java 변경
- src/main/java/sub/domain/Customer.java 변경
- src/main/java/sub/domain/Board.java 변경


## 실습

### 훈련 1: 객체 단위로 읽고 출력하라.

- Carinfor.java
 - 'java.io.Serializable' 인터페이스를 구현한다.
 - 'serialVersionUID' 스태틱 변수의 값을 설정한다.
- Customer.java
 - 'java.io.Serializable' 인터페이스를 구현한다.
 - 'serialVersionUID' 스태틱 변수의 값을 설정한다.
- Board.java
 - 'java.io.Serializable' 인터페이스를 구현한다.
  -Ex1.java
  - 파일에서 데이터를 읽을 때 ObjectInputStream을 사용한다.
  - 파일에서 데이터를 쓸 때 ObjectOutPutStream을 사용한다.
  

#### 실행 결과

 'Ex1'의 실행 결과는 이전 버전과 같다.
 
 
### 훈련 2: ArrayList/LinkedList 객체를 통째로 읽고 출력하라.

- Ex1.java
 - 'java.io.Serializable' 구현체라면 직렬화/
    역직렬화가 가능하다.
 - 따라서 ArrayList, LinkedList 객체를 통째로 읽고 쓸 수 있다.
 
#### 실행 결과

 'Ex1'의 실행 결과는 이전 버전과 같다.