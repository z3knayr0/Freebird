package com.gloic.freebird.services.vo.user;

import com.gloic.freebird.commons.enumerations.Authority;
import com.gloic.freebird.persistence.model.User;
import lombok.Data;

import java.util.Date;
import java.util.Set;

/**
 * UserVO is used in the administration panel
 * @author gloic
 */
@Data
public class UserVO {
    private Long id;
    private String username;
    private boolean enabled;
    private Date lastPasswordResetDate;
    private Set<Authority> authorities;

    public UserVO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.enabled = user.isEnabled();
        this.lastPasswordResetDate = user.getLastPasswordResetDate();
        this.authorities = user.getAuthorities();
    }
}
