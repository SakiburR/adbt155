package game;

import city.cs.engine.SoundClip;
import city.cs.engine.World;
import game.Weapons.ShootController;


import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * A world with some bodies.
 */
public class Game extends World {

    /** The World in which the bodies move and interact. */
    private GameLevel level;

    /** A graphical display of the world (a specialised JPanel). */
    private GameView view;

    private static int levelCount;{
        levelCount = 1;
    }
    private static int levelGoal;{
        levelGoal = 15;
    }


    private SoundClip gameMusic;

    private NarutoController narutoController;

    private ShootController shootController;

    private JLabel energyLevel;

    private Naruto naruto;




    /** Initialise a new Game. */
    public Game() {
        // make the world
        level = new Level1(this);

        // make a view
        view = new GameView(level, 700, 700);
        view.setZoom(20);
        view.setBack(level.paintBackground());

        shootController = new ShootController(view, level.getNaruto());
        view.addMouseListener(shootController);
        view.addMouseMotionListener(shootController);

        //background music for the game
        try {
            gameMusic = new SoundClip("data/backgroundmusic.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continuous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        narutoController = new NarutoController(level.getNaruto(), this);
        view.addKeyListener(narutoController);

        view.addMouseListener(new GiveFocus(view));

        //tracks and follows movement of naruto in game
        level.addStepListener(new Tracker(view, level.getNaruto()));

        // add the view to a frame (Java top level window)
        JFrame frame = new JFrame("Naruto Energy Run");
        frame.add(view);

        //secondary zoomed out view of level
        /*UserView wideView = new UserView(level, 300, 100);
        wideView.setZoom(8);
        frame.add(wideView, BorderLayout.EAST);

         */




        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ControlPanel controlPanel = new ControlPanel(this);
        frame.add(controlPanel.getMainPanel(), BorderLayout.WEST);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(true);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //label which indicates how many energy balls naruto has collided with
        energyLevel = new JLabel();
        energyLevel.setFont(new Font("Verdana", 1, 20));
        setEnergyLevel(level.getNaruto().getBallCount());
        view.add(energyLevel);

        // start our game world simulation!
        level.start();

    }



    public GameLevel getLevel() {
        return level;}

    public SoundClip getGameMusic() {
        return gameMusic;
    }

    public void pause() {
        level.stop();
    }

    public void restart(){
        level.start();
    }

    public void setLevel(GameLevel level){
        //stop the current level

        this.level.stop();
        //level now refers to new level
        this.level = level;
        //change the view to look into new level

        view.setWorld(this.level);
        //increments the level by 1 to show Level: 2
        //set Energy Level goal required to go to next level
        view.setBack(this.level.paintBackground());
        this.level.addStepListener(new Tracker(view, this.level.getNaruto()));
        //change the controller to control naruto in the new world
        narutoController.updateNaruto(this.level.getNaruto());

        //start the simulation in the new level
        this.level.start();
    }


    public void goToNextLevel() {

            if (level instanceof Level1) {
                //stop the current level

                level.stop();
                //level now refers to new level
                level = new Level2(this);
                //change the view to look into new level

                view.setWorld(level);
                //increments the level by 1 to show Level: 2
                levelCount++;
                //set Energy Level goal required to go to next level
                levelGoal = 20;
                view.setBack(level.paintBackground());
                level.addStepListener(new Tracker(view, level.getNaruto()));
                //change the controller to control naruto in the new world
                narutoController.updateNaruto(level.getNaruto());
                shootController.updateShootController(level.getNaruto());


                //start the simulation in the new level
                level.start();
            } else if (level instanceof Level2) {
                level.stop();
                //level now refers to new level
                level = new Level3(this);
                //change the view to look into new level
                view.setWorld(level);;
                //set the level counter to Level: 3
                levelCount++;
                //set the Energy Level Goal required to reach next level
                levelGoal = 25;
                view.setBack(level.paintBackground());
                level.addStepListener(new Tracker(view, level.getNaruto()));
                //change the controller to control naruto in the new world
                narutoController.updateNaruto(level.getNaruto());
                shootController.updateShootController(level.getNaruto());

                //start the simulation in the new level
                level.start();
            } else if (level instanceof Level3) {
                level.stop();
                //level now refers to new level
                level = new Level4(this);
                //change the view to look into new level
                view.setWorld(level);
                //set the level counter to Level: 4
                levelCount++;
                levelGoal = 18;
                //set the Energy Level Goal required to reach next level
                view.setBack(level.paintBackground());
                level.addStepListener(new Tracker(view, level.getNaruto()));
                //change the controller to control naruto in the new world
                narutoController.updateNaruto(level.getNaruto());
                shootController.updateShootController(level.getNaruto());

                view.updateView(view);
                //start the simulation in the new level
                level.start();
            } else if (level instanceof Level4){
                level.stop();
                //level now refers to new level
                view.setWorld(level);
                levelCount++;
                levelGoal= 20;
                //set the Energy level goal required to reach end of he game/ next level
                view.setBack(level.paintBackground());
                

        }
        }


    public void setEnergyLevel(int level){
        energyLevel.setText("Energy Level: " + level);
    }


    public static int getLevelCount() {
        return levelCount;
    }

    public static int getLevelGoal() {
        return levelGoal;
    }

    public Naruto getNaruto(){
        return naruto;
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
