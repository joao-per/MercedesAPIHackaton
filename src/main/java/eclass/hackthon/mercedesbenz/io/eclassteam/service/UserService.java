package eclass.hackthon.mercedesbenz.io.eclassteam.service;

import eclass.hackthon.mercedesbenz.io.eclassteam.entity.User;
import eclass.hackthon.mercedesbenz.io.eclassteam.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * Creates a new user and saves it to the UserRepository.
 */
@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}
	
}