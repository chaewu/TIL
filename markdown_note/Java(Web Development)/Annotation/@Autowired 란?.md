# 1. `@Autowired` Annotataion의 정의
>@Autowired : Spring Container에 등록된 `Bean`에게 의존 관계 주입이 필요할 때, 
>DI(의존성 주입)을 도와주는 annotation

- 어떻게?
	- `@Autowired` annotation을 사용함으로써 외부 service, repository 객체에 `@Service`, `@Repository`이 적용된 인스턴스 객체를 전달

## 1.1 지향성
>![[Pasted image 20240501004817.png]] 해당 image는 intelliJ에서 @Autowired 어노테이션을 사용시에 볼 수 있는 경고다.

>[!Tips] Spring 의존성 주입에는 세가지 종류가 있다. 하지만, [스프링 공식 래퍼런스](https://docs.spring.io/spring-framework/docs/5.2.3.RELEASE/spring-framework-reference/core.html#beans-factory-collaborators)에는 두가지 종류만 소개하고 있다.

- 생성자 기반 DI
- Setter 기반 DI
- **Field 기반 DI**
	- `@Autowired`가 이 경우에 해당된다.

### 1.1.1 Field Injection의 폐해
위 내용에서 설명하듯, 필드 기반 의존성 주입은 스프링 공식 문서에서도 차별 대우를 당하고 있다. 
그 이유를 알아보자

- Field Injection으로 주입된 객체는 **불변성**을 가질 수 없다.

Java에서는 생성자 기반 DI만이 final 선언이 가능하다. 고로 생성자 DI를 제외한 다른 방식으로 의존성을 주입하면 객체는 임의로 변경 가능한 상태(가변성)를 가지게 된다.

- Spring DI 컨테이너에 강한 결합이 발생한다.

Field Injection은 생성자를 통해서도 Setter를 통해서 주입 받는 방식도 아니다.
따라서, 리플렉션을 제외하면 Spring이 아니면 필드에 주입할 수 있는 방법이 없다.
그러므로 **Spring DI Container**가 아니면 작동하지 않는 코드 조각이 되버린다. 

- 단일 책임 원칙(SRP) 위반 경고를 은폐한다.

생성자 기반 DI는 주입받는 객체가 많아질 수록 코드의 길이가 길어져 리팩토링의 필요성을 경고하지만,
필드 기반 DI는 이 부분을 표시하지 않는다.

### 1.2 그럼에도 불구한 장, 단점(내 생각)
> 여기서부터는 매우 주관적인 제 의견입니다. 다른 의견이 있으다면 모두 적극 환영합니다(댓글 써주세요).

스프링 4.3 이후부터는 생성자 기반 DI에서 빈의 생성자가 단 하나만 존재할 시 `@Autowired`를 생략해도 자동으로 주입된다. (Autowired의 기능)

`@Autowired` 어노테이션이 많은 질타를 받음에도 불구하고 많은 레거시코드에 사용되는 점, 비지니스가 가미되지 않은 소규모 프로젝트에서는 해당 어노테이션이 가지는 편리함을 무시할 수 없다고 생각한다.

그렇지 않다면 해당 어노테이션을 지속적으로 발전 중인 Spring Framework에서 이미 제거하지 않았을까? 라는 개인적인 의견이다. 비효율적이고 위험한 로직이라는 의견에는 이견이 없지만, 위에서 열거한 단점들이 있기에, 가질 수 있는 편리함이 분명 있다고 생각한다. 

- [2] Spring 5.2.3 레퍼런스에 의하면, 필수 의존성의 경우 생성자 기반 DI를, 옵셔널한 의존성의 경우 세터 기반 DI를 사용하길 권고한다.

> [!quote] <a href="https://sightstudio.tistory.com/20" target="blank">Reference</a>