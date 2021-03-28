package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class SasukeCollision implements CollisionListener {

    private Sasuke sasuke;

    public SasukeCollision(Sasuke s){
        this.sasuke = s;
    }

    private static SoundClip sasukeSound;
    static {
        try {
            sasukeSound = new SoundClip("data/sasukesound.wav");
            System.out.println("Sasuke attack sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Naruto) {
            sasuke.deathCollision();
            sasukeSound.play();
            e.getOtherBody().destroy(); // naruto gets destroyed when colliding with Sasuke
        }
        else if (e.getOtherBody() instanceof ChakraBall){
            e.getOtherBody().destroy();
        }
    }
}
