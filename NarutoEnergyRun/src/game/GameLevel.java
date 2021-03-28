/**
 * @author      Sakibur Rahman sakibur.rahman@city.ac.uk
 * @version     1.0
 * @since       Mar 2021
 */


package game;

import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;


public abstract class GameLevel extends World {
    private Naruto naruto;
    private Portal portal;

    /** * Used for every level
     * @param game uses in game
     */
    public GameLevel(Game game) {
        /** puts naruto in the world */
        naruto = new Naruto(this);
        /** puts the portal in the world */
        portal = new Portal(this);
        /** allows for next level to be accessed with encountering portal */
        PortalEncounter encounter = new PortalEncounter(this, game);
        portal.addCollisionListener(encounter);

    }
    /** * gets naruto
     * @return returns naruto
     */
    public Naruto getNaruto(){
        return naruto;
    }

    /** * gets the portal
     * @return returns portal
     */
    public Portal getPortal(){
        return portal;
    }

    /** checks for completion of level */
    public abstract boolean isComplete();
    /** paints the background of the levels */
    public abstract Image paintBackground();
    /** gets the name of the current level */
    public abstract String getLevelName();
}


