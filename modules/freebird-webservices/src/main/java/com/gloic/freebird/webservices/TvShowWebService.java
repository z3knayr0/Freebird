package com.gloic.freebird.webservices;

import com.gloic.freebird.persistence.model.Genre;
import com.gloic.freebird.services.service.TvShowService;
import com.gloic.freebird.services.vo.request.FilterRequest;
import com.gloic.freebird.services.vo.tvshow.TvShowDetailVO;
import com.gloic.freebird.services.vo.tvshow.TvShowLightVO;
import com.gloic.freebird.services.vo.tvshow.episode.EpisodeDetailVO;
import com.gloic.freebird.services.vo.tvshow.season.SeasonDetailVO;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping(value = "/api/tvshow", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@SuppressWarnings("unused")
public class TvShowWebService {

    private final TvShowService tvShowService;

    public TvShowWebService(TvShowService tvShowService) {
        this.tvShowService = tvShowService;
    }

    @RequestMapping(value = "/filter", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<TvShowLightVO> getAllTvShowsFiltered(@RequestBody FilterRequest filterRequest) {
        return tvShowService.getFilteredTvShows(filterRequest);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public TvShowDetailVO getDetailById(@PathVariable("id") Long id) {
        return tvShowService.getDetailById(id);
    }

    @RequestMapping(value = "/season/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public SeasonDetailVO getSeasonDetail(@PathVariable("id") Long id) {
        return tvShowService.getSeasonDetail(id);
    }

    @RequestMapping(value = "/episode/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public EpisodeDetailVO getEpisodeDetail(@PathVariable("id") Long id) {
        return tvShowService.getEpisodeDetail(id);
    }

    @RequestMapping(value = "/genres", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Genre> getGenres() {
        return tvShowService.getGenres();
    }
}
