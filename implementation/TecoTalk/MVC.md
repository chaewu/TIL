## MVC란?

-  Model-View-Controller의 약자
	-  유지보수가 편해지는 코드 구성 방식이다

### MVC 이해를 돕기 위한 예제

> 사용자가 Google에 "코딩"이라고 검색했다고 가정해보자

-  사용자가 검색한 "코딩"(이하 검색어)은 Controller에 전달
	-  이후 Controller는 Model에게 검색어에 대한 검색 결과 데이터를 요청
	-  Controller은 검색 결과 데이터를 반환 받은 후 그 데이터를 View로 전달
		-  이때 View는 사용자 레이아웃(UI)에 검색 결과 데이터를 넣어서 페이지를 사용자에게 전달

### 역할

-  Model은 데이터와 관련된 처리를 하는 역할
-  Controller은 Model과 View의 중간에서 데이터를 전달하는 역할
-  View는 Controller에게 전달받은 데이터를 사용자에게 전달하는 역할

### MVC 패턴을 지키면서 코딩하는 방법

1. Model은 Controller과 View에 의존하지 않아야 한다.
	-  Model 내부에는 Controller과 View에 관련된 코드가 있어서는 안됨
2. View는 Model에만 의존해야하고 Controller에는 의존하지 않아야 한다.
	-  View 내부에 Model의 코드는 있을 수 있지만, Controller의 코드가 있어서는 안됨
3. View가 Model에게 의존하는 경우는 사용자마다 다르게 보여주어야 하는 데이터의 경우에만 받아야 함
	-  UI(레이아웃)에 관한 정보나 모든 사용자에게 동일하게 보여주는 정보는 View가 지니고 있어야 함
4. Controller은 Model과 View에게 의존할 수 있다.
	-  Controller의 경우 Model과 View의 중개자 역할을 하며 전체 로직을 구성하기 때문에 Controller 내부에는 View와 Model의 코드가 있을 수 있음
5. View가 Model로부터 데이터를 받을 때는 반드시 Controller에서 받아야 한다.

