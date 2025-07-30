package spring.mvc.basic_ict05.ch10;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker{

	@Override
	public void volumeUp() {
		System.out.println("AppleSpeaker - volUp()");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("AppleSpeaker - volDown()");
	}
}
