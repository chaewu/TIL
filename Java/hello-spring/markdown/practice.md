<h1> 대충 공부한 내용 정리</h1>

<h3>`Static contents`와 `MVC`, `템플릿 엔진`</h3>

<br>

- `Static contents` 방식은 `resources` 디렉토리 아래의 html 등의 파일을 그대로 보여줌
   - 정적 콘텐츠는 `resources` 디렉토리 하위의 `static` 폴더에서 가져옴

<br>

- `MVC`, `템플릿 엔진` 방식은 서버에서 html을 약간의 변형을 통해 돌려줌(${} 등과 같은 방식)
  - `MVC`란? `Model, View, Controller`의 약자 
    - 예전에는 Jsp를 사용해 `View`에서 모든 처리를 했지만(model1 방식)
    - 역할과 책임, 관심사 분리를 위해 `View`에 다 때려박아서 안됨(ㅈ됨).
      - `View`에서는 화면을 그리는데 집중
      - `Controller`과 `Model`은 비지니스 로직과 관련 혹은 내부적인 처리

<br>

- `API`란?
  - Json 포맷으로 클라이언트에게 데이터 구조를 전달하는 것  

- Annotation
  - `@ResponseBody` : Http Body에 문자 내용을 직접 반환
    - `viewResolver` 대신 `HttpMessageConverter` 사용
    - 문자 처리는 `StringHttpMessageConverter`이 객체는 `MappingJackson2HttpMessageConverter`이 처리
      - Jackson 이란? -> 객체를 Json 포맷으로 바꿔주는 대표적인 라이브러리 (Spring에서 기본으로 채택함)
      
- 일반적인 웹 애플리케이션 계층 구조
  - `컨트롤러` : 웹 MVC에서의 컨트롤러 역할, API등
  - `서비스` : 서비스 핵심 비지니스 로직이 포함(중복 가입 방지 등)
  - `리포지토리` : DB 접근, 도메인 객체를 DB에 저장 및 관리
  - `도메인` : 회원, 주문, 쿠폰 등과 같은 DB에 주로 저장되는 비지니스 도메인 객체
  - `데이터베이스` : 대충 DB.. oracle, mysql 등등..

<h3>테스트 코드</h3>

- 테스트코드 작성 팁
  - 순서에 의존적으로 작성해서는 안됨
    - 테스트의 순서는 보장될 수 없다. 즉, 모든 테스트는 순서에 상관 없이 메서드별로 따로 동작하게끔 작성
      - 그러기 위해서는 하나의 테스트가 끝날 때 마다 데이터를 클리어 해줘야함
  - 다른 코드는 그러면 권고사직 당할지도 모르지만, `테스트 코드`는 직관적이게 작성하기 위해 영미권이 아니라면 한글로 작성해도 됨
  - 기본 구조
    - 기본적인 구조는 `given, when, then`을 사용하도록 하자
      - `given` : 무언가 주어짐 ex) 회원 정보 등
      - `when` : 어떤 것을 실행했을때 ex) 유저 조회
      - `then` : 그래서? 결과를 알려줌
  
<br>

- `TDD(Test-Drivin Development)`
  - TDD :  `main` 코드가 아닌 테스트 코드를 먼저 작성하고 이후에 `main`을 작성해 테스트에 부합하는지 여부를 확인하는 개발
    - 장점 : 객체 지향적인 코드 개발, 설계 수정시간의 단축, 리팩토링의 용이성, 테스트 문서의 대체 가능

  
- `JUnit`
  - 왜 씀? Java에서 개발한 기능을 테스트 할때 보통 `main`메서드를 실행하거나 컨트롤러를 통해서 실행함.
    - 이러한 방식은 `준비 및 실행`

- `Service`
  - service는 보통 비지니스 관련 로직들이 위치하므로 비지니스에 의존적으로 설계