package com.AEProjekt.submarine.equations;

public class ExtraMath {

    public static int calculateGcd(int a, int b) {
        // Euklidischer Algorithmus
        if (b == 0) {
            return Math.abs(a);
        }
        return calculateGcd(b, a % b);
    }

}
