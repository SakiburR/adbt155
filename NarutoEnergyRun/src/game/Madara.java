package game;

import city.cs.engine.*;

public class Madara extends Walker {//Enemy class of the main character
    private static final Shape madaraShape = new PolygonShape(
            0.16f,1.92f,
            1.39f,0.56f,
            1.37f,-1.04f,
            0.72f,-1.79f,
            -1.07f,-1.78f,
            -1.57f,0.44f);

    private static final BodyImage image =
            new BodyImage("data/madara.gif", 4f);


    public Madara(World world) {
        super(world, madaraShape);
        addImage(image);
    }
    public void deathCollision(){
        System.out.println("Oh no! You have been destroyed by Madara!");
    }
}


