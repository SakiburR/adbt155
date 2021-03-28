/**
 * @author      Sakibur Rahman sakibur.rahman@city.ac.uk
 * @version     1.0
 * @since       Mar 2021
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class RespawnPortalCollision implements CollisionListener {

    private RespawnPortal respawnPortal;

    private static SoundClip respawnPortalSound;
    static {
        try {
            respawnPortalSound = new SoundClip("data/respawnportalsound.wav");// sound when respawnportal collides with naruto
            System.out.println("Respawn");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    public RespawnPortalCollision(RespawnPortal respawnPortal){
        this.respawnPortal = respawnPortal;
    }

    @Override
    //if naruto collides with the respawnportal and the
    //naruto gets teleported back to the respawn position
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Naruto) {
            respawnPortalSound.play();//plays respawnportalsound when naruto collides with the respawn portal
            e.getOtherBody().setPosition(new Vec2(-17f,12));
        }
    }
}