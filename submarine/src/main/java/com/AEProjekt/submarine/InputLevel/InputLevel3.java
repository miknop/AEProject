package com.AEProjekt.submarine.InputLevel;

public class InputLevel3 implements iLInput {
    private double pX;

    //Konstruktor
    public InputLevel3(double pX) {
        this.pX = pX;
    }

    //Getter und Setter
    public double getpX() {
        return pX;
    }

    public void setpX(double pX) {
        this.pX = pX;
    }

    //Weitere Methoden

    //prueft ob sich der Punkt auf dem Spielfeld befindet
    public boolean isInputValid()
    {
        if(pX>= -12 && pX <= 12)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public double getP1Y()
    {
        return 0;
    }

    @Override
    public void setP1Y(double p1Y)
    {

    }

    @Override
    public double getP1X()
    {
        return 0;
    }

    @Override
    public void setP1X(double p1X)
    {

    }

    @Override
    public double getP2Y()
    {
        return 0;
    }

    @Override
    public void setP2Y(double p2Y)
    {

    }

    @Override
    public double getP2X()
    {
        return 0;
    }

    @Override
    public void setP2X(double p2X)
    {

    }
}
