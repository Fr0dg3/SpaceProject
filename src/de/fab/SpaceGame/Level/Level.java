package de.fab.SpaceGame.Level;

import de.fab.SpaceGame.gameAssets.Wall;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import static de.fab.SpaceGame.MainGame.SCREEN_HEIGHT;
import static de.fab.SpaceGame.MainGame.SCREEN_WIDTH;

public class Level {

    Wall [] walls;

    public Wall[] getWalls() {
        return walls;
    }

    public Level(){
        walls = new Wall[6];
        walls[0] = new Wall(new Rectangle( 0,0, SCREEN_WIDTH, 1), true);
        walls[1] = new Wall(new Rectangle( SCREEN_WIDTH - 5,0, 1, SCREEN_HEIGHT), true);
        walls[2] = new Wall(new Rectangle( 0,SCREEN_HEIGHT - 5, SCREEN_WIDTH, 1), true);
        walls[3] = new Wall(new Rectangle( 0,0, 1, SCREEN_HEIGHT), true);

        walls[4] = new Wall(new Rectangle( 395,0, 1, SCREEN_HEIGHT), true);
        walls[5] = new Wall(new Rectangle( 0,350, SCREEN_WIDTH, 1), true);
    }

    public void update(GameContainer container, int delta) throws SlickException {

    }

    public void render(GameContainer container, Graphics g) throws SlickException {
        for ( Wall wall : walls)
            wall.render(container, g);
    }
}
