###028_3 src ###

# 029_3 - 애플리케이션을 시작하거나 종료할 때 안내 문구를 출력하기

## 실습 소스 및 결과

- src/main/java/sub/Ex1.java 변경
- src/main/java/sub/GreetinListener.java 추가


## 실습

### 훈련 1: 애플리케이션을 시작하거나 종료할 때 안내 문구를 출력할 옵저버를 만들라.

- GreetinListener.java 추가 
 - ApplicationCintextListener 를 구현한다.
 - 안내 문구를 출력한다.
 
### 훈련 2: 옵저버를 Ex1 객체에 등록하고 실행되는 걸 확인하라.

- Ex1.java 변경 
 - GreetinListener객체를 생성한 후 Ex1 객체에 등록한다.
 - 실행하여 옵저버가 동작하는 지를 확인한다.