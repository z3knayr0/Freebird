package com.gloic.freebird.services.vo.tvshow.episode;

import com.gloic.freebird.persistence.model.Episode;
import com.gloic.freebird.services.vo.link.LinkVOMapper;
import com.gloic.freebird.services.vo.tvshow.TvShowLightVO;
import com.gloic.freebird.services.vo.tvshow.season.SeasonLightVO;
import lombok.Data;

/**
 * EpisodeDetailVO inherits from EpisodeLightVO and add detailed informations about the episode
 * @author gloic
 */
@Data
public final class EpisodeDetailVO extends EpisodeLightVO {

    private Long size;
    private String overview;
    private String airDate;
    private SeasonLightVO season;
    private TvShowLightVO tvShow;

    public EpisodeDetailVO(Episode e) {
        super(e);

        this.overview = e.getOverview();
        this.airDate = e.getAirDate();

        this.season = new SeasonLightVO(e.getSeason());
        this.tvShow = new TvShowLightVO(e.getSeason().getTvShow());
        this.links = LinkVOMapper.toLinkDetailVO(e.getLinks());
    }
}