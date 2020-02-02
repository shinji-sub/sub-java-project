###023 src ###

// 

# 024 '커맨드(Command)' 디자인 패턴을 적용하기

## 실습 소스 및 결과
 
- src/main/java/sub/handler/Command.java 추가
- src/main/java/sub/handler/BoardAddCommand.java 추가
- src/main/java/sub/handler/BoardListCommand.java 추가
- src/main/java/sub/handler/BoardDetailCommand.java 추가
- src/main/java/sub/handler/BoardDeleteCommand.java 추가
- src/main/java/sub/handler/BoardUpdateCommand.java 추가
- src/main/java/sub/handler/CarinforAddCommand.java 추가
- src/main/java/sub/handler/CarinforListCommand.java 추가
- src/main/java/sub/handler/CarinforDetailCommand.java 추가
- src/main/java/sub/handler/CarinforDeleteCommand.java 추가
- src/main/java/sub/handler/CarinforUpdateCommand.java 추가
- src/main/java/sub/handler/CustomerAddCommand.java 추가
- src/main/java/sub/handler/CustomerListCommand.java 추가
- src/main/java/sub/handler/CustomerDetailCommand.java 추가
- src/main/java/sub/handler/CustomerDeleteCommand.java 추가
- src/main/java/sub/handler/CustomerUpdateCommand.java 추가
- src/main/java/sub/Ex1.java 변경


## 실습

### 훈련1. 메서드를 호출하는 쪽과 실행 쪽 사이의 규칙을 정의하라.

- Command.java
  - `App` 클래스와 명령을 처리하는 클래스 사이의 호출 규칙을 정의한다.

### 훈련2. 명령을 처리하는 각 메서드를 객체로 분리하라.

- CarinforHandler.java
  - 수업 CRUD 각 기능을 `Command` 규칙에 따라 객체로 분리한다.
- CustomerHandler.java
  - 수업 CRUD 각 기능을 `Command` 규칙에 따라 객체로 분리한다.
- BoardHandler.java
  - 수업 CRUD 각 기능을 `Command` 규칙에 따라 객체로 분리한다.
- App.java (App.java.01)
  - 명령어가 입력되면 `Command` 규칙에 따라 객체를 실행한다.
  - `/board2/xxx` 명령 처리는 삭제한다.

### 훈련 3: `Map`으로 `Command` 객체를 관리하라.

- App.java
  - 명령어를 `key`, `Command` 객체를 `value`로 하여 Map에 저장한다.
  - 각 명령에 대해 조건문으로 분기하는 부분을 간략하게 변경한다.
  