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
}
