package com.spring.aop_ict05.annotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("aopContext_02.xml");
		
		// 객체생성
		Member member = (Member)ctx.getBean("member");		
		member.getMemberInfo();
		
		ctx.close();
		
		// 실행 -> Main.java 우클릭 > Run As JavaApplication
	}
	
	
//	--디폴트 생성자 호출--
//	public void com.spring.aop_ict05.basic.Member.getMemberInfo() is start!!
//	<<< 핵심관심(비즈니스 로직) : 멤버정보 출력
//	id : gek2omg
//	pwd : qwer1234
//	name : 홍길동
//	hobby : 당구
}
