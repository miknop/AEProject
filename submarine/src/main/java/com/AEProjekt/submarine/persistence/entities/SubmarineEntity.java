package com.AEProjekt.submarine.persistence.entities;

/**
 * Created by backes_tor on 06.06.2018.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmarineEntity {

    @GeneratedValue
    @Id
    private Long id;
}
