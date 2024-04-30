## DTO와 VO의 정의
-  DTO는 Data Transfer Object의 약자이고 VO는 Value Object의 약자이다.

### DTO와 VO는 혼용해도 될까?

**결론부터 말하자면 안된다.**

-  DTO는 계층 간 데이터를 전달하기 위한 객체이다.
	-  예를 들어 Web Layer의 Controller가 Service Layer의 Service와 서로 데이터를 전달하려면 DTO를 사용한다
	-  이때 DTO는 오직 getter/setter 메서드 만을 가져야한다
-  VO는 값 그 자체를 표현하기 위한 객체이다.
	-  지폐를 생각해보자. 지폐는 모두 각각 고유한 번호를 지니고 있다. 하지만 지폐의 고유번호가 다르다고 해서 사람들에게 다른 가치의 지폐로 여겨지지는 않는다
		-  실제 객체에서는 지폐의 고유번호를 각 객체의 주소라고 생각하면 된다.
	-  값 그 자체를 나타내고 값으로만 비교되는 객체를 VO라고 한다

### DTO Class와 Entity Class

- Entity Class는 절대 요청이나 응답 값을 전달하는 클래스로 사용해서는 안된다.
	-  Entity Class가 Database와 연동되어 있는 핵심 클래스이기 때문
		-  이 때문에 Entitiy Class를 기준으로 테이블이 생성되고 스키마가 변경된다
	-  View는 비지니스 로직에서 자주 변경되는 부분이다
		-  Entity Class를 요청이나 응답 값을 전달하는 클래스로 사용하게 되면 Entity Class가 View에 맞춰서 매번 같이 변경되어야 하는 상황이 발생 됨
		-  대부분의 Service Class와 비지니스 로직들이 Entity Class에 맞춰서 동작하기 때문에 Entity Class가 변경되면 관련된 수 많은 클래스들에게 영향을 끼침
			-  요청이나 응답 값을 전달하는 클래스는 반드시 View의 변경에 따라 다른 클래스에 영향을 끼치지 않고 자유롭게 변경할 수 있는 DTO를 사용해야 한다
			-  결과값으로 여러 테이블들을 join한 결과 값을 조회할 경우가 빈번하기에 Entity Class 만으로는 응답 값을 표현하기 힘든 경우가 많다