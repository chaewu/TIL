
# `Spring` and `Spring Boot`

### Static contents와 MVC, 템플릿 엔진
- `Static contents` 방식은 `resources` 디렉토리 아래의 html 등의 파일을 그대로 보여줌  
	- 정적 콘텐츠는 `resources` 디렉토리 하위의 `static` 폴더에서 가져옴  
  
- `MVC`, `템플릿 엔진` 방식은 서버에서 html을 약간의 변형을 통해 돌려줌(${} 등과 같은 방식)  
	- `MVC`란? `Model, View, Controller`의 약자  
		- 예전에는 Jsp를 사용해 `View`에서 모든 처리를 했지만(model1 방식)  
		- 역할과 책임, 관심사 분리를 위해 `View`에 다 때려박아서 안됨(ㅈ됨).  
			- `View`에서는 화면을 그리는데 집중  
			- `Controller`과 `Model`은 비지니스 로직과 관련 혹은 내부적인 처리
  
- `API`란?  
	- Json 포맷으로 클라이언트에게 데이터 구조를 전달하는 것  
  
- Annotation  
	- `@ResponseBody` : Http Body에 문자 내용을 직접 반환  
		- `viewResolver` 대신 `HttpMessageConverter` 사용  
		- 문자는 `StringHttpMessageConverter`이 처리
		- 객체는 Mapping`Jackson`2HttpMessageConverter이 처리  
			- Jackson 이란? -> 객체를 Json 포맷으로 바꿔주는 대표적인 `라이브러리` (Spring 기본 탑재)  
  
- 일반적인 웹 애플리케이션 계층 구조  
	- `컨트롤러` : 웹 MVC에서의 컨트롤러 역할, API등  
	- `서비스` : 서비스 핵심 비지니스 로직이 포함(중복 가입 방지 등)  
	- `리포지토리` : DB 접근, 도메인 객체를 DB에 저장 및 관리  
	- `도메인` : 회원, 주문, 쿠폰 등과 같은 DB에 저장되는 비지니스 도메인 객체  
	- `데이터베이스` : 대충 DB.. (oracle, mysql 등등.. )
  
### 테스트 코드  

#### 단위 테스트
- 테스트코드 작성 팁  
	- 순서에 의존적으로 작성해서는 안됨  
		- 테스트의 순서는 보장될 수 없다. 즉, 모든 테스트는 순서에 상관 없이 메서드별로 따로 동작하게끔 작성  
			- 그러기 위해서는 하나의 테스트가 끝날 때 마다 데이터를 클리어 해줘야함  
	- 기본 구조  
		- 기본적인 구조는 `given, when, then`을 사용하도록 하자 (강요는 아니고 필요)
			- `given` : 무언가 주어짐 ex) 회원 정보 등  
			- `when` : 어떤 것을 실행했을때 ex) 유저 조회  
			- `then` : 그래서? 결과를 반환해줌
	-  다른 코드는 메서드 명을 한글로 적으면 뚜까 맞지만, `테스트 코드`는 직관적이고 보다 편리하게 작성하기 위해 한글로 작성해도 됨
-  단위별로 잘 쪼개서 테스트 한다는 가정 하에, 통합 테스트보다는 단위 테스트가 좋은 경우가 압도적임 (Spring container 없이 테스트 진행, 속도 및 기타 이유로 단위 테스트가 뛰어남)

#### 통합 테스트
-  `@Transactional` annotation
	-  DB에는 기본적으로 Transaction이라는 개념이 존재함 (Data를 insert한 후에 commit || auto commit)
	-  해당 annotation을 test case에 작성하면 모든 테스트가 종료된 후 실행되기 이전으로 롤백
		-  즉, 테스트를 한 후 롤백하여 실제 db에 테스트 내용을 반영하지 않음 (다음 테스트 영향 X)
	-  해당 annotation을 붙히더라도 `@Commit` annotation을 테스트 코드에 붙혀주면 커밋을 할 수는 있다.
-  `@SpringBootTest` annotation
	-  스프링 컨테이너와 테스트를 함께 실행 (실제 Spring 환경에서 테스트 진행)

  
### TDD(Test-Drivin Development)

