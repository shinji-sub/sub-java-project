# 30_6 - 커맨드 패턴을 적용하여 요청 처리 메서드를 객체화 하기

## 학습목표

- 커맨드 패턴의 동작 원리를 이해한다.
- 커맨드 패턴을 코드에 적용할 수 있다.

## 실습 소스 및 결과

- src/main/java/sub/lms/servlet 패키지 생성
- src/main/java/sub/lms/servlet/Servlet.java 추가
- src/main/java/sub/lms/servlet/BoardListServlet.java 추가
- src/main/java/sub/lms/servlet/BoardAddServlet.java 추가
- src/main/java/sub/lms/servlet/BoardDetailServlet.java 추가
- src/main/java/sub/lms/servlet/BoardUpdateServlet.java 추가
- src/main/java/sub/lms/servlet/BoardDeleteServlet.java 추가
- src/main/java/sub/lms/servlet/CustomerListServlet.java 추가
- src/main/java/sub/lms/servlet/CustomerAddServlet.java 추가
- src/main/java/sub/lms/servlet/CustomerDetailServlet.java 추가
- src/main/java/sub/lms/servlet/CustomerUpdateServlet.java 추가
- src/main/java/sub/lms/servlet/CustomerDeleteServlet.java 추가
- src/main/java/sub/lms/servlet/CarinforListServlet.java 추가
- src/main/java/sub/lms/servlet/CarinforAddServlet.java 추가
- src/main/java/sub/lms/servlet/CarinforDetailServlet.java 추가
- src/main/java/sub/lms/servlet/CarinforUpdateServlet.java 추가
- src/main/java/sub/lms/servlet/CarinforDeleteServlet.java 추가
- src/main/java/sub/lms/ServerApp.java 변경

## 실습

### 훈련 1: 커맨드 패턴의 인터페이스 정의.

- com.eomcs.servlet 패키지 생성한다.
- com.eomcs.servlet.Servlet 인터페이스를 정의한다.

### 훈련 2: 각각의 요청 처리 메서드를 인터페이스 규칙에 따라 클래스로 정의하라

- listBoard()를 BoardListServlet 클래스로 정의한다.
- addBoard()를 BoardAddServlet 클래스로 정의한다.
- detailBoard()를 BoardDetailServlet 클래스로 정의한다.
- updateBoard()를 BoardUpdateServlet 클래스로 정의한다.
- deleteBoard()를 BoardDeleteServlet 클래스로 정의한다.

- listCustomer() : CustomerListServlet 클래스로 정의한다.
- addCustomer() : CustomerAddServlet 클래스로 정의한다.
- detailCustomer() : CustomerDetailtServlet 클래스로 정의한다.
- updateCustomer() : CustomerUpdateServlet 클래스로 정의한다.
- deleteCustomer() : CustomerDeleteServlet 클래스로 정의한다.
 
- listCarinfor() : CarinforListServlet 클래스로 정의한다.
- addCarinfor() : CarinforAddServlet 클래스로 정의한다.
- detailCarinfor() : CarinforDetailServlet클래스로 정의한다.
- updateCarinfor() : CarinforUpdateServlet클래스로 정의한다.
- deleteCarinfor() : CarinforDeleteServlet 클래스로 정의한다.