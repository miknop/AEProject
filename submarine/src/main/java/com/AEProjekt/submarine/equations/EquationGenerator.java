package com.AEProjekt.submarine.equations;



import java.util.ArrayList;
import java.util.Random;

/**
 * Created by miknop
 *
 */

public class EquationGenerator
{
    private static final int MAXVALUES = 6;

    public static iEquationType generateEquation(int equationType)
    {
        iEquationType equation = null;
        if(equationType == 1)
        {
             equation = generateLinearEquation();
        }
        return equation;
    }

    //TODO Michael
    public static LinearEquation generateLinearEquation(){
        // Zähler der Steigung im Bereich von -6 bis 6 generieren.
        //int dividend = -MAXVALUES + new Random().nextInt(MAXVALUES *2 + 1);
        int dividend = new Random().nextInt(MAXVALUES ) + 1;

        // bei 0 positiv, bei 1 negativ
        if(new Random().nextInt(2) == 0)
        {
            dividend *= -1;
        }

        int divisor = new Random().nextInt(MAXVALUES)+1; // +1 um 0 auszuschließen und um auf 12 zu kommen

        //Bruch kürzen  mit Hilfe des gcd (Größter gemeinsamer Teiler)
        int gcd = ExtraMath.calculateGcd(dividend, divisor);
        dividend /= gcd;
        divisor /= gcd;

        int temp = dividend/divisor;
        if(temp < 0) temp*=-1;
        int b;
        if(temp < 1)
        {
            b = (-MAXVALUES + divisor);
            if(MAXVALUES - divisor == 0)
            {
                b += new Random().nextInt(1); // erklärung folgt
            }
            else
            {
                b += new Random().nextInt((MAXVALUES - divisor) * 2); // erklärung folgt
            }
        }
        else
        {
            b = (-MAXVALUES + temp) + new Random().nextInt(MAXVALUES * 2 - temp);
        }
        return new LinearEquation(dividend, divisor, b);
    }

    public static Point generatePointBelowSea(iEquationType equation)
    {
        ArrayList<Integer> xBelow = new ArrayList<Integer>();

        // Zufällige Punkte bestimmen
        for (int i = -12; i <= 12; i++)
        {
            double y = equation.calculateY(i);
            if (y % 1 == 0 && y < 0 && y >= -12)
            {
                xBelow.add(i);
            }
        }

        int x1 = xBelow.get(new Random().nextInt(xBelow.size()));
        int y1 = (int) equation.calculateY(x1);

        return new Point(x1, y1);
    }

    public static Point generatePointAboveSea(iEquationType equation) {
        ArrayList<Integer> xAbove = new ArrayList<Integer>();

        // Zufällige Punkte bestimmen
        for (int i = -12; i <= 12; i++)
        {
            double y = equation.calculateY(i);
            if (y % 1 == 0 && y < 12 && y > 0)
            {
                xAbove.add(i);
            }
        }

        int x1 = xAbove.get(new Random().nextInt(xAbove.size()));
        int y1 = (int) equation.calculateY(x1);

        return new Point(x1, y1);
    }

    public static Point generatePointAtSealevel(iEquationType equation) {
        int x1 = (int) equation.calculateX(0);
        int y1 = 0;

        return new Point(x1, y1);
    }


    public static int generateUfoX() {
        int i  = 0;
        return i;
    }

    public static int generateUfoY() {
        int i  = 0;
        return i;
    }

    public static int generateSubX() {
        int i  = 0;
        return i;
    }

    public static int generateSubY() {
        int i  = 0;
        return i;
    }
}
