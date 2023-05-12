package eclass.hackthon.mercedesbenz.io.eclassteam.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import eclass.hackthon.mercedesbenz.io.eclassteam.entity.Post;
import jakarta.annotation.PostConstruct;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class MercedesApiService {
    private final RestTemplate restTemplate;
    private ConcurrentHashMap<String, String> modelLinks;

    public MercedesApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.modelLinks = new ConcurrentHashMap<>();
    }

    
    @PostConstruct
    public void fetchModelData() {
        String url = "https://dev.api.oneweb.mercedes-benz.com/hackathon/deeplinks/models";
        ResponseEntity<String[]> response = restTemplate.getForEntity(url, String[].class);
        String[] models = response.getBody();
        for (String model : models) {
            String deeplink = fetchDeeplink(model);
            modelLinks.put(model, deeplink);
        }
    }
    
    public String getDeeplink(String model) {
        return modelLinks.get(model);
    }

    public void addDeeplinkToPost(Post post) {
        for (String tag : post.getTags()) {
            if (modelLinks.containsKey(tag)) {
                post.addDeeplink(modelLinks.get(tag));
                break;
            }
        }
    }

	public String fetchDeeplink(String model) {
		String deeplink = restTemplate.getForObject("https://dev.api.oneweb.mercedes-benz.com/hackathon/deeplinks/models/" + model, String.class);
		return deeplink;
	}

}
