package eclass.hackthon.mercedesbenz.io.eclassteam.controller;

import eclass.hackthon.mercedesbenz.io.eclassteam.entity.Post;
import eclass.hackthon.mercedesbenz.io.eclassteam.entity.User;
import eclass.hackthon.mercedesbenz.io.eclassteam.service.UserService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Defines a REST controller for creating a user using a UserService.
 */
/**
 * Defines a REST controller for creating a user using a UserService.
 */
@RestController
@RequestMapping("/users")
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

    @PostMapping
    public User createUser(@RequestBody User user) {
      return userService.createUser(user);
    }

    @PostMapping("/{userId}/follow/{followerId}")
    public void followUser(@PathVariable Long userId, @PathVariable Long followerId) {
      userService.followUser(userId, followerId);
    }

    @PostMapping("/{userId}/like/{postId}")
    public void likePost(@PathVariable Long userId, @PathVariable Long postId) {
      userService.likePost(userId, postId);
    }

    @GetMapping("/{userId}/feed")
    public List<Post> getUserFeed(@PathVariable Long userId) {
      return userService.getUserFeed(userId);
    }
  }
