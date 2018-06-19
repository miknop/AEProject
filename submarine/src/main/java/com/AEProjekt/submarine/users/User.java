package com.AEProjekt.submarine.users;

import com.AEProjekt.submarine.levelz.Level1;
import com.AEProjekt.submarine.levelz.Level2;
import com.AEProjekt.submarine.levelz.Level3;
import com.AEProjekt.submarine.levelz.Level4;
import com.AEProjekt.submarine.levelz.iLevel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String username;
    private iLevel level = new Level1();

}
