package com.AEProjekt.submarine.equations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Point
{
    @Digits(integer = 10, fraction = 0, message = "X Falsch")
    private int x;
    @Digits(integer = 10, fraction = 0, message = "Y Falsch")
    private int y;

    @Override
    public String toString()
    {
        return ( x + "/" + y );
    }
}
