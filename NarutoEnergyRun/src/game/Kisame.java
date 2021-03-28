/**
 * @author      Sakibur Rahman sakibur.rahman@city.ac.uk
 * @version     1.0
 * @since       Mar 2021
 */


package game;

import city.cs.engine.*;

public class Kisame extends Walker {//Enemy class of the main character
    private static final Shape kisameShape = new PolygonShape(
            -0.9f,-0.11f,
            0.1f,0.42f,
            1.11f,-0.2f,
            1.15f,-1.28f,
            0.51f,-1.58f,
            -0.34f,-1.58f);

    private static final BodyImage image =
            new BodyImage("data/kisame.gif", 4f);

    public Kisame(World world) {
        super(world, kisameShape);
        addImage(image);
    }

    public void deathCollision(){
        System.out.println("Oh no! You have been destroyed by Kisame!");
    }
}
