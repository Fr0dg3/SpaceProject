package de.fab.SpaceGame.gameAssets;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Wall extends PhysicalObject{



    public Wall(Shape shape, boolean hasCollision) {
        super(shape, hasCollision);
    }

    @Override
    public void render(GameContainer container, Graphics g) {
        g.setColor(Color.white);
        super.render(container, g);
    }
}
