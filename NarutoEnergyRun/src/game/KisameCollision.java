package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class KisameCollision implements CollisionListener {
    private Kisame kisame;
    public KisameCollision(Kisame k){
        this.kisame = k;
    }

    private static SoundClip kisameSound;
    static {
        try {
            kisameSound = new SoundClip("data/kisamesound.wav");// sound for when naruto collides with kisame
            System.out.println("Kisame attack sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public static SoundClip getKisameSound() {
        return kisameSound;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Naruto) {
            kisame.deathCollision();
            kisameSound.play();//kisamesound played when naruto gets destroyed
            e.getOtherBody().destroy(); // naruto gets destroyed when colliding with Kisame
        }
        else if (e.getOtherBody() instanceof ChakraBall){
            e.getOtherBody().destroy();//any energy ball which spawns on and touches kisame gets destroyed
        }
    }
}
