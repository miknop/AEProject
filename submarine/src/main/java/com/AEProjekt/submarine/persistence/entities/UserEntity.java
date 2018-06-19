package com.AEProjekt.submarine.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * Created by backes_tor on 14.06.2018.
 * Database Object, that is mapped to an existing Data Transfer Object (DTO), to keep Database- and live objects seperated.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    private String username;
    private int level;
}
