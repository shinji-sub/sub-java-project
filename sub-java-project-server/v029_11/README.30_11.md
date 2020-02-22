### sub-project-server 29_11 src ###

# 30_11 - 프록시 패턴을 적용하여 서버에 요청하는 부분을 간결하게 만들기

## 학습목표

- 프록시 패턴의 구조와 실행 원리를 이해한다.
- 프록시 패턴의 사용 목적을 이해한다.
- 프록시 패턴을 적용할 수 있고 사용할 수 있다.

## 실습 소스 및 결과

- src/main/java/lms/dao/proxy 패키지 생성
- src/main/java/lms/dao/proxy BoardDaoProxy.java 인터페이스 추가
- src/main/java/lms/dao/proxy CarinforDaoProxy.java 인터페이스 추가
- src/main/java/lms/dao/proxy CustomerDaoProxy.java 인터페이스 추가

## 실습  

### 훈련 1: BoardDao의 사용법을 캡슐화하라.

- sub.lms.dao.proxy 패키지를 생성한다.
- sub.lms.dao.proxy.BoardDaoProxy 클래스를 정의한다.

### 훈련 2: CarinforDao의 사용법을 캡슐화하라.

- sub.lms.dao.proxy.CarinforDaoProxy 클래스를 정의한다.

### 훈련 3: CustomerDao의 사용법을 캡슐화하라.

- sub.lms.dao.proxy.CustomerDaoProxy 클래스를 정의한다.

### 훈련 4: 프록시 객체를 Client 프로젝트에 가져간 후 실행을 테스트하라.





  
  