### sub-project-server 29_5 src ###

# 32_5 - 특정 기능을 수행하는 코드를 메서드로 분리하기 

## 학습목표

- 기능 별로 코드를 베서드로 분리할 수 있다.
- 분리한 메서드를 사용할 수 있다.
- "Extract Method" 리팩토링 기법을 이해한다.

## 실습 소스 및 결과

- src/main/java/sub/lms/ServerApp.java 변경

## 실습

### 훈련 1: 클라이언트의 요청을 처리하는 코드를 기능별로 분리하라.

- ServerApp.java 변경
  - if~ else~ 분기문에 작성한 코드를 별도의 메서드로 분리하여 정의한다.
  - listBoard() : 게시물 목록 데이터 요청 처리
  - AddBoard() : 게시물 데이터 등록 요청 처리
  - DetailBoard() : 게시물 조회 요청 처리
  - UpdateBoard() : 게시물 변경 요청 처리
  - DeleteBoard() : 게시물 삭제 요청 처리
  
  - listCustomer() : 회원 목록 데이터 요청 처리
  - AddCustomer() : 회원데이터 등록 요청 처리
  - DetailCustomer() : 회원조회 요청 처리
  - UpdateCustomer() : 회원변경 요청 처리
  - DeleteCustomer() : 회원삭제 요청 처리
  
  - listCarinfor() : 자동차 정보 목록 데이터 요청 처리
  - AddCarinfor() : 자동차 정보데이터 등록 요청 처리
  - DetailCarinfor() : 자동차 정보조회 요청 처리
  - UpdateCarinfor() : 자동차 정보 변경 요청 처리
  - DeleteCarinfor() : 자동차 정보 삭제 요청 처리