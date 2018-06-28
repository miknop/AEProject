/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AEProjekt.submarine.levelz;  //  created at 5/7/2018

import com.AEProjekt.submarine.equations.EquationGenerator;
import com.AEProjekt.submarine.equations.LinearEquation;
import com.AEProjekt.submarine.figures.Plane;
import com.AEProjekt.submarine.figures.Submarine;
import com.AEProjekt.submarine.figures.iFigure;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Michel
 */
@Data
@AllArgsConstructor
//@NoArgsConstructor
public class Level4 implements iLevel {
    private LevelBeatCounter levelbeatcounter;
    private LinearEquation linEq = null;
    private iFigure plane = null;
    private iFigure submarine = null;

    public Level4() {
        equipLevel();
    }
    /**
     * Siehe Level 1
     * @author Simon Freygang
     */
    public void equipLevel() {
        linEq = EquationGenerator.generateLinearEquation();
        plane = new Plane(EquationGenerator.generatePointAboveSea(linEq));
        submarine = new Submarine(EquationGenerator.generatePointBelowSea(linEq));
        levelbeatcounter = new LevelBeatCounter();
    }
    /**
     * Siehe Level 1
     * @author Simon Freygang
     */
    public void equipLevelNoRS() {
        linEq = EquationGenerator.generateLinearEquation();
        plane = new Plane(EquationGenerator.generatePointAboveSea(linEq));
        submarine = new Submarine(EquationGenerator.generatePointBelowSea(linEq));
    }
}
