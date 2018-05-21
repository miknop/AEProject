package com.AEProjekt.submarine.figures;

public class FigureGenerator {

    public static Plane generatePlane(int x, int y) {
        return new Plane(x,y);
    }

    public static Satellite generateSatellite(int x, int y)  {
        return new Satellite(x,y);
    }

    public static Ship generateShip(int x, int y)  {
        return new Ship(x,y);
    }

    public static Submarine generateSubmarine(int x, int y)  {
        return new Submarine(x,y);
    }


}
