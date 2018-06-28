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

    //Weitere Methoden

    //Es reicht hier eigentlich schon aus zu pruefen ob der y-achsen abschnit von x = 0 in der Map liegt
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
}
