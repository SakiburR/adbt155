package game.Weapons;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

public class Bullet extends Projectile{

    private static final BodyImage image =
            new BodyImage("data/shuriken.gif", 1.75f); //image of bullet (shuriken)

    private static SoundClip bulletSound;
    static {
        try {
            bulletSound = new SoundClip("data/shuriken.wav");// sound for when naruto launches the bullet (shuriken)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

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
