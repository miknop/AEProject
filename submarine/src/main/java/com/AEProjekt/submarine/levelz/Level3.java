/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AEProjekt.submarine.levelz;  // created at 5/7/2018

import com.AEProjekt.submarine.equations.LinearEquation;
import com.AEProjekt.submarine.figures.Satellite;
import com.AEProjekt.submarine.figures.iFigure;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 *
 * @author Michel
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Level3 implements iLevel{
    private LevelBeatCounter levelbeatcounter;
    private LinearEquation linEq = null;
    private iFigure satellite = null;

    
    public void method(){
        
    }
}
