package eclass.hackthon.mercedesbenz.io.eclassteam.controller;

import eclass.hackthon.mercedesbenz.io.eclassteam.entity.User;
import eclass.hackthon.mercedesbenz.io.eclassteam.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Defines a REST controller for creating a user using a UserService.
 */
@RestController
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
}
