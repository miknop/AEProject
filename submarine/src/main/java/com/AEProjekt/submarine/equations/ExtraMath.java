package com.AEProjekt.submarine.equations;

public class ExtraMath {

    /**
     * Calculates the GCD of two numbers
     * @param a Number 1
     * @param b Number 2
     * @return The greates common denominator of the 2 numbers
     */
    public static int calculateGcd(int a, int b) {
        // Euklidischer Algorithmus
        if (b == 0) {
            return Math.abs(a);
        }
        return calculateGcd(b, a % b);
    }

}
