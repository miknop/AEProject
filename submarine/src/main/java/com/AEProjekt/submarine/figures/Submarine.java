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

// renamed from UBoat to Submarine (Michel; 5/7/2018)
public class Submarine {
    private int xPosition;
    private int yPosition;
    
    private void generatePosition(){
        
    }

    public Submarine(int x, int y)
    {
        xPosition = x;
        yPosition = y;
    }

    public String toString()
    {
        return "(" + Integer.toString(xPosition) + "/" + Integer.toString(yPosition) + ")";
    }

    public int getxPosition()
    {
        return xPosition;
    }

    public void setxPosition(int xPosition)
    {
        this.xPosition = xPosition;
    }

    public int getyPosition()
    {
        return yPosition;
    }

    public void setyPosition(int yPosition)
    {
        this.yPosition = yPosition;
    }
}
