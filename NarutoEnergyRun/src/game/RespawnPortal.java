package game;

import city.cs.engine.*;

public class RespawnPortal extends StaticBody {//portal used to send naruto back to spawn location upon collision
    private static final Shape respawnPortalShape = new PolygonShape(
            0.01f,1.85f,
            0.97f,0.86f,
            1.02f,-0.88f,
            0.01f,-1.81f,
            -1.14f,-0.5f,
            -1.15f,0.82f);

    private static final BodyImage image =
            new BodyImage("data/respawn.gif", 4f);

    public RespawnPortal(World world) {
        super(world, respawnPortalShape);
        addImage(image);
    }
}