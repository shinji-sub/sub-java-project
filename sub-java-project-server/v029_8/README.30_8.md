h# 30_8 - DAO 클래스의 공통점을 뽑아 수퍼 클래스로 정의하기(generalization 수행하기)

## 학습목표

- 상속의 기법 중 generalization을 이해한다.
- generalization을 구현할 수 있다.

## 실습 소스 및 결과

- src/main/java/sub/lms/dao/AbstractObjectFileDao.java 추가
- src/main/java/sub/lms/dao/BoardObjectFileDao.java 변경
- src/main/java/sub/lms/dao/CustomerObjectFileDao.java 변경
- src/main/java/sub/lms/dao/CarinforObjectFileDao.java 변경

## 실습

### 훈련 1: DAO의 공통점을 뽑아 수퍼 클래스로 정의하라.

- sub.lms.dao.AbstractObjectFileDao 클래스를 생성한다.

### 훈련 2: BoardObjectFileDao가 위에서 정의한 클래스를 상속 받도록 변경하라.

- src/main/java/sub/lms/dao/BoardObjectFileDao.java 변경
  - 상속 받은 필드와 메서드를 사용한다.
  - indexOf()를 오버라이딩한다.
  
### 훈련 3: LessonObjectFileDao가 위에서 정의한 클래스를 상속 받도록 변경하라.

- src/main/java/sub/lms/dao/dao/CustomerObjectFileDao.java 변경
  - 상속 받은 필드와 메서드를 사용한다.
  - indexOf()를 오버라이딩한다.
  
### 훈련 4: MemberObjectFileDao가 위에서 정의한 클래스를 상속 받도록 변경하라.

- src/main/java/sub/lms/dao/CarinforObjectFileDao.java 변경
  - 상속 받은 필드와 메서드를 사용한다.
  - indexOf()를 오버라이딩한다.