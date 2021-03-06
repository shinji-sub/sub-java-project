###007 src ###

# 008 - 클래스로 메서드를 분류하기

## 학습 목표

- 클래스를 이용하여 관련 메서드를 묶어 관리할 수 있다.
- 리팩토링 기법 중에서 '클래스 추출(Extract Class)'을 수행할 수 있다.

## 실습 소스 및 결과

- src/main/java/sub/Ex1.java 변경
- src/main/java/sub/CarinforHandler.java 추가
- src/main/java/sub/CustomerHandler.java 추가
- src/main/java/sub/BoardHandler.java 추가

## 실습

### 작업1) 자동차 정보 데이터 처리와 관련된 메서드를 별도의 클래스로 분리하라.

- CarinforHandler.java
    - 'carinfor' 관련된 메서드를 담을 클래스를 만든다.
    - `Ex1.java` 에서 수업관리와 관련된 변수와 메서드를 `CarinforHandler` 클래스로 옮긴다.
- Ex1.java 
    - `CarinforHandler` 클래스 사용한다.


### 작업2) 고객 데이터 처리와 관련된 메서드를 별도의 클래스로 분리하라.

- CustomerHandler.java
    - 회원 관리와 관련된 메서드를 담을 클래스를 만든다.
    - `App.java` 에서 회원관리와 관련된 변수와 메서드를 `CustomerHandler` 클래스로 옮긴다.
- Ex1.java 
    - `CustomerHandler` 클래스 사용한다.


### 작업3) 게시물 데이터 처리와 관련된 메서드를 별도의 클래스로 분리하라.

- BoardHandler.java
    - 게시물 관리와 관련된 메서드를 담을 클래스를 만든다.
    - `Ex1.java` 에서 게시물관리와 관련된 변수와 메서드를 `BoardHandler` 클래스로 옮긴다.
    - `BoardHandler` 클래스 사용한다.
