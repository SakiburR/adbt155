/**
 * @author      Sakibur Rahman sakibur.rahman@city.ac.uk
 * @version     1.0
 * @since       Mar 2021
 */

package game.Weapons;

import city.cs.engine.Body;
import game.Naruto;
import org.jbox2d.common.Vec2;

public abstract class Weapon {

    private Naruto naruto;
    private Vec2 towards;

    public Naruto getNaruto() {
        return naruto;
    }

    public Weapon(Naruto n){
        naruto = n;
    }

    public abstract void shoot();

    public void startShooting(){

    }

    public void stopShooting(){

    }

    public void setShootingDirection(Vec2 towards){
        this.towards = towards;
    }

    public Vec2 getShootingDirection(){
        return this.towards;
    }



}
