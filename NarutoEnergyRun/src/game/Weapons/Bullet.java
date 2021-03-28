/**
 * @author      Sakibur Rahman sakibur.rahman@city.ac.uk
 * @version     1.0
 * @since       Mar 2021
 */


package game.Weapons;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

public class Bullet extends Projectile{

    /**
     * Used to display Image.
     * <p>
     * This method is generally used to display images on different types of bodies.
     *
     * @param  image image of object
     */
    private static final BodyImage image =
            new BodyImage("data/shuriken.gif", 1.75f); //image of bullet (shuriken)

    /**
     * Used to load sound files.
     * <p>
     * Used to load sound files which can be used on bodies and collisions etc.
     *
     * @param  bulletSound the sound of the shuriken
     * @return sound of the shuriken when launched
     */
    private static SoundClip bulletSound;
    static {
        try {
            bulletSound = new SoundClip("data/shuriken.wav");// sound for when naruto launches the bullet (shuriken)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    /**
     * Displays the actual bullet/shuriken
     * <p>
     * Displays shuriken's shape, image, size, and plays the sound.
     *
     * @param  w the world in which the game is displayed
     * @param  from initial position
     * @param  towards direction of position
     */
    public Bullet(World w, Vec2 from, Vec2 towards) {
        super(w, from, towards);
        addImage(image); // displays bullet (shuriken) image
        bulletSound.play(); //plays bullet (shuriken) sound

        CircleShape s = new CircleShape(0.1f); //shape of the hitbox of the bullet (shuriken)
        Fixture f = new SolidFixture(this, s);

    }

    @Override
    public  float getSpeed(){
        return 20; //speed at which the bullet (shuriken) is launched
    }
}
