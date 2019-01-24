package de.fab.SpaceGame.gameAssets;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public abstract class Entity {


    protected Shape shape;

    public Entity(Shape shape){
        this.shape = shape;
    }

    protected abstract void update(GameContainer container, int delta);

    public void render(GameContainer container, Graphics g){
        g.fill(shape);
    }

    public Shape getShape() {
        return shape;
    }
}
