package com.AEProjekt.submarine;

import com.AEProjekt.submarine.equations.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInputTest
{
    private Point punkt1;
    private Point punkt2;

    @Digits(integer = 10, fraction = 0, message = "Es muss eine gültige Zahl eingegeben werden")
    private int divident;

    @Digits(integer = 10, fraction = 0, message = "Es muss eine gültige Zahl eingegeben werden")
    private int divisor;

    @Digits(integer = 10, fraction = 0, message = "Es muss eine gültige Zahl eingegeben werden")
    private int b;

}
