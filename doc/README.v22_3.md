###021_3 src ###

// 

# 022_3 `Iterator` 구현체와 논스태틱 중첩 클래스(non-static nested class; inner class)

## 학습 목표

- 논스태틱 중첩 클래스를 사용할 수 있다.
- 스태틱 중첩 클래스와 논스태틱 중첩 클래스 사이의 차이점을 이해한다.
- 논스태틱 중첩 클래스를 사용하여 인터페이스 구현체를 만들 수 있다.

## 실습 소스 및 결과
 
- src/main/java/sub/util/AbstractList.java 변경
- src/main/java/sub/util/Stack.java 변경
- src/main/java/sub/util/Queue.java 변경

## 실습

### 훈련1. ListIterator 중첨 클래스를 논스태틱 중첩 클래스로 만들어라

- AbstractList.java 
  - ListIterator 논스태틱 중첩 클래스로 변경하라
  - interator() 메서드를 변경한다.
  
### 훈련2. QueueIterator 클래스를 Queue 클래스의 중첩클래스로 만들라

- QueueIterator.java 
  - QueueIterator 논스태틱 중첩 클래스로 변경하라
  - interator() 메서드를 변경한다.
  
### 훈련3. StackIterator 클래스를 Steak 클래스의 중첩클래스로 만들라

- StackIterator
  - StakcIterator 논스태틱 중첩 클래스로 변경하라
  - interator() 메서드를 변경한다.