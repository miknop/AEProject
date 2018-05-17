package com.AEProjekt.submarine.controllerz;

import com.AEProjekt.submarine.InputLevel.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputControl {

    private iLInput input;

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
        if(input instanceof InputLevel2)
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
