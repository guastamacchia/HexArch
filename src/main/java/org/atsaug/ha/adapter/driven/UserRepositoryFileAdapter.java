package org.atsaug.ha.adapter.driven;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.atsaug.ha.hexagon.port.driven.UserData;
import org.atsaug.ha.hexagon.port.driven.UserRepository;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class UserRepositoryFileAdapter implements UserRepository {

	private static File usersFile;
	static {
		try {
			usersFile = Files.createTempFile("users", ".txt").toFile();
			FileUtils.writeStringToFile(usersFile, 
					"Gage,Dudley,vel.venenatis@milacinia.com,1967-10-27\nAbdul,Bowen,elementum@ullamcorpereueuismod.edu,1977-04-01\nFrancesco,Guastamacchia,info@atsaug.com,1985-06-21",
					"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Optional<Collection<UserData>> findUsersBornOn(int month, int dayOfMonth) {
		List<UserData> users = new ArrayList<>();
		try {
			List<String> lines = FileUtils.readLines(usersFile, "UTF-8");
			
			for(String line : lines) {
				String[] u = line.split(",");
				
				UserData user = UserDataImpl
									.builder()
									.name(u[0])
									.surname(u[1])
									.email(u[2])
									.birthDate(LocalDate.parse(u[3]))
									.build();
				if(user.isBirthday(month, dayOfMonth)) {
					users.add(user);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Optional.of(users);
	}

}
