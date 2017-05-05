package com.gloic.freebird.services.vo.tvshow;

import com.gloic.freebird.persistence.model.Season;
import com.gloic.freebird.persistence.model.TvShow;
import com.gloic.freebird.services.vo.tvshow.season.SeasonLightVO;
import lombok.Data;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TvShowDetailVO extends TvShowLightVO and contains more information
 * @author gloic
 */
@Data
public final class TvShowDetailVO extends TvShowLightVO {
    private String overview;
    private Collection<SeasonLightVO> seasons;
    private String firstAirDate;

    public TvShowDetailVO(TvShow tvShow, List<Season> seasons) {
        super(tvShow);
        this.overview = tvShow.getOverview();
        this.firstAirDate = tvShow.getFirstAirDate();
        List<SeasonLightVO> collect = seasons.stream().map(s -> new SeasonLightVO(s)).collect(Collectors.toList());
        collect.sort(Comparator.comparing(SeasonLightVO::getSeasonNumber));
        this.seasons = collect;
    }
}
