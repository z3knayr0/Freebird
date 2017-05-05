package com.gloic.freebird.services.vo.tvshow.season;

import com.gloic.freebird.persistence.model.Season;
import lombok.Data;

import java.io.Serializable;

/**
 * SeasonLightVO is dedicated to be displayed in a grid or a list and contains minimal data
 * @author gloic
 */
@Data
public class SeasonLightVO implements Serializable {

    private Long id;
    private Integer seasonNumber;
    private String posterPath;
    private int episodeCount;
    private int episodeCountInDB;
    private String airDate;

    public SeasonLightVO(Season se) {
        this.id = se.getId();
        this.seasonNumber = se.getSeasonNumber();
        this.posterPath = se.getPosterPath();
        this.episodeCount = se.getEpisodeCount();
        this.episodeCountInDB = se.getEpisodes().size();
        this.airDate = se.getAirDate();
    }
}
