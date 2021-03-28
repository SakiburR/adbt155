package game;

import javax.swing.*;
import javax.swing.plaf.ProgressBarUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel {
    private JPanel mainPanel;
    private JButton pauseButton;
    private JButton restartButton;
    private JButton quitButton;
    private JButton muteButton;
    private JButton unmuteMusicButton;
    private JButton saveButton;
    private Game game;
public ControlPanel(Game game){

        this.game= game;


        pauseButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.pause();
        }});//pauses the game

        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.restart();
            }//unpauses the game
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }// quits the game
        });

        muteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.getGameMusic().pause();
            }//mutes/stops background music
        });
        unmuteMusicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.getGameMusic().resume();
            }//resumes background music
        });



}
    public JPanel getMainPanel() {
        return mainPanel;

    }





}
