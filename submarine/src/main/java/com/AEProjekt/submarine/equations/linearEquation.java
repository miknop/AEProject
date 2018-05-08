package com.AEProjekt.submarine.equations;

public class linearEquation implements iEquationType
{
    private int dividend; // Zähler
    private int divisor;
    private int b; // Schnittpunkt mit der Y-Achse

    public linearEquation(int dividend, int divisor, int b)
    {
        this.dividend = dividend;
        this.divisor = divisor;
        this.b = b;
    }

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

    public int getDividend()
    {
        return dividend;
    }

    public void setDividend(int dividend)
    {
        this.dividend = dividend;
    }

    public int getDivisor()
    {
        return divisor;
    }

    public void setDivisor(int divisor)
    {
        this.divisor = divisor;
    }

    public int getB()
    {
        return b;
    }

    public void setB(int b)
    {
        this.b = b;
    }
}
