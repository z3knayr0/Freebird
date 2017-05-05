package com.gloic.freebird.webservices;

import com.gloic.freebird.persistence.model.UnknownMedia;
import com.gloic.freebird.services.service.MediaIdentificationService;
import com.gloic.freebird.services.vo.request.EpisodeIdentificationRequest;
import com.gloic.freebird.services.vo.request.MovieIdentificationRequest;
import com.gloic.freebird.services.vo.request.SeasonIdentificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gloic
 */
@RestController
@RequestMapping(value = "/api/identify", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@SuppressWarnings("unused")
public class MediaIdentificationWebService {

    private final MediaIdentificationService mediaIdentificationService;

    @Autowired
    public MediaIdentificationWebService(MediaIdentificationService mediaIdentificationService) {
        this.mediaIdentificationService = mediaIdentificationService;
    }


    @RequestMapping(path = "/p={page}", method = RequestMethod.GET)
    @ResponseBody
    public List<UnknownMedia> findAllUnknown(@PathVariable("page") int page) {
        return mediaIdentificationService.findAllUnknown(page);
    }

    @RequestMapping(path = "/movie", method = RequestMethod.POST)
    @ResponseBody
    public boolean identifyMovie(@RequestBody MovieIdentificationRequest movieIdentificationRequest) {
        return mediaIdentificationService.identifyMovie(movieIdentificationRequest);
    }

    @RequestMapping(path = "/episode", method = RequestMethod.POST)
    @ResponseBody
    public boolean identifyEpisode(@RequestBody EpisodeIdentificationRequest episodeIdentificationRequest) {
        return mediaIdentificationService.identifyEpisode(episodeIdentificationRequest);
    }

    @RequestMapping(path = "/season", method = RequestMethod.POST)
    @ResponseBody
    public boolean identifySeason(@RequestBody SeasonIdentificationRequest seasonIdentificationRequest) {
        return mediaIdentificationService.identifySeason(seasonIdentificationRequest);
    }

    @RequestMapping(path = "/rescan", method = RequestMethod.POST)
    @ResponseBody
    public void rescan(@RequestBody UnknownMedia media) {
        mediaIdentificationService.rescan(media);
    }

    @RequestMapping(value = "/wrongMovieIdentification", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void wrongMovieIdentification(@RequestParam("movieId") Long movieId, @RequestParam("linkId") Long linkId) {
        mediaIdentificationService.wrongMovieIdentification(movieId, linkId);
    }

    @RequestMapping(value = "/wrongEpisodeIdentification", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void wrongEpisodeIdentification(@RequestParam("episodeId") Long episodeId, @RequestParam("linkId") Long linkId) {
        mediaIdentificationService.wrongEpisodeIdentification(episodeId, linkId);
    }

    @RequestMapping(value = "/ignore/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void ignoreUnknown(@RequestParam("id") Long id) {
        mediaIdentificationService.ignoreMedia(id);
    }

    @RequestMapping(value = "/ignoreFolder/{mediaId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void ignoreFolder(@PathVariable("mediaId") Long id) {
        mediaIdentificationService.ignoreFolder(id);
    }
}
