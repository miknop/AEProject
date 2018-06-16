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
 * renamed from UBoat to Submarine (Michel; 5/7/2018)
 */
@Data
//@AllArgsConstructor
//@NoArgsConstructor

public class Submarine implements iFigure{
    private Point point;

    public Submarine(Point p)
    {
        point = p;
    }

    public int getX()
    {
        return point.getX();
    }

    public int getY()
    {
        return point.getY();
    }

    public String toString()
    {
        return "(" + Integer.toString(point.getX()) + "/" + Integer.toString(point.getY()) + ")";
    }

}
