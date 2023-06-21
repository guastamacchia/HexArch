package org.atsaug.ha.hexagon.logic;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.atsaug.ha.hexagon.port.driven.Notify;
import org.atsaug.ha.hexagon.port.driven.UserData;
import org.atsaug.ha.hexagon.port.driven.UserRepository;
import org.atsaug.ha.hexagon.port.driver.BirthdayService;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Component
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class BirthdayServiceImpl implements BirthdayService {

	private final UserRepository userRepository;
	private final Notify notify;

	public void wishHappyBirthday(LocalDate birthDay) {
		Optional<Collection<UserData>> userData = userRepository.findUsersBornOn(birthDay.getMonthValue(), birthDay.getDayOfMonth());
		userData.ifPresent(uc -> uc.stream()
							       .map(User::fromUserData)
								   .forEach(this::sendWishMessage)
						  );
	}

	private void sendWishMessage (User aUser) {
		notify.notify("Happy birthday!", MessageFormat.format("Happy birthday {0}!", aUser.getName()));
	}
}
