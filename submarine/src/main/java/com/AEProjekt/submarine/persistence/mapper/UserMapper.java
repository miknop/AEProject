package com.AEProjekt.submarine.persistence.mapper;

import com.AEProjekt.submarine.levelz.*;
import com.AEProjekt.submarine.persistence.entities.UserEntity;
import com.AEProjekt.submarine.users.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by backes_tor on 14.06.2018.
 * maps the User Class to the Entity and vice-versa.
 */
public class UserMapper {

    /**
     *
     * @param entity
     * @return User
     * Maps Database object to live Object.
     */
    public static User fromEntityToObject(UserEntity entity) {
        User user = new User();
        user.setUsername(entity.getUsername());
        user.setClassNumber(entity.getClassNumber());
        iLevel level = mapLevelFromEntity(entity) ;
        LevelBeatCounter counter = level.getLevelbeatcounter();
        counter.setBeatList(entity.getBeatList());
        user.setScoreLevel1(entity.getScoreLevel1());
        user.setScoreLevel2(entity.getScoreLevel2());
        user.setScoreLevel3(entity.getScoreLevel3());
        user.setScoreLevel4(entity.getScoreLevel4());
        level.setLevelbeatcounter(counter);
        user.setLevel(level);

        return user;
    }

    /**
     *
     * @param user
     * @return User Entity
     * maps live objects to Database objects.
     */

    public static UserEntity fromObjectToEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setUsername(user.getUsername());
        entity.setClassNumber(user.getClassNumber());
        iLevel level = user.getLevel();
        int levelInt = mapLevelInt(user);
        entity.setLevel(levelInt);
        entity.setBeatList(level.getLevelbeatcounter().getBeatList());
        entity.setScoreLevel1(user.getScoreLevel1());
        entity.setScoreLevel2(user.getScoreLevel2());
        entity.setScoreLevel3(user.getScoreLevel3());
        entity.setScoreLevel4(user.getScoreLevel4());
        return entity;
    }

    /**
     *
     * @param list of User Entities
     * @return List of Users
     * works in between Database and live objects.
     */
    public static List<User>fromEntitiesToObjects(List<UserEntity> list) {
        List<User> userList = new ArrayList<>();
        for (UserEntity entity: list) {
            userList.add(UserMapper.fromEntityToObject(entity));
        }
        return userList;
    }

    /**
     *
     * @param entity
     * @return iLevel level class. is needed to arm the user with a real level instead of Database Integer.
     * See mapLevelInt function ffi.
     */
    private static iLevel mapLevelFromEntity (UserEntity entity) {
        iLevel level;
        int levelInt = entity.getLevel();
        switch (levelInt) {
            case 1:
                level = new Level1();
                break;
            case 2:
                level = new Level2();
                break;
            case 3:
                level = new Level3();
                break;
            case 4:
                level = new Level4();
                break;
            default:
                level = null;
                break;
        }
        return level;
    }

    /**
     *
     * @param user
     * @return returns an Integer value, to simplify Database design.
     * Instead of unnecessarily persisting the Level, it is saved as an Integer value and later on mapped back
     * through mapLevelFromEntity function
     */
    public static int mapLevelInt (User user) {
        iLevel level = user.getLevel();
        int levelInt = 0;
        if (level instanceof Level1) {
            levelInt = 1;
        } else if (level instanceof Level2) {
            levelInt = 2;
        } else if (level instanceof Level3) {
            levelInt = 3;
        } else if (level instanceof Level4) {
            levelInt = 4;
        }
        return levelInt;
    }

}
