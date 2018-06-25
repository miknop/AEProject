package com.AEProjekt.submarine.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;

/**
 * Created by backes_tor on 14.06.2018.
 * Database Object, that is mapped to an existing Data Transfer Object (DTO), to keep Database- and live objects seperated.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private int level;
    private ArrayList<Boolean> beatList;
    private int scoreLevel1;
    private int scoreLevel2;
    private int scoreLevel3;
    private int scoreLevel4;
}
