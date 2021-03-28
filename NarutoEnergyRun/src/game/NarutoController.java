package game;

import city.cs.engine.Body;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class NarutoController implements KeyListener {
    private static final float WALKING_SPEED = 7;//set speed for walking
    private static final float DOUBLE_SPEED = WALKING_SPEED *2; // set speed for running/super speed
    private static final float JUMPING_SPEED = 10; //set speed for jump
    private static final float SUPER_JUMP = JUMPING_SPEED * 1.5f;//set speed for super jump


    private Naruto naruto;
    private Game game;

    public NarutoController(Naruto n, Game game){
        this.naruto = n;
        this.game = game;
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) {//uses the letter Q
            System.exit(0);// quits the game
        } else if (code == KeyEvent.VK_W){//uses the letter W
            Vec2 v = naruto.getLinearVelocity();
            if (Math.abs(v.y) < 0.01f) {
                naruto.jump(JUMPING_SPEED);// makes naruto jump in air
            }
        } else if (code == KeyEvent.VK_A) {//uses the letter A
            naruto.startWalking(-WALKING_SPEED);// makes naruto walk at his normal speed to the left
        } else if (code == KeyEvent.VK_D) {//uses the letter D
            naruto.startWalking(WALKING_SPEED);// makes naruto walk at his normal speed to the right
        }

        if (code == KeyEvent.VK_LEFT) {//uses left arrow key
            naruto.startWalking(-DOUBLE_SPEED);// makes naruto walk at his super speed to the left
        } else if (code == KeyEvent.VK_RIGHT) {// uses right arrow key
            naruto.startWalking(DOUBLE_SPEED); // makes naruto walk at his super speed to the right
        }
        if (code == KeyEvent.VK_UP){//uses the Upwards arrow key
            Vec2 v = naruto.getLinearVelocity();
            if (Math.abs(v.y)< 0.01f){
                naruto.jump(SUPER_JUMP);// makes naruto use his super jump
            }
        }
        if (code == KeyEvent.VK_S){
            try {
                GameSaverLoader.save(game.getLevel(), "data/save.txt");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else if (code == KeyEvent.VK_L){
            try {
               GameLevel level = GameSaverLoader.load(game,"data/save.txt");
               game.setLevel(level);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }
        else if (code == KeyEvent.VK_0){
            naruto.setActiveWeapon(0);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            naruto.stopWalking();
        } else if (code == KeyEvent.VK_D){
            naruto.stopWalking();
        }
        if (code == KeyEvent.VK_LEFT) {
            naruto.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT){
            naruto.stopWalking();
        }

    }

    public void updateNaruto(Naruto naruto){
        this.naruto = naruto;
    }
}


