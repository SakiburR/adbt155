package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level2 extends GameLevel{

    private Naruto naruto;
    private Game game;


    public Level2(Game game){
        super(game);

        getNaruto().setPosition(new Vec2(-16f,12)); //spawn position for naruto in the level
        ChakraBallPickup chakraBallPickup= new ChakraBallPickup(getNaruto(), game);
        getNaruto().addCollisionListener(chakraBallPickup); // collision listener for when naruto collides with chakra balls
        getPortal().setPosition(new Vec2(16.5f,13)); //position of portal used to teleport to next level




        //ground platform
        Shape shape = new BoxShape(17.5f, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -17.5f));

        //longer platforms:
        Shape platform1Shape = new BoxShape(4, 0.25f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-9, -9f));
        platform1.setFillColor(Color.lightGray);
        platform1.setAngleDegrees(-22);

        StaticBody platform10 = new StaticBody(this, platform1Shape);
        platform10.setPosition(new Vec2(-1, -9f));
        platform10.setFillColor(Color.lightGray);
        platform10.setAngleDegrees(22);

        StaticBody platform4 = new StaticBody(this, platform1Shape);
        platform4.setPosition(new Vec2(5, -13.5f));
        platform4.setFillColor(Color.red);


        // small platforms:
        Shape platform2Shape = new BoxShape(2f,0.25f);
        StaticBody platform7 = new StaticBody(this, platform2Shape);
        platform7.setPosition(new Vec2(-2.5f, 3.5f));
        platform7.setFillColor(Color.red);

        StaticBody platform5 = new StaticBody(this, platform2Shape);
        platform5.setPosition(new Vec2(-11.5f, 10f));
        platform5.setFillColor(Color.red);

        StaticBody platform8 = new StaticBody(this, platform2Shape);
        platform8.setPosition(new Vec2(-15f, -5f));
        platform8.setFillColor(Color.red);


        StaticBody platform9 = new StaticBody(this, platform2Shape);
        platform9.setPosition(new Vec2(0f, 11f));
        platform9.setFillColor(Color.red);

        StaticBody platform9b = new StaticBody(this, platform2Shape);
        platform9b.setPosition(new Vec2(12f, -9f));
        platform9b.setFillColor(Color.red);

        StaticBody platform11 = new StaticBody(this, platform2Shape);
        platform11.setPosition(new Vec2(6.5f, -6f));
        platform11.setFillColor(Color.red);

        StaticBody platform12 = new StaticBody(this, platform2Shape);
        platform12.setPosition(new Vec2(12f, -2f));
        platform12.setFillColor(Color.red);

        StaticBody platform13 = new StaticBody(this, platform2Shape);
        platform13.setPosition(new Vec2(6.5f, 1.5f));
        platform13.setFillColor(Color.red);

        StaticBody platform14 = new StaticBody(this, platform2Shape);
        platform14.setPosition(new Vec2(13f, 4.5f));
        platform14.setFillColor(Color.red);
        platform14.setAngleDegrees(20);

        StaticBody platform15 = new StaticBody(this, platform2Shape);
        platform15.setPosition(new Vec2(7f,7.5f));
        platform15.setFillColor(Color.red);

        // walls:
        Shape wallShape = new BoxShape(0.5f, 15f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-17f, -3));

        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(17f, -3));


        //collisions between the chakra balls and naruto, and collisions between sasuke, itachi, kisame and naruto
        RespawnPortal respawnPortal = new RespawnPortal(this); //portal which respawns naruto back to starting location
        respawnPortal.setPosition(new Vec2(-7f, 2.5f));
        RespawnPortalCollision respawnPortalCollision = new RespawnPortalCollision(respawnPortal);
        respawnPortal.addCollisionListener(respawnPortalCollision); //portal which respawns naruto back to starting location

        RespawnPortal respawnPortal2 = new RespawnPortal(this);//portal which respawns naruto back to starting location
        respawnPortal2.setPosition(new Vec2(-15f, -15f));
        RespawnPortalCollision respawnPortalCollision2 = new RespawnPortalCollision(respawnPortal2);
        respawnPortal2.addCollisionListener(respawnPortalCollision2);

        RespawnPortal respawnPortal3 = new RespawnPortal(this);//portal which respawns naruto back to starting location
        respawnPortal3.setPosition(new Vec2(9.5f, 16f));
        RespawnPortalCollision respawnPortalCollision3 = new RespawnPortalCollision(respawnPortal3);
        respawnPortal3.addCollisionListener(respawnPortalCollision3);

        Sasuke sasuke = new Sasuke(this);
        sasuke.setPosition(new Vec2(0f,12.5f));
        SasukeCollision sasukeCollision = new SasukeCollision(sasuke);
        sasuke.addCollisionListener(sasukeCollision);

        Sasuke sasuke1 = new Sasuke(this);
        sasuke1.setPosition(new Vec2(-15f, 6f));
        SasukeCollision sasukeCollision1 = new SasukeCollision(sasuke1);
        sasuke1.addCollisionListener(sasukeCollision1);

        Itachi itachi = new Itachi(this);
        itachi.setPosition(new Vec2(12f,10f));
        ItachiCollision itachiCollision = new ItachiCollision(itachi);
        itachi.addCollisionListener(itachiCollision);

        Kisame kisame = new Kisame(this);
        kisame.setPosition(new Vec2(-4.5f,-9f));
        KisameCollision kisameCollision = new KisameCollision(kisame);
        kisame.addCollisionListener(kisameCollision);



        //for loop used to spawn chakra/energy balls
        for (int i = 0; i < 25; i++) {
            ChakraBall ball = new ChakraBall(this);
            ball.setPosition(new Vec2(-20f + i * 2f, 15f));
        }

        for (int i = 0; i < 25; i++) {
            ChakraBall ball2 = new ChakraBall(this);
            ball2.setPosition(new Vec2(-21f + i * 2f, 0f));
        }


    }

    @Override
    public boolean isComplete(){
        if (getNaruto().getBallCount() >= 20) //amount of energy balls required in order to go to the next level
            return true;
        else
            return false;
    }

    @Override
    public Image paintBackground(){
        Image background1 = new ImageIcon("data/background1.png").getImage();
        return background1;
    }

    @Override
    public String getLevelName() {
        return "Level2";
    }
}