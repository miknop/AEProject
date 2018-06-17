package com.AEProjekt.submarine.InputLevel;

/**
 *
 * @author:
 * @since:
 * @version:
 */
public class InputLevel2 implements iLInput {

    private double pFX;

    //Konstruktor
    public InputLevel2(double pFX)
    {
        this.pFX = pFX;
    }

    //Getter und Setter
    public double getPFX() {
        return pFX;
    }

    public void setPFX(double pFX) {
        this.pFX = pFX;
    }

    /**
     * Weitere Methoden
     *Diese Methode prueft ob die Punkte im Spielfeld liegen und das es fuer kein x zwei verschiedene f(x) gibt
     */
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
