package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Sasuke extends Walker implements StepListener{//Enemy class of the main character
    private static final Shape sasukeShape = new PolygonShape(
            -0.93f,-1.89f, -0.95f,-0.3f, 1.12f,-0.22f, 1.08f,-1.9f);

    private static final BodyImage image =
            new BodyImage("data/sasuke.gif", 4f);

    private enum State{
        MOVE_LEFT, MOVE_RIGHT, STAND_STILL
    }
    public static final float RANGE = 6;
    private State state;
    private GameLevel world;


    public Sasuke(GameLevel world) {
        super(world, sasukeShape);
        this.world = world;
        addImage(image);
        state = State.STAND_STILL;
        getWorld().addStepListener(this);
    }

    public boolean inRangeLeft(){
        Body a = world.getNaruto();
        float gap = getPosition().x - a.getPosition().x;
        return gap < RANGE && gap > 0;
    }

    public boolean inRangeRight(){
        Body a = world.getNaruto();
        float gap = getPosition().x - a.getPosition().x;
        return  gap > -RANGE && gap < 0;
    }
    // update state
    public void preStep(StepEvent e) {
        if (inRangeRight()) {
            if (state != State.MOVE_RIGHT) {
                state = State.MOVE_RIGHT;

            }
        } else if (inRangeLeft()) {
            if (state != State.MOVE_LEFT) {
                state = State.MOVE_LEFT;

            }
        } else {
            if (state != State.STAND_STILL) {
                state = State.STAND_STILL;
                setAngularVelocity(0);
                setLinearVelocity(new Vec2(0, 0));
            }
        }
        refreshRoll();
    }

    // use this to prevent the balls from slowing
    // down and stopping due to friction when they
    // should be rolling
    private void refreshRoll() {
        switch (state) {
            case MOVE_LEFT:
                setLinearVelocity(new Vec2(-2,-5));
                break;
            case MOVE_RIGHT:
                setLinearVelocity(new Vec2(2, -5));
                break;
            default: // nothing to do
        }
    }

    public void postStep(StepEvent e) {
    }
    public void deathCollision(){
        System.out.println("Oh no! You have been destroyed by Sasuke!");
    }


}
