## `Gradle` 이란?

-  Gradle 공식 문서에 따르면 Gradle을 거의 모든 유형의 소프트웨어를 빌드할 수 있을 만큼 `유연한 빌드 자동화 도구` 라고 소개하고 있다

### `빌드 자동화 도구` 란?

-  빌드(Build)
	-  우리가 소스코드를 작성하게 되면 컴퓨터는 그것을 바로 이해할 수 없다.
		-  따라서 소스코드를 컴파일 및 의존성을 추가해 실행 가능한 파일로 패키징하고 압축 파일(.jar, .war)을 생성 하게되는데, 이를 `빌드` 라고 일컫는다.

-  빌드 도구(Build Tool)
	-  코드를 실행 가능한 파일로 만들어주는 과정(= 빌드) 및 라이브러리 관리, 테스팅 등을 `자동화`하여 수행
	-  빌드 도구를 사용하지 않는다면?
		-  반복적인 작업을 수작업으로 진행하야 함에 따라 비효율적
		-  라이브러리를 직접 다운로드 및 버전 업데이트 해야 함
		-  프로젝트의 의존성 파악이 어려워 짐

### 장점

> Gradle은 `Groovy 기반`의 `스크립트 언어`이다.

-  스크립트 언어의 장점
	-  동적으로 실행 가능
	-  추가적인 로직을 작성하고 싶을 때 스크립트 로직을 직접 작성할 수 있음
	-  Gradle이 지원하는 플러그인또한 호출 가능

-  Groovy 기반의 DSL의 장점
	-  Groovy 기반으로, 자바와 유사한 문법 구조를 가지며 Java와 호환 됨
	-  JVM에서 실행되는 스크립트 언어
> DSL이란) 특정 도메인을 대상으로 만들어진 특수 프로그래밍 언어

### 빌드 스크립트

-  Gradle에서는 build.gradle을 빌드 스크립트로 사용 (아래 예제 참고)

```Gradle
plugins {
	id 'java'
}

repositories {
	mavenCentral()
}

dependencies {
	testImplementation 'org.assertj:assertj-core:3.22.0'
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(11)
	}
}

test {
	useJUnitPlatform()
}
```

> <a href="https://youtu.be/V4knLFDG-ZM" target="blank">Reference</a>