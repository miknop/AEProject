package com.AEProjekt.submarine;

public class InputLevel4 implements iLInput{
    private int userNumeratorInput; //Zaehler
    private int userDenominatorInput; //Nenner
    private int userYInput;

    //Konstruktor

    public InputLevel4(int userNumeratorInput, int userDenominatorInput, int userYInput) {
        this.userNumeratorInput = userNumeratorInput;
        this.userDenominatorInput = userDenominatorInput;
        this.userYInput = userYInput;
    }

    //Getter und Setter
    public int getUserNumeratorInput() {
        return userNumeratorInput;
    }

    public void setUserNumeratorInput(int userNumeratorInput) {
        this.userNumeratorInput = userNumeratorInput;
    }

    public int getUserDenominatorInput() {
        return userDenominatorInput;
    }

    public void setUserDenominatorInput(int userDenominatorInput) {
        this.userDenominatorInput = userDenominatorInput;
    }

    public int getUserYInput() {
        return userYInput;
    }

    public void setUserYInput(int userYInput) {
        this.userYInput = userYInput;
    }

    //Weitere Methoden

    //Es reicht hier eigentlich schon aus zu pruefen ob der y-achsen abschnit von x = 0 in der Map liegt
    public boolean isInputValid()
    {
        if(userYInput>= -12 && userYInput <= 12)
        {
            if(userDenominatorInput != 0)
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
