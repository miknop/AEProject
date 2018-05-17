package com.AEProjekt.submarine.users;

import com.AEProjekt.submarine.levelz.iLevel;
import lombok.Data;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;
    private String password;
    private iLevel level;

}
