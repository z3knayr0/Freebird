package com.gloic.freebird.services.vo.movie;

import com.gloic.freebird.persistence.model.Movie;
import com.gloic.freebird.services.vo.link.LinkVOMapper;
import lombok.Data;

/**
 * MovieDetailVO extends MovieLightVO and complete it with more data
 * @author gloic
 */
@Data
public final class MovieDetailVO extends MovieLightVO {

    private String overview;
    private String url;
    private String releaseDate;

    public MovieDetailVO(Movie movie) {
        super(movie);
        this.overview = movie.getOverview();
        this.releaseDate = movie.getReleaseDate();
        this.links = LinkVOMapper.toLinkDetailVO(movie.getLinks());
    }
}
