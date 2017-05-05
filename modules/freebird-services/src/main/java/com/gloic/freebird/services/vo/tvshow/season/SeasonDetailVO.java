package com.gloic.freebird.services.vo.tvshow.season;

import com.gloic.freebird.persistence.model.Season;
import com.gloic.freebird.services.vo.tvshow.TvShowLightVO;
import com.gloic.freebird.services.vo.tvshow.episode.EpisodeDetailVO;
import com.gloic.freebird.services.vo.tvshow.episode.EpisodeLightVO;
import com.gloic.freebird.services.vo.tvshow.episode.EpisodeVOMapper;
import lombok.Data;

import java.util.Comparator;
import java.util.List;

/**
 * SeasonDetailVO inherits from SeasonLightVO and add the episodes and TVShow
 * @author gloic
 */
@Data
public final class SeasonDetailVO extends SeasonLightVO {

    private String overview;
    private TvShowLightVO tvShow;
    private List<EpisodeDetailVO> episodes;

    public SeasonDetailVO(Season se) {
        super(se);
        this.overview = se.getOverview();
        this.tvShow = new TvShowLightVO(se.getTvShow());
        List<EpisodeDetailVO> collect = EpisodeVOMapper.toEpisodDetailVO(se.getEpisodes());
        collect.sort(Comparator.comparing(EpisodeLightVO::getEpisodeNum));
        this.episodes = collect;
    }
}
