###016_1 src ###

# 017 - CRUD(Create/Retrieve/Update/Delete) 기능 완성

## 학습 목표

- 데이터를 등록/조회/수정/삭제하는 기능(CRUD)을 구현할 수 있다.

## 실습 소스 및 결과

- src/main/java/sub/util/ArrayList.java 변경
- src/main/java/sub/handler/BoardHandler.java 변경
- src/main/java/sub/handler/CarinforHandler.java 변경
- src/main/java/sub/handler/CustomerHandler.java 변경
- src/main/java/sub/Ex1.java 변경

## 실습

### 작업1) ArrayList 클래스에 항목 값을 조회하고 변경하고 삭제하는 기능을 추가하라.

- ArrayList.java
  - 목록의 특정 위치에 저장된 항목을 꺼내주는 get()을 정의한다.
  - 목록의 특정 위치에 저장된 항목을 바꾸는 set()을 정의한다.
  - 목록의 특정 위치에 저장된 항목을 삭제하는 remove()를 정의한다.


### 작업2) 주차 상세조회, 변경, 삭제 기능을 추가하라.

- CarinforHandler.java (CarinforHandler.java.01)
  - 상세조회 기능을 수행하는 detailLesson()을 정의한다.
  - 변경 기능을 수행하는 updateLesson()을 정의한다.
  - 삭제 기능을 수행하는 deleteLesson()을 정의한다.
- App.java
  - 상세조회, 변경, 삭제 명령에 대한 분기문을 추가한다.

#### 실행 결과

```
명령> /carinfor/list
게시판 번호:1, 차종:제네시스
차량번호:123가1234, 차량위치: 110동 지하주차장
입차날짜:2020-01-08, 출차날짜:2020-01-08

게시판 번호:2, 차종:모닝
차량번호:124가1234, 차량위치: 105동 지하주차장
입차날짜:2020-01-08, 출차날짜:2020-01-09

게시판 번호:3, 차종:코나
차량번호:1523가7784, 차량위치: 101동 지하주차장
입차날짜:2020-01-10, 출차날짜:2020-01-15

게시판 번호:4, 차종:코나
차량번호:1574나1234, 차량위치: 110동 지하주차장
입차날짜:2020-01-08, 출차날짜:2020-01-08

명령> /carinfor/detail
번호? 2
번호: 0
차종: 제네시스
차량 번호: 123가1111
차량 위치: 2동 지하주차장
차량 입차 날짜 : 2020-01-01
차량 출차 날짜: 2020-02-02


명령> /carinfor/detail
번호? 20
자동차 정보 게시판 정보가 유효하지 않습니다.

명령> /carinfor/update
번호? 2
차종(제네시스)? 코나
차량 번호(123나1111)? 12가1234
차량 위치(2동 지하주차장)?    <= 입력하지 않으면 기본정보 사용
차량 입차 날짜(2020-01-01)? 
차량 출차 날짜(2020-02-02)?
자동차 정보를 변경했습니다.

명령> /carinfor/update
게시글 인덱스? 20
자동차 정보 게시판 정보가 유효하지 않습니다.

명령> /carinfor/delete
게시글 인덱스? 2
자동차 정보 게시판 정보를 삭제하였습니다.

명령> /carinfor/delete
번호? 20
해당 게시글 정보를 찾을 수 없습니다.
```

### 작업3) CustomerHandler 코드를 리팩토링하라.

- CustomerHandler.java
    - 저장된 목록에서 수업 번호로 항목을 찾는 코드를 indexOfLesson() 메서드로 분리한다.
    - 인스턴스 복제를 할 수 있도록 java.lang.Cloneable 인터페이스를 구현한다.


### 작업4) 회원 데이터의 상세조회, 변경, 삭제 기능을 추가하라.

- CustomerHandler.java
    - 상세조회 기능을 수행하는 detailMember()을 정의한다.
    - 변경 기능을 수행하는 updateMember()을 정의한다.
    - 삭제 기능을 수행하는 deleteMember()을 정의한다.
    - 저장된 목록에서 회원 번호로 항목을 찾는 indexOfMember()를 정의한다.
- Customer.java
    - 인스턴스 복제를 할 수 있도록 java.lang.Cloneable 인터페이스를 구현한다.
- App.java
    - 상세조회, 변경, 삭제 명령에 대한 분기문을 추가한다.

#### 실행 결과

```
명령> /customer/list
번호:1, 차종:제네시스
차량 번호 :11가1111, 사진:png
할인율:10%, 결제금액:15000원
결제유형:카드, 차량 주차장소:102동 앞
입·출차 상태:출차, 수납 구분:수납

명령> /customer/detail
게시글 인덱스? 0
번호: 11
차종: 제네시스
차량 번호: 11가1111
사진: png
할인율: 10%
결제금액: 15000원
결제 유형: 카드
차량 주차 장소: 102동 앞
입·출차 상태: 출차
수납구분: 수납

명령> /customer/detail
번호? 20
해당 고객 정보를 찾을수 없습니다.

명령> /customer/update
게시판 인덱스? 0
차종(제네시스)? 코나
차량 번호(11가1111)? <= 입력하지 않으면 기본정보 사용
사진(png)? 
할인율(출차)?
결제 금액(15000원)? 
결제 유형(카드)? 
차량 주차장소(102동 앞)?
입·출차 장소(출차)?
수납구분(수납)? 
고객 정보를 변경했습니다

명령> /customer/update
번호? 20
해당 고객 정보를 찾을수 없습니다.

명령> /customer/delete
번호? 2
고객 정보를 삭제했습니다.

명령> /customer/delete
번호? 20
해당 고객 정보를 찾을수 없습니다.
```

### 작업5) 게시글 데이터의 상세조회, 변경, 삭제 기능을 추가하라.

- BoardHandler.java
    - 상세조회 기능을 수행하는 detailBoard()을 정의한다.
    - 변경 기능을 수행하는 updateBoard()을 정의한다.
    - 삭제 기능을 수행하는 deleteBoard()을 정의한다.
- Board.java
    - 인스턴스 복제를 할 수 있도록 java.lang.Cloneable 인터페이스를 구현한다.
- App.java
    - 상세조회, 변경, 삭제 명령에 대한 분기문을 추가한다.

#### 실행 결과

```
명령> /board/list
1, 게시글입니다.                , 2019-01-01, 0
2, 두 번째 게시글입니다.        , 2019-01-01, 0
3, 세 번째 게시글입니다.        , 2019-01-01, 0

명령> /board/detail
번호? 1
내용: 게시글입니다.
작성일: 2019-01-01

명령> /board/detail
번호? 20
해당 게시글을 찾을 수 없습니다.

명령> /board/update
번호? 1
내용?      <=== 입력하지 않으면 기존 값 사용
게시글을 변경했습니다.

명령> /board/update
번호? 20
해당 게시글을 찾을 수 없습니다.

명령> /board/delete
번호? 2
게시글을 삭제했습니다.

명령> /board/delete
번호? 20
해당 게시글을 찾을 수 없습니다.
```