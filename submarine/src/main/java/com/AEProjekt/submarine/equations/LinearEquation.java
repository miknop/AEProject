package com.AEProjekt.submarine.equations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinearEquation implements iEquationType, Comparable<LinearEquation> {
    private int dividend; // Zähler
    private int divisor;
    private int b; // Schnittpunkt mit der Y-Achse


    /**
     * Calculates the x value that corresponds to the given y value
     * @param y The value that the x value should be calculated for
     * @return The x value to the given y value
     */
    @Override
    public double calculateX(int y) {
        return (y - b) / ((double) dividend / divisor);
    }

    /**
     * Calculates the y value that corresponds to the given y value
     * @param x The value that the y value should be calculated for
     * @return The y value to the given x value
     */
    @Override
    public double calculateY(int x) {
        return ((double) dividend / divisor) * x + b;
    }

    /**
     * Formated String of the equation
     * @return Formated String of the equation
     */
    @Override
    public String toString() {
        return "f(x)= " + Integer.toString(dividend) + "/" + Integer.toString(divisor) + "x + " + Integer.toString(b);
    }

    /**
     * Compares this equation to another
     * @param o The equation that should be compared
     * @return 0 when the equations are the same otherwise -1
     */
    @Override
    public int compareTo(LinearEquation o) {
        if (o.getDividend() / o.getDivisor() == this.dividend / this.divisor && o.getB() == this.b) {
            return 0;
        } else {
            return -1;
        }

    }
}
