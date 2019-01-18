package org.newdawn.slick.tests.spaceProjectTests;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Transform;

public class CollisionTest extends BasicGame {

    /**
     * Create a new basic game
     *
     */
    public CollisionTest() {
        super("CollisionTest");
    }

    Polygon ship;
    Point shipTop;
    Rectangle wall;
    private float currentOffsetX = 0;
    private float currentOffsetY = 0;
    private final static float SPEEDLIMIT = 5;

    @Override
    public void init(GameContainer container) throws SlickException {
        ship = new Polygon();
        ship.addPoint(100,100);
        ship.addPoint(110,50);
        ship.addPoint(120,100);
        ship.addPoint(110,90);

        this.ship = ship;
        this.shipTop = new Point(ship.getPoints()[2],ship.getPoints()[3]);

        wall = new Rectangle(700,350,100,300);
        container.setVSync(true);

        shipTop.setX(ship.getPoints()[2]);
        shipTop.setY(ship.getPoints()[3]);
        if (container.getInput().isKeyDown(Input.KEY_UP)) {
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
        }
        if (container.getInput().isKeyDown(Input.KEY_LEFT)) {
            ship = (Polygon) ship.transform(Transform.createRotateTransform((float) Math.toRadians(-5), ship.getCenterX(), ship.getCenterY()));
        }

        ship = (Polygon) ship.transform(Transform.createTranslateTransform(currentOffsetX,currentOffsetY));
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        shipTop.setX(ship.getPoints()[2]);
        shipTop.setY(ship.getPoints()[3]);
        if (container.getInput().isKeyDown(Input.KEY_UP)) {
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
        }
        if (container.getInput().isKeyDown(Input.KEY_LEFT)) {
            ship = (Polygon) ship.transform(Transform.createRotateTransform((float) Math.toRadians(-5), ship.getCenterX(), ship.getCenterY()));
        }
        float minX = ship.getMinX();
        float maxX = ship.getMaxX();
        float minY = ship.getMinY();
        float maxY = ship.getMaxY();

        if (wall.contains(minX,minY)){
            if (currentOffsetX <0) currentOffsetX = 0;
            if (currentOffsetY <0) currentOffsetY = 0;
        }




            ship = (Polygon) ship.transform(Transform.createTranslateTransform(currentOffsetX,currentOffsetY));
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        g.draw(ship);
        g.draw(wall);
        g.setColor(Color.green);
        g.draw(ship);
        g.drawString("CenterX = "+ship.getCenterX(),500,500);
        g.drawString("CenterY = "+ship.getCenterY(),500,515);
        int y = 530;
        for (int i = 0; i < ship.getPoints().length ; i++) {
            g.drawString(""+ship.getPoints()[i] + " "+ ship.getPoints()[i],500,y);
            y+=15;
        }
        g.drawString("ShipTopPoint = X =" +shipTop.getX()+" Y = "+shipTop.getY(),500,y);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new CollisionTest());
            app.setDisplayMode(1000,1000, false);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
