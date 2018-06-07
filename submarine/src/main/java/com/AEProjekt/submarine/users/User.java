package com.AEProjekt.submarine.users;

import com.AEProjekt.submarine.levelz.Level1;
import com.AEProjekt.submarine.levelz.Level2;
import com.AEProjekt.submarine.levelz.iLevel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;
    private String password;
    private iLevel level = new Level1();
    /*
    private boolean level1Beaten = false;
    private boolean level2Beaten= false;
    private boolean level3Beaten= false;
    private boolean level4Beaten = false;
    */

    /*
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


    public boolean isLevel1Beaten() {
        return level1Beaten;
    }

    public void setLevel1Beaten(boolean level1Beaten) {
        this.level1Beaten = level1Beaten;
    }

    public boolean isLevel2Beaten() {
        return level2Beaten;
    }

    public void setLevel2Beaten(boolean level2Beaten) {
        this.level2Beaten = level2Beaten;
    }

    public boolean isLevel3Beaten() {
        return level3Beaten;
    }

    public void setLevel3Beaten(boolean level3Beaten) {
        this.level3Beaten = level3Beaten;
    }

    public boolean isLevel4Beaten() {
        return level4Beaten;
    }

    public void setLevel4Beaten(boolean level4Beaten) {
        this.level4Beaten = level4Beaten;
    }
    */
}
