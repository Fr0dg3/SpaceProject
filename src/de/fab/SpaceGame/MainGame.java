package de.fab.SpaceGame;

import de.fab.SpaceGame.Level.Level;
import de.fab.SpaceGame.gameAssets.Wall;
import de.fab.SpaceGame.gameAssets.SpaceShip;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;


public class MainGame extends BasicGame{

    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;

    SpaceShip spaceShip;
    Level level;

    public MainGame(String title) {
        super(title);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new MainGame("SpaceGame"));
            container.setDisplayMode(SCREEN_WIDTH,SCREEN_HEIGHT,false);
            container.setTargetFrameRate(60);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void init(GameContainer container) throws SlickException {
        container.setVSync(true);
        spaceShip = new SpaceShip(new Point(100,100));
        level = new Level();
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        spaceShip.update(container, delta);

        /*****************Tests Fabian Collision**************************************************/
       for (Wall wall : level.getWalls()) {
           // if (wall.getShape().intersects(spaceShip.getShip()))
           //   spaceShip.collide();
           wall.checkCollision(spaceShip.getShip());
       }

    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        spaceShip.render(container, g);
        level.render(container, g);
    }
}
