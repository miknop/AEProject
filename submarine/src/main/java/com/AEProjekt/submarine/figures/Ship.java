/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AEProjekt.submarine.figures;  // created at 5/7/2018

import com.AEProjekt.submarine.equations.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Michel
 */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Ship {
    private int xPosition;
    private int yPosition;

    public Ship(Point p)
    {
        this.xPosition = p.getX();
        this.yPosition = p.getY();
    }

    public String toString()
    {
        return "(" + Integer.toString(xPosition) + "/" + Integer.toString(yPosition) + ")";
    }

    public Ship(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }
}
