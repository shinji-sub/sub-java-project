###025_2 src ###

# 026_2 - CSV 문자열을 객체로 전환하는 기능을 도메인 객체로 이동

## 실습 소스 및 결과
 
- src/mian/java/sub/Ex1.java 변경
- src/main/java/sub/domain/Board.java 변경
- src/main/java/sub/domain/Carinfor.java 변경
- src/main/java/sub/domain/Customer.java 변경

## 실습
### 훈련 1: 게시물 데이터를 CSV 문자열로 다루는 코드를 Board 클래스로 옮겨라. 

- Board.java
    - CSV 문자열을 가지고 Board 객체를 생성하는 valueOf()를 추가한다.
    - Board 객체를 가지고 CSV 문자열을 리턴하는 toCsvString()를 추가한다.
- Ex1.java
  - loadBoardData() 메서드를 변경한다.
  - saveBoardData() 메서드를 변경한다.
  
### 훈련 2: 고객정보 데이터를 CSV 문자열로 다루는 코드를 Customer 클래스로 옮겨라. 

- Customer.java
    - CSV 문자열을 가지고 Customer 객체를 생성하는 valueOf()를 추가한다.
    - Customer 객체를 가지고 CSV 문자열을 리턴하는 toCsvString()를 추가한다.
- App.java
  - loadCustomerData() 메서드를 변경한다.
  - saveCustomerrData() 메서드를 변경한다.
  
### 훈련 3: 자동차 정보 데이터를 CSV 문자열로 다루는 코드를 Carinfor 클래스로 옮겨라. 

- Carinfor.java
    - CSV 문자열을 가지고 Carinfor 객체를 생성하는 valueOf()를 추가한다.
    - Carinfor 객체를 가지고 CSV 문자열을 리턴하는 toCsvString()를 추가한다.
- App.java
  - loadCarinforData() 메서드를 변경한다.
  - saveCarinforData() 메서드를 변경한다