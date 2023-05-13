package eclass.hackthon.mercedesbenz.io.eclassteam.service;

import eclass.hackthon.mercedesbenz.io.eclassteam.entity.Post;
import eclass.hackthon.mercedesbenz.io.eclassteam.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final MercedesApiService mercedesApiService;

    public PostService(PostRepository postRepository, MercedesApiService mercedesApiService) {
        this.postRepository = postRepository;
        this.mercedesApiService = mercedesApiService;
    }

    public Post createPost(Post post) {
        mercedesApiService.addDeeplinkToPost(post);
        return postRepository.save(post);
    }
}

