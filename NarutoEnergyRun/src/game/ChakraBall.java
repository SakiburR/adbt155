package game;

import city.cs.engine.*;

public class ChakraBall extends Walker {
    private static final Shape chakraShape = new PolygonShape(
            -0.026f,0.362f,
            0.268f,0.264f,
            0.322f,-0.164f,
            0.056f,-0.348f,
            -0.274f,-0.216f,
            -0.352f,0.038f,
            -0.256f,0.264f);

    //image of energy/chakra ball
    private static final BodyImage image =
            new BodyImage("data/energy.png", 1f);


    public ChakraBall(World world) {
        super(world, chakraShape);
        addImage(image);

    }
}

