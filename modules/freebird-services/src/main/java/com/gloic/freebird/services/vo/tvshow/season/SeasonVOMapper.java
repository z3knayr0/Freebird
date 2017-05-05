package com.gloic.freebird.services.vo.tvshow.season;

import com.gloic.freebird.persistence.model.Season;

/**
 * Mapper from Season to SeasonVO
 * @author gloic
 */
public final class SeasonVOMapper {

    public static SeasonDetailVO toSeasonDetailVO(Season s) {
        return s != null ? new SeasonDetailVO(s) : null;
    }
}
