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
@Data
//@AllArgsConstructor
@NoArgsConstructor
// renamed from UBoat to Submarine (Michel; 5/7/2018)
public class Submarine{
    private int xPosition;
    private int yPosition;

    public Submarine(Point p)
    {
        this.xPosition = p.getX();
        this.yPosition = p.getY();
    }


    public String toString()
    {
        return "(" + Integer.toString(xPosition) + "/" + Integer.toString(yPosition) + ")";
    }
    public Point getPoint()
    {
        return new Point(this.xPosition, this.yPosition);
    }
    public Submarine(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }
    
}
