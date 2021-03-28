package game;

import city.cs.engine.*;

public class Portal extends Walker {//portal used to teleport naruto to the next level

    private static final Shape portalShape = new PolygonShape(
            0.08f,1.82f,
            1.11f,0.79f,
            1.08f,-1.09f,
            0.15f,-1.94f,
            -0.99f,-1.01f,
            -1.04f,0.93f
    );

    private static final BodyImage image =
           new BodyImage("data/portal.gif", 4f);

    public Portal(World world) {
        super(world, portalShape);
        addImage(image);
    }
}

