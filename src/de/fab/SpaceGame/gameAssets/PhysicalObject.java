package de.fab.SpaceGame.gameAssets;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Shape;

public abstract class PhysicalObject extends Entity{

    boolean hasCollision;

    public PhysicalObject(Shape shape, boolean hasCollision) {
        super(shape);
        this.hasCollision = hasCollision;
    }

    @Override
    protected void update(GameContainer container, int delta) {

    }
}
