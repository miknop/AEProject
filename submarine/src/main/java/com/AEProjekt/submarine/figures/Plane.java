/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AEProjekt.submarine.figures;  // created at 5/7/2018

/**
 *
 * @author Michel
 */
public class Plane {
    private int xPosition;
    private int yPosition;
    
    private void generatePosition(){
        
    }
    public Plane(int x, int y)
    {
        xPosition = x;
        yPosition = y;
    }

    public String toString()
    {
        return "(" + Integer.toString(xPosition) + "/" + Integer.toString(yPosition) + ")";
    }
}
