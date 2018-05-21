package com.AEProjekt.submarine.equations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinearEquation implements iEquationType
{
    private int dividend; // Zähler
    private int divisor;
    private int b; // Schnittpunkt mit der Y-Achse


    @Override
    public double calculateX(int y)
    {
        return (y - b) / ((double)dividend/divisor);
    }

    @Override
    public double calculateY(int x)
    {
        return ((double)dividend/divisor) * x + b;
    }

    @Override
    public String toString()
    {
        return "f(x)= " + Integer.toString(dividend) + "/" + Integer.toString(divisor) + "x + " + Integer.toString(b);
    }

}