- `TDD` : main 코드가 아닌 테스트 코드를 먼저 작성하고 이후에 main을 작성해 테스트에 부합하는지 여부를 확인하는 개발  
	- 장점 : 객체 지향적인 코드 개발, 설계 수정시간의 단축, 리팩토링의 용이성, 테스트 문서의 대체 가능  
  
  
- `JUnit`  
	- 왜 씀? Java에서 개발한 기능을 테스트 할때 보통 `main`메서드를 실행하거나 컨트롤러를 통해서 실행  
		- 이러한 방식은 `준비 및 실행`이 오래 걸리기 마련이며 여러개의 테스트를 한번에 실행하기도 어려움  
			- 따라서 Java에서는 `JUnit` 프레임 워크를 사용  
  
- `Service`  
	- service는 보통 비지니스 관련 로직들이 위치하므로 비지니스에 의존적으로 설계  
  
### 의존성  

- `의존성` : 두 컴포넌트 사이의 의존성이란? 하나의 컴포넌트의 변경 사항이 다른 컴포넌트에도 영향을 미칠 가능성을 의미  
	- 코드가 복잡해질 수록 필연적으로 다양한 객체 간의 `협력 관계`가 만들어진다. 협력을 위해서는 객체의 존재 사실을 알아야 하며 다른 객체가 어떤 방식으로 `메시지 수신`을 하는지도 알아야 함  
  
- `의존성 주입` : 사용하는 객체가 아닌 외부의 독립된 개체가 인스턴스를 생성한 후 이를 전달해 의존성을 해결하는 방법  
	- ex) `@Autowired` annotation으로 외부 service, repository 객체에 `@Service`, `@Repository` annotation이 적용된 인스턴스 객체를 전달하는 것  
	-  크게 3가지 방법으로 나뉨
		-  생성자 주입, 필드 주입, setter 주입
			-  필드 주입은 spring이 최초 실행될때만 주입해주고 이후에 변경이 불가능
			-  Setter 주입은 public으로 생성되기에 한번 생성하고 이후에 변경 필요성이 없는 setMemberService가 public으로 노출
			-  그냥 생성자 주입을 사용하도록 하자. 의존 관계가 실행 중에 동적으로 변경될 경우는 없다 
  
- `@Autowired` : `Spring Container`에 등록된 `Bean`에게 의존 관계 주입이 필요할 때, DI(의존성 주입)을 도와주는 annotation
  
- `@Component`를 포함하는 다음 어노테이션들도 `Spring Bean`으로 자동 등록된다  
	- `@Controller`, `@Service`, `@Repository`

### 컴포넌트 스캔과 자동 의존관계 설정

-  `@Component` annotation이 있으면 spring bean에 자동 등록된다
-  `@Controller` 컨트롤러가 spring bean에 등록되는 이유 또한 컴포넌트 스캔에 의거한다
-  Spring에서는 spring container에 spring bean을 등록할 때, default로 싱글톤으로 등록(유일하게 하나만 등록하여 공유) 따라서 동일한 spring bean이라면 모두 같은 instance이다.
	-  Instance : 일반적으로 실행 중인 임의의 프로세스, 클래스의 현재 생성된 오브젝트를 칭함
-  실무에서는 정형화된 controller, service, repository 같은 코드는 component scan을 사용
-  정형화 되지 않거나 상황에 따라 구현 클래스를 변경해야 하는 경우에는 Spring Bean에 등록

### Open-Closed Principle (개방 ・ 폐쇄 원칙)

-  '확장에는 열려있고, 변경에는 닫혀있어야 한다'는 원칙
	-  Spring의 `Dependency Injection(DI)`를 사용하면 개방 ・ 폐쇄 원칙을 지키며 확장 가능

#### Spring JdbcTemplate
-  순수 JDBC(Java DataBase Connectivity)와 동일한 환경 설정 사용
-  Spring JdbcTemplate나 MyBatis 등의 라이브러리는 JDBC API에서 중복으로 사용되는 코드를 제거
	-  (하지만 SQL은 사용해야함. 이왕이면 JPA를 사용하도록 하자. 비유하자면 철기시대에 구석기 -> 신석기 쓰는 정도)
