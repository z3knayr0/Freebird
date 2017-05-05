package com.gloic.freebird.persistence.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gloic
 */
@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Type(type = "text")
    private String overview;

    private String releaseDate;

    private Integer idMovie;

    private String posterPath;

    private LocalDateTime created;

    private float popularity;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Link> links = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Genre> genres;

    public void addLink(Link link) {
        this.links.add(link);
    }

    @PrePersist
    protected void onCreate() {
        created = LocalDateTime.now();
    }
}
