package com.gloic.freebird.services.vo.tvshow.episode;

import com.gloic.freebird.persistence.model.Episode;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper from Episode to EpisodeLight and EpisodeDetail
 * @author gloic
 */
public final class EpisodeVOMapper {

    public static EpisodeLightVO toEpisodeLightVO(Episode episode) {
        return new EpisodeLightVO(episode);
    }

    public static List<EpisodeLightVO> toEpisodeLightVO(List<Episode> episodes) {
        return episodes.stream().map(e -> toEpisodeLightVO(e)).collect(Collectors.toList());
    }

    public static List<EpisodeDetailVO> toEpisodDetailVO(List<Episode> episodes) {
        return episodes.stream().map(e -> toEpisodDetailVO(e)).collect(Collectors.toList());
    }

    public static EpisodeDetailVO toEpisodDetailVO(Episode e) {
        return new EpisodeDetailVO(e);
    }
}
