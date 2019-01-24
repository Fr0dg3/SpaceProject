package de.fab.SpaceGame.gameAssets;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Shape;

public abstract class PhysicalObject extends Entity{

    boolean hasCollision;

    public PhysicalObject(Shape shape, boolean hasCollision) {
        super(shape);
        this.hasCollision = hasCollision;
    }

    public void checkCollision(Shape player){
        //Down
        if (player.getMaxY() > shape.getMinY() &&
                player.getMinY() < shape.getMinY() &&
                player.getCenterX() + player.getWidth() > shape.getCenterX() && player.getCenterX() < shape.getMaxX()) {

            player.setCenterY(shape.getCenterY() - player.getHeight());

            //Up
        } else if (player.getMinY() < shape.getMaxY() &&
                player.getMaxY() > shape.getMaxY() &&
                player.getCenterX() + player.getWidth() > shape.getCenterX() && player.getCenterX() < shape.getMaxX()) {

            player.setCenterY(shape.getCenterY() + shape.getHeight());

            //Left
        } else if (player.getMinX() < shape.getMaxX() &&
                player.getMaxX() > shape.getMaxX() &&
                player.intersects(shape)) {

            player.setCenterX(shape.getCenterX() + shape.getWidth());

            //Right
        } else if (player.getMaxX() < shape.getMinX() &&
                player.getMinX() > shape.getMinX() &&
                player.intersects(shape)) {

            player.setCenterX(shape.getCenterX() - player.getWidth());

        }
    }

    @Override
    protected void update(GameContainer container, int delta) {

    }
}
