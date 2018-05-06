package com.AEProjekt.submarine.equations;

import java.util.ArrayList;
import java.util.Random;

public class EquationGenerator
{
    private static final int MAXVALUES = 6;

    private int submarineX;
    private int submarineY;
    private int ufoX;
    private int ufoY;
    private boolean visiblePlane;
    private boolean visilbeBoat;
    private iEquationType equation;

    public void generateEquation(int equationType)
    {
        if(equationType == 1)
        {
            generateLinearEquation();
        }
    }

    private void generateLinearEquation()
    {
        // Zähler der Steigung im Bereich von -12 bis 12 generieren, wobie 12 maximale Spielfeldgröße ist.
        int dividend = -MAXVALUES + new Random().nextInt(MAXVALUES *2 + 1);
        int divisor = new Random().nextInt(MAXVALUES)+1; // +1 um 0 auszuschließen und um auf 12 zu kommen
        int temp = dividend/divisor;
        if(temp < 0) temp*=-1;
        int b = (-MAXVALUES + temp) + new Random().nextInt(MAXVALUES *2 - temp); // erklärung folgt

        equation = new linearEquation(dividend, divisor, b);

        ArrayList<Integer> negativeGanzeX = new ArrayList<Integer>();
        ArrayList<Integer> positiveGanzeX = new ArrayList<Integer>();
        // Zufällige Punkte bestimmen
        for (int i = -12; i <= -1; i++)
        {
            double y = equation.calculateY(i);
            if (y % 1 == 0 && y <= 12 && y >= -12)
            {
                negativeGanzeX.add(i);
            }
        }

        for (int i = 1; i <= 12; i++)
        {
            double y = equation.calculateY(i);
            if (y % 1 == 0 && y <= 12 && y >= -12)
            {
                positiveGanzeX.add(i);
            }
        }

        setSubmarineX(negativeGanzeX.get(new Random().nextInt(negativeGanzeX.size())));
        setSubmarineY((int) equation.calculateY(getSubmarineX()));

        setUfoX(positiveGanzeX.get(new Random().nextInt(positiveGanzeX.size())));
        setUfoY((int) equation.calculateY(getUfoX()));

    }

    public int getSubmarineX()
    {
        return submarineX;
    }

    public void setSubmarineX(int submarineX)
    {
        this.submarineX = submarineX;
    }

    public int getSubmarineY()
    {
        return submarineY;
    }

    public void setSubmarineY(int submarineY)
    {
        this.submarineY = submarineY;
    }

    public int getUfoX()
    {
        return ufoX;
    }

    public void setUfoX(int ufoX)
    {
        this.ufoX = ufoX;
    }

    public int getUfoY()
    {
        return ufoY;
    }

    public void setUfoY(int ufoY)
    {
        this.ufoY = ufoY;
    }

    public boolean isVisiblePlane()
    {
        return visiblePlane;
    }

    public void setVisiblePlane(boolean visiblePlane)
    {
        this.visiblePlane = visiblePlane;
    }

    public boolean isVisilbeBoat()
    {
        return visilbeBoat;
    }

    public void setVisilbeBoat(boolean visilbeBoat)
    {
        this.visilbeBoat = visilbeBoat;
    }

    public iEquationType getEquation()
    {
        return equation;
    }

    public void setEquation(iEquationType equation)
    {
        this.equation = equation;
    }
}
