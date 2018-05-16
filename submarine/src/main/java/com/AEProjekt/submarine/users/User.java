package com.AEProjekt.submarine.users;

import com.AEProjekt.submarine.levelz.iLevel;
import lombok.Data;


@Data
public class User {
    private String username;
    private String password;
    private iLevel level;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public iLevel getLevel() {
        return level;
    }

    public void setLevel(iLevel level) {
        this.level = level;
    }
}
