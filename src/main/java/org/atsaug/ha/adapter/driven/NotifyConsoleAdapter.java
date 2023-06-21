package org.atsaug.ha.adapter.driven;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.atsaug.ha.hexagon.port.driven.Notify;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class NotifyConsoleAdapter implements Notify {

	@Override
	public void notify(String subject, String message) {
		System.out.println(subject);
		System.out.println(message);		
	}
}
