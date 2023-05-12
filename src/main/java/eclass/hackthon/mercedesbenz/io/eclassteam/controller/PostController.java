package eclass.hackthon.mercedesbenz.io.eclassteam.controller;

import eclass.hackthon.mercedesbenz.io.eclassteam.entity.Post;
import eclass.hackthon.mercedesbenz.io.eclassteam.service.PostService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Defines a REST API endpoint for creating a new post using a PostService.
 */
@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }
}