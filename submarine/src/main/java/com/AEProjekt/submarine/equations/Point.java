package com.AEProjekt.submarine.equations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Point {
    @Digits(integer = 10, fraction = 0, message = "X Falsch")
    private int x;
    @Digits(integer = 10, fraction = 0, message = "Y Falsch")
    private int y;

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }


    /**
     * Generates a formatted String representing the point
     * @return a formatted String representing the point
     */
    @Override
    public String toString() {
        return (x + "/" + y);
    }

    /**
     * Compares the Point to another Point
     * @param o The Point this Point should be compared to
     * @return 0 if the point are the same, otherwise -1
     */
    public int compareTo(Point o) {
        if (o.getX() == this.x && o.getY() == this.y) {
            return 0;
        } else {
            return -1;
        }

    }
}
