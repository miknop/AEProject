/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AEProjekt.submarine.levelz;  // created at 5/7/2018

/**
 * Interface für die Levels, welches nur festlegt, dass 5 von den letzten 7 Versuchen geschafft sein müssen
 * @author Michel
 * @since 20.05.
 */
public interface iLevel {
    final int maxLosses = 2;
    final int triesTotal = 7;
    
    public void method();
}
