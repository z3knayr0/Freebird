package com.gloic.freebird.services.vo.movie;

import com.gloic.freebird.persistence.model.Movie;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper from Movie to MovieLightVO and MovieDetailVO
 * @author gloic
 */
public class MovieMapper {

    public static List<MovieLightVO> toMovieLightVO(List<Movie> movie) {
        return movie.stream().map(m -> new MovieLightVO(m)).collect(Collectors.toList());
    }

    public static MovieDetailVO toMovieDetailVO(Movie movie) {
        return new MovieDetailVO(movie);
    }

}
