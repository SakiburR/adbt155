package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class MadaraCollision implements CollisionListener {
    private Madara madara;
    public MadaraCollision(Madara m){
        this.madara = m;
    }

    private static SoundClip madaraSound;
    static {
        try {
            madaraSound = new SoundClip("data/madarasound.wav");// sound for when naruto collides with madara
            System.out.println("Madara attack sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Naruto) {
            madara.deathCollision();
            madaraSound.play();//madarasound played when naruto gets destroyed
            e.getOtherBody().destroy(); // naruto gets destroyed when colliding with Madara
        }
        else if (e.getOtherBody() instanceof ChakraBall){
            e.getOtherBody().destroy();//any energy ball which spawns on and touches madara gets destroyed
        }
    }
}
