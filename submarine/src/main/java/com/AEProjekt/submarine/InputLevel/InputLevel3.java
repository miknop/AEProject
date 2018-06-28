package com.AEProjekt.submarine.InputLevel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputLevel3 implements iLInput {
    private int pX;

    /**
     * Siehe die Erklärung aus InputLevel1
     * @author Simon Freygang
     */
    public boolean isInputValid() {
        if (pX >= -12 && pX <= 12) {
            return true;
        } else {
            return false;
        }
    }


}
