package com.gloic.freebird.webservices;

import com.gloic.freebird.persistence.model.Genre;
import com.gloic.freebird.services.service.MovieService;
import com.gloic.freebird.services.vo.movie.MovieDetailVO;
import com.gloic.freebird.services.vo.movie.MovieLightVO;
import com.gloic.freebird.services.vo.request.FilterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gloic
 */
@RestController
@RequestMapping(value = "/api/movie", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@SuppressWarnings("unused")
public class MovieWebService {
    private final MovieService movieService;

    @Autowired
    public MovieWebService(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value = "/filter", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<MovieLightVO> getAllMovieFiltered(@RequestBody FilterRequest filterRequest) {

        return movieService.getFilteredMovies(filterRequest);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public MovieDetailVO getMovieById(@PathVariable("id") Long id) {
        return movieService.getMovieById(id);
    }

    @RequestMapping(value = "/genres", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Genre> getGenres() {
        return movieService.getGenres();
    }
}
