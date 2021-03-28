package game.Weapons;

import city.cs.engine.UserView;
import game.GameView;
import game.Naruto;
import org.jbox2d.common.Vec2;

import javax.swing.text.View;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;

public class ShootController implements MouseListener, MouseMotionListener {

    private Naruto naruto;
    private GameView view;
    public ShootController(GameView view, Naruto naruto){
        this.naruto = naruto;
        this.view = view;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        naruto.getActiveWeapon().shoot(); // bullet (shuriken) is shot when mouse is clicked

    }

    @Override
    public void mousePressed(MouseEvent e) {
        naruto.getActiveWeapon().startShooting(); // bullet (shuriken) is shot when mouse is pressed

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        naruto.getActiveWeapon().stopShooting(); // bullet (shuriken) stops shooting when mouseclick is released
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Vec2 p = view.viewToWorld(new Point2D.Float(e.getX(),e.getY()));
        Vec2 direction = p.sub(naruto.getPosition());
        direction.normalize();
        naruto.getActiveWeapon().setShootingDirection(direction);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Vec2 p = view.viewToWorld(new Point2D.Float(e.getX(),e.getY()));
        Vec2 direction = p.sub(naruto.getPosition());
        direction.normalize();
        naruto.getActiveWeapon().setShootingDirection(direction);

    }
    public void updateShootController(Naruto naruto){
        this.naruto = naruto;
    }
}
