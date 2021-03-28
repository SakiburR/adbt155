package game.Weapons;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.*;

import java.awt.*;

public class BulletImpact implements CollisionListener {
    @Override
    public void collide(CollisionEvent collisionEvent) {

        if (collisionEvent.getOtherBody() instanceof Sasuke){
            collisionEvent.getOtherBody().destroy(); // bullet (shuriken) destroys sasuke
            collisionEvent.getReportingBody().destroy();
        }
        else if (collisionEvent.getOtherBody() instanceof Itachi){
            collisionEvent.getOtherBody().destroy(); // bullet (shuriken) destroys itachi
            collisionEvent.getReportingBody().destroy();
        }
        else if (collisionEvent.getOtherBody() instanceof Madara){
            collisionEvent.getOtherBody().destroy();// bullet (shuriken) destroys madara
            collisionEvent.getReportingBody().destroy();
        }
        else if (collisionEvent.getOtherBody() instanceof Kisame){
            collisionEvent.getOtherBody().destroy();// bullet (shuriken) destroys kisame
            collisionEvent.getReportingBody().destroy();
        }
    }
}
