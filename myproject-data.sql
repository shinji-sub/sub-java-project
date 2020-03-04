-- 자동차 테이블 삭제 
drop table if exists carinfor;

-- 회원 테이블 삭제
drop table if exists customer;

-- 게시판 테이블 삭제 
drop table if exists car_board;

-- 자동차 테이블 생성
create table carinfor (
  carinfor_id int not null auto_increment primary key comment '자동차 데이터 식별 번호', 
  cdt varchar(100) not null comment '차종',
  cnb varchar(120) not null comment '차 번호',
  par varchar(50) not null comment '주차장',
  datas  datetime  not null comment '입차 시간',
  departure datetime null comment '출차 시간'
) comment '자동차 정보'; 

-- 주차 고객 테이블 생성
create table customer (
  customer_id int not null auto_increment primary key comment '회원 데이터 식별 번호',
  car_tp varchar(100) not null comment '차종',
  cnb varchar(120) not null comment '차 번호',
  photo varchar(255) comment '사진',
  discount varchar(25) comment '할인율',
  pay varchar(35) not null comment '결제 금액', 
  gyeoljeyuhyeong varchar(10) not null comment '결제 유형',
  par varchar(50) not null comment '주차장',
  exit_car varchar(30) not null comment '출차 정보',
  accep varchar(20) not null comment '수납 구분'
) comment '주차 고객';
  
-- 게시물 테이블 생성
create table car_board (
  board_id int not null auto_increment primary key comment '게시물 식별 번호',
  conts text not null comment '내용',
  cdt datetime default now() comment '생성일',
  vw_cnt int default 0 comment '조회수' 
) comment '게시물';