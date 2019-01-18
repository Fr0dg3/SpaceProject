package de.fab.SpaceGame.gameAssets;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Transform;

public class SpaceShip {

    private Polygon ship;
    private Point shipTop;
    private float currentOffsetX = 0;
    private float currentOffsetY = 0;
    private boolean canMove = true;
    private final static float SPEEDLIMIT = 10;


    public SpaceShip(Point startPoint){
        //Startpoint (e.g. 100,100)
        Polygon ship = new Polygon();
        ship.addPoint(startPoint.getX(),startPoint.getY());
        ship.addPoint(startPoint.getX() + 10,startPoint.getY() - 50);
        ship.addPoint(startPoint.getX() + 20,startPoint.getY());
        ship.addPoint(startPoint.getX() + 10,startPoint.getY() - 10);

        this.ship = ship;
        this.shipTop = new Point(ship.getPoints()[2],ship.getPoints()[3]);
    }

    public void collide(){
        currentOffsetY = 0;
        currentOffsetX = 0;
        //canMove = false;


    }

    public void update(GameContainer container, int delta) throws SlickException {
        shipTop.setX(ship.getPoints()[2]);
        shipTop.setY(ship.getPoints()[3]);
        if (container.getInput().isKeyDown(Input.KEY_UP) && canMove) {
            float xCenter = ship.getCenterX();
            float yCenter = ship.getCenterY();
            float xTop = shipTop.getX();
            float yTop = shipTop.getY();
            currentOffsetX = currentOffsetX + (xTop-xCenter)/120;
            if (currentOffsetX > SPEEDLIMIT) {
                currentOffsetX = SPEEDLIMIT;
            } else if (currentOffsetX < -SPEEDLIMIT) {
                currentOffsetX = -SPEEDLIMIT;
            }
            currentOffsetY = currentOffsetY + (yTop-yCenter)/120;
            if (currentOffsetY > SPEEDLIMIT) {
                currentOffsetY = SPEEDLIMIT;
            } else if (currentOffsetY < -SPEEDLIMIT) {
                currentOffsetY = -SPEEDLIMIT;
            }

            /*ship = (Polygon) ship.transform(Transform.createTranslateTransform((xTop-xCenter)/60,(yTop-yCenter)/60));*/
        }
        if (container.getInput().isKeyDown(Input.KEY_RIGHT)) {
            ship = (Polygon) ship.transform(Transform.createRotateTransform((float) Math.toRadians(5), ship.getCenterX(), ship.getCenterY()));
            //canMove = true;
        }
        if (container.getInput().isKeyDown(Input.KEY_LEFT)) {
            ship = (Polygon) ship.transform(Transform.createRotateTransform((float) Math.toRadians(-5), ship.getCenterX(), ship.getCenterY()));
            //canMove = true;
        }

        ship = (Polygon) ship.transform(Transform.createTranslateTransform(currentOffsetX,currentOffsetY));
    }

    public void render(GameContainer container, Graphics g) throws SlickException {
        g.setColor(Color.green);
        g.draw(ship);
        g.setColor(Color.red);
        g.drawLine(ship.getCenterX(),ship.getCenterY(),(shipTop.getX() * 2) - ship.getCenterX(),(shipTop.getY() * 2) - ship.getCenterY());
        //g.drawLine(ship.getCenterX(),ship.getCenterY(),(shipTop.getX() * 2) - ship.getCenterX(),(shipTop.getY() * 2) - ship.getCenterY());
        //g.drawLine(ship.getCenterX(),ship.getCenterY(),(shipTop.getX() * 2) - ship.getCenterX(),(shipTop.getY() * 2) - ship.getCenterY());
        g.setColor(Color.green);
        g.drawString("CenterX = "+ship.getCenterX(),450,400);
        g.drawString("CenterY = "+ship.getCenterY(),450,415);
        int y = 430;
        for (int i = 0; i < ship.getPoints().length ; i++) {
            g.drawString(""+ship.getPoints()[i] + " "+ ship.getPoints()[i],450,y);
            y+=15;
        }
        g.drawString("ShipTopPoint = X =" +shipTop.getX()+" Y = "+shipTop.getY(),450,y);

    }

    public Polygon getShip() {
        return ship;
    }
}
