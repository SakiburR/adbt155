/**
 * @author      Sakibur Rahman sakibur.rahman@city.ac.uk
 * @version     1.0
 * @since       Mar 2021
 */
package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Itachi extends Walker { //Enemy class of the main character
    private static final Shape itachiShape = new PolygonShape(
            -0.96f,-1.93f,
            -1.54f,-0.49f,
            -0.75f,0.55f,
            0.17f,0.64f,
            0.97f,-0.58f,
            0.7f,-1.87f);

    private static final BodyImage image =
            new BodyImage("data/itachi.gif", 4f);
    /**
     * itachi is displayed in world
     * @param world displays body in world
     * @return nothing
     */
    public Itachi(World world) {
        super(world, itachiShape);
        addImage(image);
    }
    /** text printed when naruto collides with body */
    public void deathCollision(){
        System.out.println("Oh no! You have been destroyed by Itachi!");
    }


}
