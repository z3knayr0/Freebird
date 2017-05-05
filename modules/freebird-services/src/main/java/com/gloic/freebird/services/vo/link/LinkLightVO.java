package com.gloic.freebird.services.vo.link;

import com.gloic.freebird.persistence.model.Link;
import lombok.Data;

/**
 * LinkLightVO contains minimal information
 * @author gloic
 */
@Data
public class LinkLightVO {

    protected String url;

    public LinkLightVO(Link link) {
        this.url = link.getUrl();
    }
}
