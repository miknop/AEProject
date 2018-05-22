package com.AEProjekt.submarine.equations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class LinearEquation implements iEquationType, Comparable<LinearEquation>
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

    @Override
    public int compareTo(LinearEquation o) {
        if(o.getDividend() == this.dividend && o.getDivisor() == this.divisor && o.getB() == this.b)
        {
            return 0;
        }
        else
        {
            return -1;
        }

    }


    //Auch hier funktoniet Lombok noch nicht, wird aber alles geloescht

    public int getDividend() {
        return dividend;
    }

    public void setDividend(int dividend) {
        this.dividend = dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public LinearEquation(int dividend, int divisor, int b) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.b = b;
    }
    public LinearEquation() {
    }
}
