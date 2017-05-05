package com.gloic.freebird.persistence.repository;

import com.gloic.freebird.commons.enumerations.MediaCategory;
import com.gloic.freebird.persistence.model.Site;
import com.gloic.freebird.persistence.model.UnknownMedia;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author gloic
 */
public interface UnknownMediaRepository extends JpaRepository<UnknownMedia, Long> {

    List<UnknownMedia> findAllByLinkCategoryOrderByLinkFileNameAsc(MediaCategory mediaCategory, Pageable pageable);

    @Transactional
    void deleteByLinkParentUrl(String parentUrl);

    List<UnknownMedia> findDistinctByLinkSiteAndLinkParentUrl(Site site,  String parentUrl);
}