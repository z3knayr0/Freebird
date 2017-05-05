package com.gloic.freebird.services.vo.tvshow;

import com.gloic.freebird.persistence.model.Season;
import com.gloic.freebird.persistence.model.TvShow;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper from TvShow to TvShowLight and TvShowDetail
 * @author gloic
 */
public final class TvShowVOMapper {

    public static List<TvShowLightVO> toTvShowLightVO(List<TvShow> tvShows) {
        return tvShows.stream().map(t -> new TvShowLightVO(t)).collect(Collectors.toList());
    }

    public static TvShowDetailVO toTvShowDetailVO(TvShow tvShow, List<Season> seasons) {
        return new TvShowDetailVO(tvShow, seasons);
    }
}
