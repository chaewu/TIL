## `JDBC`의 정의
-  Java DataBase Connectivity의 약자

### `JDBC`의 단점
-  `SQL`문(query)을 일일이 작성 해줘야 한다
-  `Connection` 객체를 직접 수동으로 열고 닫아야 한다(관리의 필요성)
-  `preparedstatement`, `resultset` 등과 같은 객체로 조건을 전달하고 결과 값을 전달 받아야 한다

## JPA의 정의
-  Java Persistence API의 약자

### JPA의 특징
-  `java application`과 `jdbc api` 사이에서 매개하는 역할을 한다
	-  `java application`을 만들때 SQL구조를 생각하지 않고 평소에 프로그래밍 하는 방식으로 데이터에 접근 할 수 있도록 한다
-  장점
	- `SQL`문을 `java application`에 적을 경우가 적어진다
	-  `SQL` 구조를 `java application`내에서 적용하지 않아도 된다
		-  `SQL 테이블` 간의 참조를 위해서는 sql 테이블 하나에서 다른 테이블의 `foreign key`를 필요로 하지만 아래 코드처럼 작성하면 JPA에서 Join Query를 자동으로 작성해 다른 테이블에 참조를 위해 접근할 수 있다.
-  단점
	-  객체간의 매핑 설계가 잘못되었을때, 성능 저하가 발생할 수 있다
	-  자동으로 생성되는 Query가 많아짐에 따라 의도하지 않은 Query들로 인해 성능 저하 발생 가능성 존재
	-  더욱 더 많은 자료는  'why jpa hibernate awful' 을 구글에 검색해보면 추가적인 정보를 얻을 수 있다

```java
@Entity
@Table(name = "ORDERS")
public class Order {

	@Id @GeneratedValue
	@Column(name = "ORDER_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member member; // 주문 회원
}
```

