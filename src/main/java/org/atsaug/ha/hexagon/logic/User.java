package org.atsaug.ha.hexagon.logic;

import java.time.LocalDate;

import lombok.*;
import org.atsaug.ha.hexagon.port.driven.UserData;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class User {

	private String name;
	private String surname;
	private String email;
	private LocalDate birthDate;

	public static User fromUserData(UserData ud) {
		User u = new User();
		u.setName(ud.name());
		u.setSurname(ud.surname());
		u.setEmail(ud.email());
		u.setBirthDate(ud.birthDate());
		return u;
	}
}