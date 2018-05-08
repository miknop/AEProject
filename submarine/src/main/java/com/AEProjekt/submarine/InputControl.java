package com.AEProjekt.submarine;

public class InputControl {

    private iLInput input;

    //Konstruktor
    //Nothing

    //Getter und Setter
    //Nothing

    //Weitere Methoden
    private boolean isDrawnInputValid(iLInput input)
    {
        if(input instanceof InputLevel1)
        {
            if(input.isInputValid())
            {
                this.input = input;
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

    private boolean isEquationInputValid(iLInput input)
    {
        if(input instanceof InputLevel4)
        {
            if(input.isInputValid())
            {
                this.input = input;
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

    private boolean isBombDepthValid(iLInput input)
    {
        if(input instanceof InputLevel02)
        {
            if(input.isInputValid())
            {
                this.input = input;
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

    private boolean isBoatPosValid(iLInput input)
    {
        if(input instanceof InputLevel3)
        {
            if(input.isInputValid())
            {
                this.input = input;
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
