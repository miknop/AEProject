package com.AEProjekt.submarine.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by backes_tor on 06.06.2018.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SatelliteEntity {

    @GeneratedValue
    @Id
    private Long id;
}


