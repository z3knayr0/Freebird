package com.gloic.freebird.webservices;

import com.gloic.freebird.services.service.DashboardService;
import com.gloic.freebird.services.vo.movie.MovieLightVO;
import com.gloic.freebird.services.vo.tvshow.TvShowLightVO;
import com.gloic.freebird.services.vo.tvshow.episode.EpisodeDetailVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(value = "/api/dashboard", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@SuppressWarnings("unused")
public class DashboardWebService {

    private final DashboardService dashboardService;

    @Autowired
    public DashboardWebService(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @RequestMapping(value = "/search/tv/{term}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<TvShowLightVO> searchTvShow(@PathVariable("term") String term) {
        return dashboardService.searchTvShow(term);
    }

    @RequestMapping(value = "/search/movie/{term}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<MovieLightVO> searchMovie(@PathVariable("term") String term) {
        return dashboardService.searchMovie(term);
    }

    @RequestMapping(value = "/top/movies", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<MovieLightVO> findTopMovies() {
        return dashboardService.findTopMovies();
    }

    @RequestMapping(value = "/top/episodes", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<EpisodeDetailVO> findTopEpisodes() {
        return dashboardService.findTopEpisodes();
    }
}
