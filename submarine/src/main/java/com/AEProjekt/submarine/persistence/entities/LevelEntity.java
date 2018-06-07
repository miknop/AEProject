package com.AEProjekt.submarine.persistence.entities;

import com.AEProjekt.submarine.equations.LinearEquation;
import com.AEProjekt.submarine.figures.Plane;
import com.AEProjekt.submarine.figures.Satellite;
import com.AEProjekt.submarine.figures.Ship;
import com.AEProjekt.submarine.figures.Submarine;
import com.AEProjekt.submarine.levelz.LevelBeatCounter;
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
public class LevelEntity {

    @GeneratedValue
    @Id
    private Long id;

    private Plane plane;

    private Submarine sub;

    private Ship ship;

    private Satellite satellite;

    private LinearEquation equation;

    private LevelBeatCounter counter;
}
