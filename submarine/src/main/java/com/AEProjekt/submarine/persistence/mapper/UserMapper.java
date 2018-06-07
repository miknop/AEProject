package com.AEProjekt.submarine.persistence.mapper;

import com.AEProjekt.submarine.persistence.entities.UserEntity;
import com.AEProjekt.submarine.users.User;

/**
 * Created by backes_tor on 07.06.2018.
 */
public class UserMapper {

    public static User userEntityToUser(UserEntity entity) {
        User user  =  new User();
        user.setUsername(entity.getUsername());
        user.setLevel(entity.getLevel());
        return user;
    }

    public static UserEntity userToEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setLevel(user.getLevel());
        entity.setUsername(user.getUsername());
        return entity;
    }
}
