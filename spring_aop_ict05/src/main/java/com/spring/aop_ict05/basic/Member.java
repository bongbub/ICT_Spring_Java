package com.spring.aop_ict05.basic;


// 핵심관심 클래스 - 비즈니스 로직( 고객의 요청사항) 포함 => member 정보 출력
// 모든 메서드가 join point - 포인트 컷 대상
public class Member {
	private String id;
	private String pwd;
	private String name;
	private String hobby;
	
	
	public Member() {
		System.out.println(" ~~ 디폴트 생성자 호출 ~~");
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	// 출력메서드
	public void getMemberInfo() {
		System.out.println(" << 핵심관심(비즈니스 로직) : 멤버 정보 출력 >> ");
		System.out.println("아이디 : " +  getId());
		System.out.println("비밀번호 : " + getPwd());
		System.out.println("이름 : " + getName());
		System.out.println("취미 : " + getHobby());
	}
	
}
