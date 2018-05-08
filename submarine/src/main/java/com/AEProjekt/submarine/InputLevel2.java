package com.AEProjekt.submarine;

public class InputLevel2 implements iLInput{

    private double pFX;

    //Konstruktor
    public InputLevel2(double pFX)
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
            if(pFX>= -12 && pFX <= 12)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
}
