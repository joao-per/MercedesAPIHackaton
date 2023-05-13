package eclass.hackthon.mercedesbenz.io.eclassteam.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a post with content, tags, and a user who created using JPA annotations.
 */
@Entity
@Table(name = "post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String content;

	@JoinColumn(name = "user_id")
	@ManyToOne
	private User user;

	@ElementCollection
	private Set<String> tags;

	private String deeplink;

	public Long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public User getUser() {
		return user;
	}

	public Set<String> getTags() {
		return tags;
	}

	public String getDeeplink() {
		return deeplink;
	}

	public void addDeeplink(String deeplink) {
        if (this.deeplink == null) {
            this.deeplink = deeplink;
        }
    }

	public void setId(Long id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public void setDeeplink(String deeplink) {
		this.deeplink = deeplink;
	}

	@ManyToMany(mappedBy = "likedPosts")
	private Set<User> likedByUsers = new HashSet<>();
}