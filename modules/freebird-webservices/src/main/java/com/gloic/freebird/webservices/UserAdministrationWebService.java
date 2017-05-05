package com.gloic.freebird.webservices;

import com.gloic.freebird.commons.enumerations.Authority;
import com.gloic.freebird.persistence.model.User;
import com.gloic.freebird.services.service.UserAdministrationService;
import com.gloic.freebird.services.vo.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gloic
 */
@RestController
@RequestMapping(value = "/api/admin/users", produces = MediaType.APPLICATION_JSON_VALUE)
@SuppressWarnings("unused")
public class UserAdministrationWebService {

    private final UserAdministrationService userAdministrationService;

    @Autowired
    public UserAdministrationWebService(UserAdministrationService userAdministrationService) {
        this.userAdministrationService = userAdministrationService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserVO> findAllUser() {
        return userAdministrationService.getAllUsers();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public UserVO autoCreateNewUser(@RequestBody User user) {
        return userAdministrationService.createUser(user.getUsername(), user.getPassword(), Authority.ROLE_USER);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/delete", method = RequestMethod.PUT)
    public boolean deleteUser(@RequestParam("userId") Long id) {
        return userAdministrationService.deleteUser(id);
    }

}
