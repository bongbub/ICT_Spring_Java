package spring.mvc.basic_ict05.ch10;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker{
	
	@Override
	public void volumeUp() {
		System.out.println("SonySpeaker - volUp()");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("SonySpeaker - volDown()");
	}
}
