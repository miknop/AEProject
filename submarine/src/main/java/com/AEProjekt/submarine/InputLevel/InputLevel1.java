package com.AEProjekt.submarine.InputLevel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputLevel1 implements iLInput
{
    private double p1Y;
    private double p1X;
    private double p2Y;
    private double p2X;

    //Weitere Methoden
    /**
     *Diese Methode prueft ob die Punkte im Spielfeld liegen und das es fuer kein x zwei verschiedene f(x) gibt
     */
    public boolean isInputValid()
    {

        //Punkte muessen im Spielfeld liegen
        if((p1Y>= -12 && p1Y <= 12)&&
                (p1X >= -12 && p1X <= 12)&&
                (p2Y >= -12 && p2Y <= 12)&&
                (p2X >= -12 && p2X <= 12))
        {
            //Diese Bedingung muss gelten, damit die Punkte eine fkt aufspannen
            if(p1X != p2X)
            {
                return true;
            }
            else
            {
                return false;
            }

        }
        else
        {
           return false;
        }

    }
}