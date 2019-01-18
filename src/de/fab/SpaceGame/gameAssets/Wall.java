package de.fab.SpaceGame.gameAssets;

import de.fab.SpaceGame.utils.Coord;
import org.newdawn.slick.geom.Rectangle;

public class Wall {


    Rectangle wallShape;

    public Wall(Coord position, int width, int height){
        wallShape = new Rectangle(position.getX(), position.getY(), width, height);
    }

    public Rectangle getWallShape() {
        return wallShape;
    }

    public void setWallShape(Rectangle wallShape) {
        this.wallShape = wallShape;
    }
}
