package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level4 extends GameLevel{
    private Naruto naruto;
    private Game game;


    public Level4(Game game){
        super(game);


        getNaruto().setPosition(new Vec2(-16f,12)); //setting spawn location of naruto
        ChakraBallPickup chakraBallPickup= new ChakraBallPickup(getNaruto(), game);
        getNaruto().addCollisionListener(chakraBallPickup); //collision between naruto and energy/chakra balls
        getPortal().setPosition(new Vec2(16.5f,13)); //setting position of portal which take to next level




        //ground platform
        Shape shape = new BoxShape(17.5f, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -17.5f));

        //small platforms:
        Shape smallPlatform = new BoxShape(1.7f, 0.25f);
        StaticBody smallplatform1a = new StaticBody(this,smallPlatform);
        smallplatform1a.setPosition(new Vec2(-12f, 8f));

        StaticBody smallplatform1b = new StaticBody(this,smallPlatform);
        smallplatform1b.setPosition(new Vec2(-6f, 8f));

        StaticBody smallplatform1c = new StaticBody(this,smallPlatform);
        smallplatform1c.setPosition(new Vec2(-0f, 8f));

        StaticBody smallplatform1d = new StaticBody(this,smallPlatform);
        smallplatform1d.setPosition(new Vec2(6f, 8f));

        StaticBody smallplatform1e = new StaticBody(this,smallPlatform);
        smallplatform1e.setPosition(new Vec2(12f, 8f));

        StaticBody smallplatform2a = new StaticBody(this,smallPlatform);
        smallplatform2a.setPosition(new Vec2(-15f, 3f));

        StaticBody smallplatform2b = new StaticBody(this,smallPlatform);
        smallplatform2b.setPosition(new Vec2(-9f, 3f));

        StaticBody smallplatform2c = new StaticBody(this,smallPlatform);
        smallplatform2c.setPosition(new Vec2(-3f, 3f));

        StaticBody smallplatform2d = new StaticBody(this,smallPlatform);
        smallplatform2d.setPosition(new Vec2(9f, 3f));

        StaticBody smallplatform2e = new StaticBody(this,smallPlatform);
        smallplatform2e.setPosition(new Vec2(15f, 3f));


        //vertical platforms

        Shape verticalPlatform = new BoxShape(0.5f, 2.2f);
        StaticBody verticalPlatform1 = new StaticBody(this,verticalPlatform);
        verticalPlatform1.setPosition(new Vec2(3f, -9f));

        StaticBody verticalPlatform2 = new StaticBody(this,verticalPlatform);
        verticalPlatform2.setPosition(new Vec2(7f, -12f));

        StaticBody verticalPlatform4 = new StaticBody(this,verticalPlatform);
        verticalPlatform4.setPosition(new Vec2(-5f, -9f));

        StaticBody verticalPlatform3 = new StaticBody(this,verticalPlatform);
        verticalPlatform3.setPosition(new Vec2(-1f, -12f));


        StaticBody verticalPlatform5 = new StaticBody(this,verticalPlatform);
        verticalPlatform5.setPosition(new Vec2(11f, -9f));

        StaticBody verticalPlatform6 = new StaticBody(this,verticalPlatform);
        verticalPlatform6.setPosition(new Vec2(-9f, -12f));

        StaticBody verticalPlatform7 = new StaticBody(this,verticalPlatform);
        verticalPlatform7.setPosition(new Vec2(-14f, -9f));

        StaticBody verticalPlatform8 = new StaticBody(this,verticalPlatform);
        verticalPlatform8.setPosition(new Vec2(15f, -12f));


        // walls:
        Shape wallShape = new BoxShape(0.5f, 15f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-17f, -3));


        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(17f, -3));


        //collisions between the chakra balls and naruto, and collisions between sasuke, itachi, kisame, naruto and respawn portal.

        RespawnPortal respawnPortal = new RespawnPortal(this);//portal which respawns naruto back to starting location
        respawnPortal.setPosition(new Vec2(-12f, 1f));//setting location of portal
        RespawnPortalCollision respawnPortalCollision = new RespawnPortalCollision(respawnPortal);
        respawnPortal.addCollisionListener(respawnPortalCollision);

        RespawnPortal respawnPortal1 = new RespawnPortal(this);//portal which respawns naruto back to starting location
        respawnPortal1.setPosition(new Vec2(-6f, 1f));//setting location of portal
        RespawnPortalCollision respawnPortalCollision1 = new RespawnPortalCollision(respawnPortal1);
        respawnPortal1.addCollisionListener(respawnPortalCollision1);

        RespawnPortal respawnPortal2 = new RespawnPortal(this);//portal which respawns naruto back to starting location
        respawnPortal2.setPosition(new Vec2(-0f, 1f));//setting location of portal
        RespawnPortalCollision respawnPortalCollision2 = new RespawnPortalCollision(respawnPortal2);
        respawnPortal2.addCollisionListener(respawnPortalCollision2);

        RespawnPortal respawnPortal3 = new RespawnPortal(this);//portal which respawns naruto back to starting location
        respawnPortal3.setPosition(new Vec2(12f, 1f));//setting location of portal
        RespawnPortalCollision respawnPortalCollision3 = new RespawnPortalCollision(respawnPortal3);
        respawnPortal3.addCollisionListener(respawnPortalCollision3);

        RespawnPortal respawnPortal4 = new RespawnPortal(this);//portal which respawns naruto back to starting location
        respawnPortal4.setPosition(new Vec2(6f, 1f));//setting location of portal
        RespawnPortalCollision respawnPortalCollision4 = new RespawnPortalCollision(respawnPortal4);
        respawnPortal4.addCollisionListener(respawnPortalCollision4);

        Madara madara = new Madara(this);
        madara.setPosition(new Vec2(15f, 5f));
        MadaraCollision madaraCollision = new MadaraCollision(madara);
        madara.addCollisionListener(madaraCollision);

        Madara madara1 = new Madara(this);
        madara1.setPosition(new Vec2(-9f, 5f));
        MadaraCollision madaraCollision1 = new MadaraCollision(madara1);
        madara1.addCollisionListener(madaraCollision1);

        Madara madara2 = new Madara(this);
        madara2.setPosition(new Vec2(-3f, 5f));
        MadaraCollision madaraCollision2 = new MadaraCollision(madara2);
        madara2.addCollisionListener(madaraCollision2);

        Madara madara3 = new Madara(this);
        madara3.setPosition(new Vec2(-15f, 5f));
        MadaraCollision madaraCollision3 = new MadaraCollision(madara3);
        madara3.addCollisionListener(madaraCollision3);

        Madara madara4 = new Madara(this);
        madara4.setPosition(new Vec2(9f, 5f));
        MadaraCollision madaraCollision4 = new MadaraCollision(madara4);
        madara4.addCollisionListener(madaraCollision4);

        Sasuke sasuke = new Sasuke(this);
        sasuke.setPosition(new Vec2(6f,10f));
        SasukeCollision sasukeCollision = new SasukeCollision(sasuke);
        sasuke.addCollisionListener(sasukeCollision);

        Sasuke sasuke1 = new Sasuke(this);
        sasuke1.setPosition(new Vec2(-6f,10f));
        SasukeCollision sasukeCollision1 = new SasukeCollision(sasuke1);
        sasuke1.addCollisionListener(sasukeCollision1);

        Kisame kisame2 = new Kisame(this);
        kisame2.setPosition(new Vec2(-5f,-15f));
        KisameCollision kisameCollision2 = new KisameCollision(kisame2);
        kisame2.addCollisionListener(kisameCollision2);

        Kisame kisame1 = new Kisame(this);
        kisame1.setPosition(new Vec2(3f,-15f));
        KisameCollision kisameCollision1 = new KisameCollision(kisame1);
        kisame1.addCollisionListener(kisameCollision1);

        Itachi itachi = new Itachi(this);
        itachi.setPosition(new Vec2(12f,-15f));
        ItachiCollision itachiCollision = new ItachiCollision(itachi);
        itachi.addCollisionListener(itachiCollision);

        Itachi itachi1 = new Itachi(this);
        itachi1.setPosition(new Vec2(-12f,-15f));
        ItachiCollision itachiCollision1 = new ItachiCollision(itachi1);
        itachi1.addCollisionListener(itachiCollision1);

        //for loop used to spawn chakra/energy balls
        for (int i = 0; i < 30; i++) {
            ChakraBall ball = new ChakraBall(this);
            ball.setPosition(new Vec2(-20f + i * 2f, 15f));
        }

        for (int i = 0; i < 30; i++) {
            ChakraBall ball2 = new ChakraBall(this);
            ball2.setPosition(new Vec2(-21f + i * 2f, 0f));
        }


    }

    @Override
    public boolean isComplete(){
        if (getNaruto().getBallCount() >= 18) //set required energy ball level to finish the game
            System.exit(0);
            return true;

    }
    @Override
    public Image paintBackground(){
        Image background = new ImageIcon("data/background3.png").getImage(); //background image for level 4
        return background;
    }

    @Override
    public String getLevelName() {
        return "Level4";
    }
}

