/**
 * @author      Sakibur Rahman sakibur.rahman@city.ac.uk
 * @version     1.0
 * @since       Mar 2021
 */


package game.Weapons;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;
import game.Naruto;

import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shuriken extends Weapon implements ActionListener {



    private Timer t;
    public Shuriken(Naruto n) {
        super(n);
        t = new Timer(50, this);
    }

    @Override
    public void shoot() {
        Bullet b = new Bullet(getNaruto().getWorld(), getNaruto().getPosition(), getShootingDirection());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        shoot();

    }

    @Override
    public void startShooting(){
        t.start();
    }

    @Override
    public void stopShooting(){
        t.stop();
    }
}
