package eclass.hackthon.mercedesbenz.io.eclassteam.controller;

import eclass.hackthon.mercedesbenz.io.eclassteam.entity.Post;
import eclass.hackthon.mercedesbenz.io.eclassteam.entity.User;
import eclass.hackthon.mercedesbenz.io.eclassteam.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PostMapping("/users/follow")
    public void followUser(@RequestBody User user) {
        userService.followUser(user.getId(), user.getFollowers().iterator().next().getId());
    }

    @PostMapping("/users/feed")
    public List<Post> getUserFeed(@RequestBody User user) {
        return userService.getUserFeed(user.getId());
    }

    @PostMapping("/posts/like")
    public void likePost(@RequestBody User user) {
        userService.likePost(user.getId(), user.getLikedPosts().iterator().next().getId());
    }

}
