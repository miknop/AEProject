package com.AEProjekt.submarine.InputLevel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputLevel4 implements iLInput {
    private int userNumeratorInput; //Zaehler
    private int userDenominatorInput; //Nenner
    private int userYInput;

    /**
     * Siehe die Erklärung aus InputLevel1
     * @author Simon Freygang
     */
    public boolean isInputValid() {
        if (userYInput >= -12 && userYInput <= 12) {
            if (userDenominatorInput != 0) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    /*@Override
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

    }*/
}
