/**
 * @author      Sakibur Rahman sakibur.rahman@city.ac.uk
 * @version     1.0
 * @since       Mar 2021
 */


package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.SoundClip;
import city.cs.engine.World;
import city.cs.engine.CollisionListener;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

//collision handler responsible for energyball and naruto collision
public class ChakraBallPickup implements CollisionListener {
    private Naruto naruto;
    private Game game;
    private static SoundClip chakraBallSound;
    static {
        try {
            chakraBallSound = new SoundClip("data/energysound.wav"); //sound when naruto collides with energyball
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    public ChakraBallPickup(Naruto n, Game game){
        this.naruto = n;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof ChakraBall) {
            naruto.addChakraBall();//
            chakraBallSound.play();//sound played
            e.getOtherBody().destroy(); // destroys the chakra ball when in contact with naruto
            // update the HUD
            game.setEnergyLevel(naruto.getBallCount());
        }
    }
}
