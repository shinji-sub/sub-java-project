###028_2 src ###

# 029_2 - 애플리케이션을 시작하거나 종료할 때 데이터를 로딩하고 저장할 옵저버를 추가한다.

## 실습 소스 및 결과

- src/main/java/sub/Ex1.java 변경
- src/main/java/sub/DataLoaderListener.java 추가


## 실습

### 훈련 1: 애플리케이션을 시작하거나 종료할 때 작업을 수행할 옵저버를 만들라.

- DataLoaderListener.java추가 (DataLoaderListener.java.01)
 - ApplicationCintextListener 를 구현한다.
 - 테스트 할 용도로 간단하게 구현한다.
 
### 훈련 2: DataLoaderListener 옵저버를 Ex1 객체에 등록한 후 실행되는 걸 확인하라.

- Ex1.java 변경 (Ex1.java.01)
 - DataLoaderListener 객체를 생성한 후 Ex1 객체에 등록한다.
 - 실행하여 옵저버가 등록하는 지를 확인한다.
 
### 훈련3: DataLoatderLister 옵저버에서 데이터를 로딩하고 저장하게 하라.

- DataLoaderListener.java 변경 (DataLoaderListener.java.02)

 - Ex1 클래스에 있는 List 객체를 이 클래스로 옮긴다.
 - Ex1 클래스에 있는 데이터 로딩, 저장 관련 메서드를 이 클래스로 옮긴다.
 
-Ex1.java 변경
 - List 객체를 필드에서 제거한다. (DataLoaderListener가 할 일이다.)
 - 데이터 로딩, 저장 관련 메서드를 제거한다. (DataLoaderListener가 할 일이다.)
 - 데이터 로딩 호출 코드를 제거한다. (DataLoaderListener가 할 일이다.)
 - 데이터 저장 호출 코드를 제거한다. (DataLoaderListener가 할 일이다.)
 
### 훈련 4: Ex1 클래스가 옵저버의 결과물을 사용할 수 있게 하라.
- ApplicationContextListener.java(변경)
   - contextInitialzed()에 Map 파라미터를 추가한다
   - contexDestroyedalized()에 Map 파라미터를 추가한다
   
### 훈련 5: DataLoaderListener의 작업 결과를 Map 객체를 통해 공유하라.

- DataLoaderListener.java(변경)
   - 데이터 로딩 결과를 Map 객체에 보관한다.
   
### 훈련 6: DataLoaderListener에서 준비한 List 객체를 Command에게 전달하라.

App.java (변경)
  - 애플리케이션이 시작될 때 옵저버를 실행한 후 Map 에 저장된 작업 결과를 꺼내
    Command 객체에 전달한다.