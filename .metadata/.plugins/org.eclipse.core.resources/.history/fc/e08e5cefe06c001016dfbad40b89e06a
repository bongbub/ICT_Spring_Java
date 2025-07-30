package spring.mvc.basic_ict05.ch03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {


		AbstractApplicationContext context	= 				// GenericXmlAp... 의 부모 (==>다형성적용)
				new GenericXmlApplicationContext("appContext_03.xml");  	// 해당 파일을 로딩 하겠다
		
		SamsungTV tv = (SamsungTV)context.getBean("sam");
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOn();
		tv.powerOff();
	}
}
