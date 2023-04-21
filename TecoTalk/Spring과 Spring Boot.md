
## Spring은 왜 Spring(봄) 일까?
-  간략하게 말하면개발자들에게 겨울은 끝나고 'Spring Framework를 통해 봄이 시작되었다'는 의미
	-  근데 아직도 추워.. 왜 맨날 터져 내 스프링만...

### Spring Boot는 뭘까?
> Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".

-  위 문장을 직설적으로 해석하면 "쉽게 만든다, 단독적인 상용화 수준의 스프링 기반 애플리케이션을" 정도가 된다.

### Spring과 Spring Boot의 차이점은 뭔데?
-  가장 큰 차이점은 `dependency`(의존성) 이라고 생각한다.
	-  기존 Spring의 dependency는 길다.. 정말 너무 길어
	-  거기다 모든 dependency를 버전까지 정확하게 명시해줘야 한다. (아래 코드 참고)
```dependency
<dependency>
	<groupId>org.thymeleaf</groupId>
	<artifactId>thymeleaf-spring4</artifactId>
	<version>2.1.4.RELEASE</version>
</dependency>
```
-  그에 반해 Spring Boot는 짧아졌다. 조금..
	-  버전 관리도 권장 버전으로 자동 설정 해줌
	-  Gradle을 사용하면 훨씬 훨씬 짧아짐(대충 아래 보면 뭔지 알거에요)
	-  `org.springframework.boot:spring-boot-starter`이 붙은 친구들을 implementation하면 의존성이 있는 친구들은 자동으로 의존 관계를 부여 해준다.
```Build.gradle
dependencies {
	testImplementation 'org.junit.jupiter:junit-jupiter-api'
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
}
```

#### 다음으로는 configurations의 차이도 있다.
	-  기존 Spring Framework을 사용한다면 굉장히 길게 적어야 한다.
		-  config라는 class를 생성하여 거기에 또 bean에 등록할 것을 수동으로 작성하고... (진짜 김)
	-  Spring Boot는 config 파일 자체를 작성할 필요가 없다. (무친 장점)
		-  그냥 application.properties만 작성하면 된다. 또는 application.yml
			-  요즘은 properties에서 yml로 넘어가는 추세이며 호환도 잘 됩니다! (형식은 아래 참고)

```properties
spring.h2.console.enbled=true
spring.h2.console.path=/h2-console

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```
ㄴ> 요건 Properties
```yml
spring:
  h2:
    console:
      enabled: true
        path: /h2-console
  jpa:
    show-sql: true
	properties:
	  hibernate:
	    format_sql: true
```
ㄴ> 요건 YML

-  보기에는 yaml이 더 길어보이지만 중복되는 부분(ex)spring.jpa.~)를 한번에 날려버릴 수 있다. 
	심지어는 더 humanable(사람이 알아보기 쉽게) 작성할 수 있다.

> 참고해두면 좋은 정보) YAML은 Yaml Ain't Markup Language (Yaml은 마크업 언어가 아니다) 정도가 되겠네요. (Linux랑 비슷한 의미를 지니고 있다.) 

> 초기에는 Yet Another Markup Language라서 YAML로 불렸다.

#### 또한 이러한 장점도 있습니다
-  embedded server (내장 tomcat server)
	-  서버가 내장되어 있으면 뭐가 좋은데?
		- ㄴ> 절반 가까이 시간이 단축된다 (기존에는 외부에서 불러오지만 이제는 포함하고 있기 때문에)
	-  내장 tomcat이 싫으면?
		-  configurations과 dependencies를 살짝 수정해주면 tomcat -> jetty로 바꿀 수 있다.
			-  다른 서버도 가능하며 추가적인 내용은 구글링!
	-  내장 서버의 가장 큰 장점은?
		-  `java -jar $REPOSITORY/$JAR_NAME &`
			-  내장 서블릿 컨테이너 덕분에 jar 파일로 배포 과정을 간략화 할 수 있다! (진짜 좋음)


## 4줄 요약 (차이점)

-  간편한 설정

-  편리한 의존성 관리 & 자동 권장 버전 관리

-  내장 서버로 인한 간단한 배포 서버 구축

-  스프링 Security, Data JPA 등의 다른 스프링 프레임워크 요소를 쉽게 사용 가능
