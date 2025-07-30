package spring.mvc.basic_ict05.ch07;

import org.springframework.stereotype.Component;

@Component("tv")			// getBean("tv")를 주었기 때문에 tv붙여줘야함
public class LgTV implements TV{


	// 디폴생
	public LgTV() {
		System.out.println("LgTV의 디폴트생성자");
	}
	
	@Override
	public void volUP() {
		System.out.println("LgTV - volUP()");
	}

	@Override
	public void volDo() {
		System.out.println("LgTV - vulDo()");
	}

	@Override
	public void powerOn() {
		System.out.println("LgTV - powerOn()");
	}

	@Override
	public void powerDown() {
		System.out.println("LgTV - powerDown()");
	}
	
}
