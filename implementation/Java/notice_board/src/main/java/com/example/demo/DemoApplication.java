package com.example.demo;

import com.example.demo.builder.A;
import com.example.demo.repository.BoardRepository;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.javapoet.ClassName;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		// 이창보 빌드 패턴!
//		A a = A.builder()
//				.classNumber(3113)
//				.hobby("축구")
//				.name("이창보")
//				.build();
//
//		System.out.println(a.toString());

	}
}
