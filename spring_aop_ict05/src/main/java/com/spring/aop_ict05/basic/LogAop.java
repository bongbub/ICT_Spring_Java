package com.spring.aop_ict05.basic;

import org.aspectj.lang.ProceedingJoinPoint;

// 횡단관심 클래스(공통 클래스) => 핵심 관심 출력 메서드 경과시간에 대한 로그 출력 클래스
public class LogAop {
	
	public void loggerAop(ProceedingJoinPoint joinPoint) {
		
		// 핵심클래스.비즈니스 메서드 정보 가져오기
		// Member 클래스의 getMemberInfo() 가져오기
		String signatureStr = joinPoint.getSignature().toLongString();
		System.out.println(signatureStr + "is Start!");
		
		// 시작된 시간 찍기
		Long start = System.currentTimeMillis();		// 비즈니스 메서드 시작 시간
		
		try {
			joinPoint.proceed();			// 로그를 다 찍었으니 핵심관심 작동을 명령
		} catch(Throwable e) {
			e.printStackTrace();
		} finally {
			// 무조건 작동하는 finally 시점에 end log 호출
			// 끝나는 시간
			Long end = System.currentTimeMillis();		// 비즈니스 메서드 종료 시간
			System.out.println(signatureStr + "is END!");
			// 경과 시간
			System.out.println(signatureStr + " 경과시간 : " + (end - start));
		}
	}
}
