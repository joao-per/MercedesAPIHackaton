package eclass.hackthon.mercedesbenz.io.eclassteam.entity;

import jakarta.persistence.*;


import java.util.Set;

/**
 * Represents a post with content, tags, and a user who created using JPA annotations.
 */
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String content;

	@ManyToOne
	private User user;

	@ElementCollection
	private Set<String> tags;
}