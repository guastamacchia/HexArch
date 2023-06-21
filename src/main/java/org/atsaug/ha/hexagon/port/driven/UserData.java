package org.atsaug.ha.hexagon.port.driven;

import java.time.LocalDate;

public interface UserData {
	
	String name();

	String surname();

	String email();

	LocalDate birthDate();
	
	default boolean isBirthday(int monthValue, int dayOfMonth) {
		return this.birthDate().getDayOfMonth() == dayOfMonth
			&& this.birthDate().getMonthValue() == monthValue;
	}
}