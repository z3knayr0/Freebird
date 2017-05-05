package com.gloic.freebird.services.vo.link;

import com.gloic.freebird.persistence.model.Link;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper from Link to LinkVO
 * @author gloic
 */
public class LinkVOMapper {

    public static LinkLightVO toLinkLightVO(Link link) {
        return new LinkLightVO(link);
    }

    public static List<LinkLightVO> toLinkLightVO(List<Link> links) {
        return links.stream().map(e -> toLinkLightVO(e)).collect(Collectors.toList());
    }

    public static LinkDetailVO toLinkDetailVO(Link link) {
        return new LinkDetailVO(link);
    }

    public static List<LinkDetailVO> toLinkDetailVO(List<Link> links) {
        return links.stream().map(e -> toLinkDetailVO(e)).collect(Collectors.toList());
    }

}
