/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AEProjekt.submarine.levelz;  // created at 5/7/2018

import com.AEProjekt.submarine.equations.LinearEquation;
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
public class Level2 implements iLevel{
   private boolean satellite;
    private LinearEquation linEq = null;
    private LevelBeatCounter levelbeatcounter;
    
    public void method(){
        
    }
}
