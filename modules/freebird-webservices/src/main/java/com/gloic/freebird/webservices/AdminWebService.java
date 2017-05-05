package com.gloic.freebird.webservices;


import com.gloic.freebird.persistence.model.Site;
import com.gloic.freebird.services.service.SiteService;
import com.gloic.freebird.services.vo.admin.site.SiteVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author gloic
 */
@RestController
@RequestMapping(value = "/api/admin", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@PreAuthorize("hasRole('ROLE_ADMIN')")
@SuppressWarnings("unused")
public class AdminWebService {

    private final SiteService siteService;

    @Autowired
    public AdminWebService(SiteService siteService) {
        this.siteService = siteService;
    }

    @RequestMapping(value = "/sites/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<SiteVO> getAllSites() {
        return siteService.findAll();
    }

    @RequestMapping(value = "/sites/", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Site addSite(@RequestBody Site siteToAdd) {
        return siteService.addSite(siteToAdd);
    }

    @RequestMapping(value = "/sites/scan/{id}/{redoUnknowns}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void forceSiteScan(@PathVariable("id") Long id, @PathVariable("redoUnknowns") boolean redoUnknowns) {
        siteService.scan(id, redoUnknowns);
    }

    @RequestMapping(value = "/sites/scan/all", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void forceSiteScan(@PathParam("redoUnknowns") boolean redoUnknowns) {
        siteService.scanAll(redoUnknowns);
    }
}
