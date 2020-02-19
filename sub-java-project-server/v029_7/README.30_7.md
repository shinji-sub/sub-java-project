### sub-project-server 29_7 src ###

# 30-7 - 데이터 처리 코드를 별도의 클래스로 정의하여 객체화 시키기

## 학습목표

- DAO(Data Access Object)의 역활과 이점을 이해한다.
- 데이터 처리 코드를 DAO로 분리할 수 있다.

## 실습 소스 및 결과

- src/main/java/sub/lms/dao 패키지 생성
- src/main/java/sub/lms/dao/BoardFileDao.java 추가
- src/main/java/sub/lms/dao/CarinforFileDao.java 추가
- src/main/java/sub/lms/dao/CustomerFileDao.java 추가
- src/main/java/sub/lms/ServerApp.java 변경

## 실습

### 훈련 1: 게시물 데이터를 처리하는 DAO 클래스를 정의하라

- sub.lms.dao 패키지 생성한다.
- sub.lms.dao.BoardFileDao 클래스를 정의한다.

### 훈련 2: BoardFileDao 객체를 적용하라.

- sub.lms.DataLoaderListenenr를 변경한다.
  - 게시물 데이터를 로딩하고 저장하는 기존 코드를 제거한다.
  - 대신에 BoardFileDao 객체를 생성한다.
  
- sub.lms.ServerApp 을 변경한다.
  - Map에서 BoardFileDAO를 꺼내 관련 커맨드 객체에 주입한다.
  
- BoardXxxServlet 을 변경한다.
 - 생성자에서 List 객체를 받는 대신에 BoardFileDao 객체를 받는다.
 - 데이터를 저장하고, 조회하고, 변경하고, 삭제할 때 BoardFileDao 객체를 통해 처리한다.
 
 ### 훈련 3: 고객 데이터를 처리하는 DAO 클래스를 정의하고 적용하라.

- sub.lms.CustomerFileDao 클래스를 정의한다.
- sub.lms.DataLoaderListener 를 변경한다.
  - 고객 데이터를 로딩하고 저장하는 기존 코드를 제거한다.
  - 대신에 CustomerFileDao 객체를 생성한다.
  
- sub.lms.ServerApp 을 변경한다.
  - Map에서 CustomerFileDao를 꺼내 관련 커맨드 객체에 주입한다.
  - CustomerXxxServlet을 변경한다.

 - 생성자에서 List 객체를 받는 대신에 CustomerFileDao 객체를 받는다.
 - 데이터를 저장하고,조회하고,변경하고,삭제할 때 CustomerFileDao 객체를 통해 처리한다.
 
 
### 훈련 4: 자동차 정보 데이터를 처리하는 DAO 클래스를 정의하고 적용하라.

- sub.lms.CarinforFileDao 클래스를 정의한다.
- sub.lms.DataLoaderListener 를 변경한다.
  - 자동차 정보 데이터를 로딩하고 저장하는 기존 코드를 제거한다.
  - 대신에 MemberFileDao 객체를 생성한다.
  
- sub.lms.ServerApp 을 변경한다.
  - Map에서 CarinforFileDao를 꺼내 관련 커맨드 객체에 주입한다.
  
- CarinforXxxServlet을 변경한다.
  - 생성자에서 List 객체를 받는 대신에 CarinforFileDao 객체를 받는다.
  - 데이터를 저장하고,조회하고,변경하고,삭제할 때 CarinforFileDao 객체를 통해 처리한다. 