### sub-project-server 36_4 src ###

# 37_4 - Application Server 구조로 변경: 검색 기능 추가 

## 학습목표

- Application Server 아키텍처의 구성과 특징을 이해한다.
- 통신 프로토콜 규칙에 따라 동작하는 서버를 만들 수 있다.
- 새 기능을 추가하더라도 클라이언트 앱을 재 배포할 필요가 없음을 안다.

## 실습 소스 및 결과

- src/main/java/sub/lms/dao/CustomerDao.java 변경
- src/main/java/sub/lms/dao/mariadb/CustomerDaoImpl.java 변경
- src/main/java/sub/lms/servlet/CustomerSearchServlet.java 추가
- src/main/java/sub/lms/ServerApp.java 변경

## 실습  

### 훈련1: 회원 검색 기능을 추가하라.

서버에서 애플리케이션을 실행하는 방식의 이점은 "새 기능을 추가하더라도 
사용자 PC에 클라이언트 프로그램을 재설치 할 필요가 없다"는 것이다. 
검색 기능을 추가한 후 이를 확인한다.

- com.sub.lms.dao.CustomerDao 변경
  - findByKeyword() 메서드 추가
- com.sub.lms.dao.mariadb.CustomerDaoImpl 변경
  - findByKeyword() 메서드 구현
- com.sub.lms.servlet.CustomerSearchServlet 추가
  - 클라이언트에게 검색 키워드를 요청한다.
  - 클라이언트가 보낸 키워드를 가지고 회원을 검색한다.
  - 검색한 결과를 가지고 출력 내용을 생성한다.
  - 클라이언트에게 보낸다.
- com.sub.lms.ServerApp 변경
  - '/customer/search' 명령을 처리할 CustomerSearchServlet 객체를 등록한다.
  