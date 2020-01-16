###021_2 src ###

// 

# 022 `Iterator` 구현체와 중첩 클레스(nested class)

## 학습 목표

- 스태틱 중첩 클래스를 사용할 수 있다.
- 스태틱 중첩 클래스를 사용하여 인터페이스 구현체를 만들 수 있다.

## 실습 소스 및 결과


- 
- src/main/java/sub/util/ListIterator.java 삭제
- src/main/java/sub/util/AbstractList.java 삭제
- src/main/java/sub/util/StackIterator.java 삭제
- src/main/java/sub/util/Stack.java 변경
- src/main/java/sub/util/QueueIterator.java 삭제
- src/main/java/sub/util/Queue.java 변경

## 실습

### 훈련1. ListIterator 클래스를 AbstractList 클래스의 중첩클래스로 만들라

- AbstractList.java 
  - ListIterator 클래스를 스태틱 중첩 클래스로 정의한다.

- ListIterator
  - ListIterator를 삭제한다
  

### 훈련2. QueueIterator 클래스를 Queue 클래스의 중첩클래스로 만들라

- QueueIterator.java 
  - QueueIterator 클래스를 스태틱 중첩 클래스로 정의한다.
- QueueIterator
  - QueueIterator를 삭제한다
  
### 훈련3. StackIterator 클래스를 Steak 클래스의 중첩클래스로 만들라

- Stakc.java 
  - StackIterator 클래스를 스태틱 중첩 클래스로 정의한다.
- StackIterator
  - StakcIterator를 삭제한다