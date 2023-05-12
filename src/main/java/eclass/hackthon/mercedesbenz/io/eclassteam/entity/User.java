package eclass.hackthon.mercedesbenz.io.eclassteam.entity;

import java.util.Set;
import jakarta.persistence.*;

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Post> posts;

    public Long getId() {
        return id;
    }

}