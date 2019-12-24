###008 src ###

# 009 - 패키지로 클래스를 분류하기

## 학습 목표

- 패키지를 이용하여 역할에 따라 클래스를 분류할 수 있다.

## 실습 소스 및 결과

- com.sub.handler 패키지 추가
- src/main/java/sub/handler/CarinforHandler.java 변경
- src/main/java/sub/handler/MemberHandler.java 변경
- src/main/java/sub/handler/BoardHandler.java 변경


## 실습

### 작업1) 사용자 명령을 처리하는 클래스를 별도의 패키지로 분류하라.

- 핸들러 패키지 생성
    - `sub.handler` 패키지 생성
- 핸들러 클래스를 `handler` 패키지로 이동
    - `CarinforHandler`, `CustomerHandler`, `BoardHandler` 클래스를 `sub.handler` 패키지로 옮긴다.
    - 다른 패키지에서 변수에 접근할 수 있도록 접근 제어를 `public` 으로 변경
- App.java 변경
    - 핸들러 클래스에 대해 import 문 추가
