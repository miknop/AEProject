/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AEProjekt.submarine.levelz;  // created at 5/7/2018

import com.AEProjekt.submarine.equations.LinearEquation;

/**
 *
 * @author Michel
 */
public interface iLevel {
    final int maxLosses = 2;
    final int triesTotal = 7;


    //Methoden
    public LevelBeatCounter getLevelbeatcounter();
    public void setLevelbeatcounter(LevelBeatCounter levelbeatcounter);

    public LinearEquation getLinEq();
    public void  setLinEq(LinearEquation linearequation);
}
