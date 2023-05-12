package eclass.hackthon.mercedesbenz.io.eclassteam.entity;

import jakarta.persistence.*;

import java.util.Set;

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