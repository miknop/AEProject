package com.AEProjekt.submarine.InputLevel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputLevel2 implements iLInput {

    private double pFX;

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
