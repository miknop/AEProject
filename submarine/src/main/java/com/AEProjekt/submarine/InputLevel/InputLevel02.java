package com.AEProjekt.submarine.InputLevel;


public class InputLevel02 implements iLInput {

    private double pFX;

    //Konstruktor
    public InputLevel02(double pFX)
    {
        this.pFX = pFX;
    }

    public double getPFX() {
        return pFX;
    }

    public void setPFX(double pFX) {
        this.pFX = pFX;
    }

    //Weitere Methoden
    public boolean isInputValid()
    {
        if(pFX>= -12 && pFX <= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
