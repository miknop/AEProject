package com.AEProjekt.submarine.users;

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
    private iLevel level;
    private boolean level1Beaten = false;
    private boolean level2Beaten= false;
    private boolean level3Beaten= false;
    private boolean level4Beaten = false;

}
