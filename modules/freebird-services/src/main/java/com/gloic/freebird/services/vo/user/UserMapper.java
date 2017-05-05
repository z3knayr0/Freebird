package com.gloic.freebird.services.vo.user;

import com.gloic.freebird.persistence.model.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper from User to UserVO
 * @author gloic
 */
public class UserMapper {

    public static UserVO toUserVO(User user) {
        return new UserVO(user);
    }

    public static List<UserVO> toUserVO(List<User> users) {
        return users.stream().map(u -> toUserVO(u)).collect(Collectors.toList());
    }
}
