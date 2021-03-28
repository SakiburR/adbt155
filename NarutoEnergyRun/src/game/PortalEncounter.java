package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class PortalEncounter implements CollisionListener {
    private GameLevel level;
    private Game game;
    private static SoundClip portalSound;
    static {
        try {
            portalSound = new SoundClip("data/nextlevelsound.wav");//sound which is played when naruto collides with portal (when requirements are met)
            System.out.println("Next Level.");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    public PortalEncounter(GameLevel level, Game game){
        this.level = level;
        this.game = game;
    }
    @Override
    public void collide(CollisionEvent e) {
        //if naruto collides with portal and the
        //conditions for completing the level are fulfilled
        //goToNextLevel
        if (e.getOtherBody() instanceof Naruto
                && level.isComplete()){
            portalSound.play();
            game.goToNextLevel();

        }
    }
}


