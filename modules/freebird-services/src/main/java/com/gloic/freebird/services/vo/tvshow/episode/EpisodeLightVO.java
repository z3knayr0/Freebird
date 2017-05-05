package com.gloic.freebird.services.vo.tvshow.episode;

import com.gloic.freebird.persistence.model.Episode;
import com.gloic.freebird.services.vo.link.LinkLightVO;
import com.gloic.freebird.services.vo.link.LinkVOMapper;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * EpisodeLightVO contains minimal information to be displayed in a grid or a list
 * @author gloic
 */
@Data
public class EpisodeLightVO implements Serializable {
    protected Long id;
    protected String url;
    protected Integer episodeNum;
    protected String title;
    protected String stillPath;
    protected List<? extends LinkLightVO> links;

    public EpisodeLightVO(Episode e) {
        this.id = e.getId();
        this.title = e.getTitle();
        this.episodeNum = e.getEpisodeNum();
        this.stillPath = e.getStillPath();
        this.links = LinkVOMapper.toLinkLightVO(e.getLinks());
    }
}
