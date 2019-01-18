package de.fab.SpaceGame.gameAssets;

import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;

public class Wall {


    Rectangle wallShape;

    public Wall(Point position, int width, int height){
        wallShape = new Rectangle(position.getX(), position.getY(), width, height);
    }

    public Rectangle getWallShape() {
        return wallShape;
    }

    public void setWallShape(Rectangle wallShape) {
        this.wallShape = wallShape;
    }
}
