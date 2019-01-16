package org.newdawn.slick.tests.spacegame;

import org.newdawn.slick.geom.Polygon;

public class PolygonTest {
    public static void main(String[] args) {
        Polygon ship = new Polygon();
        ship.addPoint(100,100);
        ship.addPoint(110,50);
        ship.addPoint(120,100);
        ship.addPoint(110,90);

        for (int i = 0; i < ship.getPoints().length; i+=2) {
            System.out.println(ship.getPoints()[i]+" "+ ship.getPoints()[i+1]);
        }
    }
}
