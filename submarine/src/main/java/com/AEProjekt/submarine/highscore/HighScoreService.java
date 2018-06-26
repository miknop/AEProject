package com.AEProjekt.submarine.highscore;

import com.AEProjekt.submarine.levelz.iLevel;
import com.AEProjekt.submarine.persistence.services.UserService;
import com.AEProjekt.submarine.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author tbackes
 * created on 22.06.2018
 */
@Service
public class HighScoreService {

    private UserService userService;
    @Autowired
    public HighScoreService(UserService aUserService) {
        userService = aUserService;
    }

    public int generateLevelScoreForUser(String userName, iLevel level) {
        User user = userService.getUser(userName);
        int totalFails = level.getLevelbeatcounter().getTotalFailsCounter();
        int totalTries = level.getLevelbeatcounter().getTotalTriesCounter();
        return (1 - (totalFails / totalTries)) * 100;
    }

    public List<User> generateHighScoreForClass(String classNumber) {
        List<User> userList = userService.getUsersByClassNumber(classNumber);
        Collections.sort(userList);
        return userList;
    }
}

