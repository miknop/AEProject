/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AEProjekt.submarine.levelz;  // created at 5/7/2018

import com.AEProjekt.submarine.equations.EquationGenerator;
import com.AEProjekt.submarine.equations.linearEquation;

/**
 *
 * @author Michel
 */
public class Level1 implements iLevel {
    private boolean plane;

    private linearEquation = EquationGenerator.generateLinearEquation();

    //constructor mit Generator
    public void setPlane(boolean plane) {
        this.plane = plane;
    }

    public boolean getPlane() {
        return this.plane;
    }

    generatePlane() {
        Plane=new plane;
        x=generator get x;
        y= generator getY;
    }


}
}
