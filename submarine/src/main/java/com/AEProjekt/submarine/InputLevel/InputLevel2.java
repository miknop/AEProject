package com.AEProjekt.submarine.InputLevel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputLevel2 implements iLInput {

    private int pFX;

    /**
     * Siehe die Erklärung aus InputLevel1
     * @author Simon Freygang
     */
    public boolean isInputValid() {
        if (pFX >= -12 && pFX <= 0) {
            return true;
        } else {
            return false;
        }
    }


}
