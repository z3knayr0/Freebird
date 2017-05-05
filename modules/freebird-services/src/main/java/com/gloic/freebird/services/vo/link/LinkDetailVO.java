package com.gloic.freebird.services.vo.link;

import com.gloic.freebird.commons.enumerations.Codec;
import com.gloic.freebird.commons.enumerations.Language;
import com.gloic.freebird.commons.enumerations.Quality;
import com.gloic.freebird.persistence.model.Link;
import lombok.Data;

/**
 * Extends LinkLightVO and add all necessary information to display a link and its metadata
 * @author gloic
 */
@Data
public final class LinkDetailVO extends LinkLightVO {

    private Long id;
    private String fileName;
    private String parentUrl;
    private Long size;
    private Codec codec;
    private Language language;
    private Quality quality;

    public LinkDetailVO(Link link) {
        super(link);
        this.id = link.getId();
        this.fileName = link.getFileName();
        this.parentUrl = link.getParentUrl();
        this.size = link.getSize();
        this.codec = link.getCodec();
        this.language = link.getLanguage();
        this.quality = link.getQuality();

    }
}
