package org.atsaug.ha.hexagon.port.driven;

import java.util.Collection;
import java.util.Optional;

public interface UserRepository {
	Optional<Collection<UserData>> findUsersBornOn(int month, int dayOfMonth);
}
