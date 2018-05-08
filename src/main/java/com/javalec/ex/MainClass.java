package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Student student1 = ctx.getBean("student", Student.class); // xml에 있는 이미 생성된 객체 가져다 온것. new 연산자로 객체생성했던 앞전과 다름
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());
		
		System.out.println("==============================");
		
		Student student2 = ctx.getBean("student", Student.class); // xml에 있는 객체의 값을 set으로 바꿔줌
		student2.setName("뉴쏭구");
		student2.setAge(3);
		
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());
		
		System.out.println("==============================");

		if(student1.equals(student2)) {
			System.out.println("student1 == student2"); // student1 과 student2는 같은 객체.
		} else {
			System.out.println("student1 != student2");
		}
		
		ctx.close();
		
	}
	
}
