package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;


public class GameView extends UserView {

    private GameLevel level;
    public Image back;
    private UserView userView;

    public GameView(World w, int width, int height) {
        super(w, width, height);
    }

    public void setBack(Image background){
        this.back = background;
    }

    @Override
    protected void paintBackground(Graphics2D g) {

        g.drawImage(back, 0, -60, this);
    }
    protected void paintForeground(Graphics2D g){
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Verdana", Font.BOLD, 18));
        g.drawString("Level: "+ Game.getLevelCount() , 30, 25);// indicates to the user which level is being played on
        g.drawString("Goal: " + Game.getLevelGoal(), 600, 25);// indicates to the user how many energy balls to collect to go to the next round
    }

public void updateView(UserView userView){
        this.level = level;
}




}
