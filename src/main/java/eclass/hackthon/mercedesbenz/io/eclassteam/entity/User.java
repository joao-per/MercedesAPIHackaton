package eclass.hackthon.mercedesbenz.io.eclassteam.entity;

import java.util.Set;
import jakarta.persistence.*;
import java.util.HashSet;

/**
 * Represents a User entity with an ID, username, and a set of posts associated
 * with it.
 */
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	public String getUsername() {
		return username;
	}

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Post> posts;

	public Long getId() {
		return id;
	}

	@ManyToMany
	@JoinTable(
		name = "followers",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "follower_id")
	)
	private Set<User> followers = new HashSet<>();


	public Set<Post> getPosts() {
		return posts;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<User> getFollowers() {
		return followers;
	}

	


	@ManyToMany
	@JoinTable(
		name = "likes",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "post_id")
	)
	private Set<Post> likedPosts = new HashSet<>();

	public Set<Post> getLikedPosts() {
		return likedPosts;
	}



}