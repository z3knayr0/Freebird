package com.gloic.freebird.services.vo.movie;

import com.gloic.freebird.persistence.model.Movie;
import com.gloic.freebird.services.vo.link.LinkLightVO;
import com.gloic.freebird.services.vo.link.LinkVOMapper;
import lombok.Data;

import java.util.List;

/**
 * MovieLightVO contains minimal information to be displayed in a grid or a list
 * @author gloic
 */
@Data
public class MovieLightVO {
    protected Long id;
    protected String title;
    protected String posterPath;
    protected List<? extends LinkLightVO> links;

    public MovieLightVO(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.posterPath = movie.getPosterPath();
        this.links = LinkVOMapper.toLinkLightVO(movie.getLinks());
    }
}
