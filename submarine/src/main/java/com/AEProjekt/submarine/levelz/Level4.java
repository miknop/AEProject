/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AEProjekt.submarine.levelz;  //  created at 5/7/2018

import com.AEProjekt.submarine.equations.EquationGenerator;
import com.AEProjekt.submarine.equations.LinearEquation;
import com.AEProjekt.submarine.figures.Plane;
import com.AEProjekt.submarine.figures.iFigure;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Michel
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Level4 implements iLevel{
    private LevelBeatCounter levelbeatcounter;
    private LinearEquation linEq = null;
    private iFigure plane = null;
    
    public void equipLevel() {
        linEq = EquationGenerator.generateLinearEquation();
        plane = new Plane(EquationGenerator.generatePointAboveSea(linEq));
        levelbeatcounter = new LevelBeatCounter();
    }

    public void equipLevelNoRS()
    {
        linEq = EquationGenerator.generateLinearEquation();
        //submarine = new Submarine(EquationGenerator.generatePointBelowSea(linEq));
        plane = new Plane(EquationGenerator.generatePointAboveSea(linEq));
    }
}
