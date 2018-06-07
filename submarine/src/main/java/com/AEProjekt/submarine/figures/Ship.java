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
//@NoArgsConstructor
public class Ship implements iFigure{
    private Point point;

    public Ship(Point p)
    {
        point = p;
    }

    public String toString()
    {
        return "(" + Integer.toString(point.getX()) + "/" + Integer.toString(point.getY()) + ")";}

}
