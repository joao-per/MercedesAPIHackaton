package eclass.hackthon.mercedesbenz.io.eclassteam.service;

import eclass.hackthon.mercedesbenz.io.eclassteam.entity.Post;
import eclass.hackthon.mercedesbenz.io.eclassteam.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final DeeplinkService deeplinkService;

    public PostService(PostRepository postRepository, DeeplinkService deeplinkService) {
        this.postRepository = postRepository;
        this.deeplinkService = deeplinkService;
    }

    public Post createPost(Post post) {
        processTags(post);
        return postRepository.save(post);
    }

    private void processTags(Post post) {
        for (String tag : post.getTags()) {
            String deeplink = deeplinkService.fetchDeeplink(tag);
            if (deeplink != null) {
                post.addDeeplink(deeplink);
            }
        }
    }
}
