package com.AEProjekt.submarine.persistence.entities;

import com.AEProjekt.submarine.levelz.iLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by backes_tor on 07.06.2018.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @GeneratedValue
    @Id
    private Long id;

    private String username;
    private String password;
    private iLevel level;
}
