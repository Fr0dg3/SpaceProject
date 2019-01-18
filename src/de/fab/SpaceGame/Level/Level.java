package de.fab.SpaceGame.Level;

import de.fab.SpaceGame.gameAssets.Wall;
import de.fab.SpaceGame.utils.Coord;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Level {

    Wall [] walls;

    public Level(){
        walls = new Wall[2];
        walls[0] = new Wall(new Coord( 200,200), 5, 50);
        walls[1] = new Wall(new Coord( 400,250), 5, 50);
    }

    public void update(GameContainer container, int delta) throws SlickException {

    }

    public void render(GameContainer container, Graphics g) throws SlickException {
        g.setColor(Color.white);

        for ( Wall wall : walls) {
            g.draw(wall.getWallShape());
        }
    }


}
