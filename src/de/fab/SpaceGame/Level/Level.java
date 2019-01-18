package de.fab.SpaceGame.Level;

import de.fab.SpaceGame.gameAssets.Wall;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;

import static de.fab.SpaceGame.MainGame.SCREEN_HEIGHT;
import static de.fab.SpaceGame.MainGame.SCREEN_WIDTH;

public class Level {

    Wall [] walls;

    public Wall[] getWalls() {
        return walls;
    }

    public Level(){
        walls = new Wall[4];
        walls[0] = new Wall(new Point( 0,0), SCREEN_WIDTH, 5);
        walls[1] = new Wall(new Point( SCREEN_WIDTH - 5,0), 5, SCREEN_HEIGHT);
        walls[2] = new Wall(new Point( 0,SCREEN_HEIGHT - 5), SCREEN_WIDTH, 5);
        walls[3] = new Wall(new Point( 0,0), 5, SCREEN_HEIGHT);
    }

    public void update(GameContainer container, int delta) throws SlickException {

    }

    public void render(GameContainer container, Graphics g) throws SlickException {
        g.setColor(Color.white);

        for ( Wall wall : walls) {
            g.fill(wall.getWallShape());
        }
    }


}
