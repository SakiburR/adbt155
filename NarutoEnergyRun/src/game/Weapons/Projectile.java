/**
 * @author      Sakibur Rahman sakibur.rahman@city.ac.uk
 * @version     1.0
 * @since       Mar 2021
 */


package game.Weapons;

import city.cs.engine.DynamicBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public abstract class Projectile extends DynamicBody {

    public Projectile(World w, Vec2 from, Vec2 towards){
        super(w);
        this.setPosition(from.add(towards));
        this.setLinearVelocity(towards.mul(getSpeed()));
        this.addCollisionListener(new BulletImpact());
    }

    public abstract float getSpeed();

}
