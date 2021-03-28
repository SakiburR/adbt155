/**
 * @author      Sakibur Rahman sakibur.rahman@city.ac.uk
 * @version     1.0
 * @since       Mar 2021
 */
package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {
    private GameView view;
    private Naruto naruto;

    public Tracker(GameView view, Naruto naruto) {// follows/tracks naruto around in the game
        this.view = view;
        this.naruto = naruto;

    }
    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(naruto.getPosition()));
    }
}