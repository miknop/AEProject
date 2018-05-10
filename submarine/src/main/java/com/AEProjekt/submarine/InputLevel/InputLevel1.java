package com.AEProjekt.submarine.InputLevel;

public class InputLevel1 implements iLInput
{
    private double p1Y;
    private double p1X;
    private double p2Y;
    private double p2X;

    //Konstruktor
    public InputLevel1(double p1Y, double p1X, double p2Y, double p2X) {
        this.p1Y = p1Y;
        this.p1X = p1X;
        this.p2Y = p2Y;
        this.p2X = p2X;
    }

    //Getter und Setter
    public double getP1Y() {
        return p1Y;
    }

    public void setP1Y(double p1Y) {
        this.p1Y = p1Y;
    }

    public double getP1X() {
        return p1X;
    }

    public void setP1X(double p1X) {
        this.p1X = p1X;
    }

    public double getP2Y() {
        return p2Y;
    }

    public void setP2Y(double p2Y) {
        this.p2Y = p2Y;
    }

    public double getP2X() {
        return p2X;
    }

    public void setP2X(double p2X) {
        this.p2X = p2X;
    }

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