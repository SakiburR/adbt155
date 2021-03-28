package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyListener;
import java.io.IOException;

public class ItachiCollision implements CollisionListener{

    private Itachi itachi;

    public ItachiCollision(Itachi i){
        this.itachi = i;
    }

    private static SoundClip itachiSound;
    static {
        try {
            itachiSound = new SoundClip("data/itachisound.wav");// sound for when naruto collides with itachi
            System.out.println("Itachi attack sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Naruto) {
            itachi.deathCollision();
            itachiSound.play();//itachisound played when naruto gets destroyed
            e.getOtherBody().destroy(); // naruto gets destroyed when colliding with Itachi
        }
        else if (e.getOtherBody() instanceof ChakraBall){
            e.getOtherBody().destroy();//any energy ball which spawns on and touches itachi gets destroyed
        }
    }
}
