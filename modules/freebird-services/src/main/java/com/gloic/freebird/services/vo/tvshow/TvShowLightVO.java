package com.gloic.freebird.services.vo.tvshow;

import com.gloic.freebird.persistence.model.TvShow;
import lombok.Data;

import java.io.Serializable;

/**
 * TvShowLightVO contains minimal information in order to be displayed in a list or a grid
 * @author gloic
 */
@Data
public class TvShowLightVO implements Serializable {
    protected Long id;
    protected String title;
    protected String posterPath;

    public TvShowLightVO(TvShow tvShow) {
        this.id = tvShow.getId();
        this.title = tvShow.getTitle();
        this.posterPath = tvShow.getPosterPath();
    }
}
