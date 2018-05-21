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


}
