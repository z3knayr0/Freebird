package com.gloic.freebird.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@EqualsAndHashCode(exclude = "season")
@ToString(exclude = "season")
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private int episodeNum;

    private String stillPath;

    @Type(type = "text")
    private String overview;

    private String airDate;

    private LocalDateTime created;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "season_id", referencedColumnName = "id")
    private Season season;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Link> links = new ArrayList<>();

    public void addLink(Link link) {
        this.links.add(link);
    }

    @PrePersist
    protected void onCreate() {
        created = LocalDateTime.now();
    }
}
