package com.AEProjekt.submarine.InputLevel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputLevel2 implements iLInput {

    private int pFX;

    //Weitere Methoden
        public boolean isInputValid() {
            return (pFX >= -12 && pFX <= 0);
        }


}
