package game;

import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public abstract class GameLevel extends World {
    private Naruto naruto;
    private Portal portal;


    public GameLevel(Game game) {
        naruto = new Naruto(this);
        portal = new Portal(this);
        PortalEncounter encounter = new PortalEncounter(this, game);
        portal.addCollisionListener(encounter);

    }

    public Naruto getNaruto(){
        return naruto;
    }
    public Portal getPortal(){
        return portal;
    }
    public abstract boolean isComplete();
    public abstract Image paintBackground();
    public abstract String getLevelName();
}


