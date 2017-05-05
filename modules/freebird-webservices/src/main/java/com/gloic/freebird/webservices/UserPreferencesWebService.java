package com.gloic.freebird.webservices;


import com.gloic.freebird.persistence.model.UserPreferences;
import com.gloic.freebird.services.service.UserPreferencesService;
import com.gloic.freebird.services.vo.request.ChangePasswordRequest;
import com.gloic.freebird.services.vo.user.UserPreferencesVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author gloic
 */
@RestController
@RequestMapping(value = "/api/preferences", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@SuppressWarnings("unused")
public class UserPreferencesWebService {

    private final UserPreferencesService userPreferencesService;

    @Autowired
    public UserPreferencesWebService(UserPreferencesService userPreferencesService) {
        this.userPreferencesService = userPreferencesService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public UserPreferencesVO getUserPreferences() throws IOException {
        return userPreferencesService.getUserPreferences();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public UserPreferencesVO save(@RequestBody UserPreferences userPreferences) throws IOException {
        return this.userPreferencesService.update(userPreferences);
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public boolean changePassword(@RequestBody ChangePasswordRequest changePasswordRequest) throws IOException {
        return this.userPreferencesService.changePassword(changePasswordRequest);
    }
}
