package eclass.hackthon.mercedesbenz.io.eclassteam.service;

import eclass.hackthon.mercedesbenz.io.eclassteam.entity.Post;
import eclass.hackthon.mercedesbenz.io.eclassteam.repository.PostRepository;
import org.springframework.stereotype.Service;

/**
 * Provides a method to create a new post by saving it to the PostRepository.
 */
@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }
    
}