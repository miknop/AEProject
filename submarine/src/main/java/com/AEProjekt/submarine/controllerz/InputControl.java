package com.AEProjekt.submarine.controllerz;

import com.AEProjekt.submarine.InputLevel.*;

/**
 * kurze Beschreibung, was die Klasse macht
 * @author (Created by)
 * @since (when created)
 * (@version)
 */
public class InputControl {

    private iLInput input;

    //Konstruktor
    //Nothing

    //Getter und Setter
    //Nothing

    //Weitere Methoden

    /**
     * kurze Beschreibung
     * @param input
     * @return
     */
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

    /**
     * kurze Beschreibung
     * @param input
     * @return
     */
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

    /**
     * kurze Beschreibung
     * @param input
     * @return
     */
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

    /**
     * kurze Beschreibung
     * @param input
     * @return
     */
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
