package com.AEProjekt.submarine.users;

import com.AEProjekt.submarine.levelz.iLevel;
import lombok.Getter;
import lombok.Setter;


public class User {
    @Getter @Setter private String username;
    @Getter @Setter private String password;
    @Getter @Setter private iLevel level;

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
