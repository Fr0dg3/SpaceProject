package de.fab.SpaceGame;

import de.fab.SpaceGame.Level.Level;
import de.fab.SpaceGame.utils.Coord;
import de.fab.SpaceGame.gameAssets.SpaceShip;
import org.newdawn.slick.*;

public class MainGame extends BasicGame{

    SpaceShip spaceShip;
    Level level;

    /**
     * Create a new basic game
     *
     * @param title The title for the game
     */
    public MainGame(String title) {
        super(title);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new MainGame("SpaceGame"));
            container.setDisplayMode(1000,1000,false);
            container.setTargetFrameRate(60);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void init(GameContainer container) throws SlickException {
        container.setVSync(true);
        spaceShip = new SpaceShip(new Coord(100,100));
        level = new Level();
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        spaceShip.update(container, delta);
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        spaceShip.render(container, g);
        level.render(container, g);
    }
}
