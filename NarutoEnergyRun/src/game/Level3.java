/**
 * @author      Sakibur Rahman sakibur.rahman@city.ac.uk
 * @version     1.0
 * @since       Mar 2021
 */


package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level3 extends GameLevel{

    private Naruto naruto;
    private Game game;


    public Level3(Game game){
        super(game);

        getNaruto().setPosition(new Vec2(-16f,12));//spawn position for naruto in the level
        ChakraBallPickup chakraBallPickup= new ChakraBallPickup(getNaruto(), game);
        getNaruto().addCollisionListener(chakraBallPickup);// collision listener for when naruto collides with chakra balls
        getPortal().setPosition(new Vec2(15f,2));//position of portal used to teleport to next level




        //ground platform
        Shape shape = new BoxShape(17.5f, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -17.5f));

        //small platforms:
        Shape smallPlatform = new BoxShape(2f, 0.25f);
        StaticBody smallplatform1 = new StaticBody(this,smallPlatform);
        smallplatform1.setPosition(new Vec2(-14.5f, 8f));

        StaticBody smallplatform2 = new StaticBody(this,smallPlatform);
        smallplatform2.setPosition(new Vec2(-14.5f, 1f));

        StaticBody smallplatform3 = new StaticBody(this,smallPlatform);
        smallplatform3.setPosition(new Vec2(-14.5f, -6f));

        StaticBody smallplatform4 = new StaticBody(this,smallPlatform);
        smallplatform4.setPosition(new Vec2(-1.5f, 1f));

        StaticBody smallplatform5 = new StaticBody(this,smallPlatform);
        smallplatform5.setPosition(new Vec2(3f, 4.5f));

        StaticBody smallplatform6 = new StaticBody(this,smallPlatform);
        smallplatform6.setPosition(new Vec2(14.5f, -6.5f));

        Shape smallPlatform2 = new BoxShape(1.5f, 0.25f);
        StaticBody smallplatform7 = new StaticBody(this,smallPlatform2);
        smallplatform7.setPosition(new Vec2(15f, -1f));

        //small rotated platforms
        StaticBody rotatedPlatform1 = new StaticBody(this,smallPlatform);
        rotatedPlatform1.setPosition(new Vec2(-8f, 4.5f));
        rotatedPlatform1.setAngleDegrees(22);

        StaticBody rotatedPlatform2 = new StaticBody(this,smallPlatform);
        rotatedPlatform2.setPosition(new Vec2(-8f, -2.5f));
        rotatedPlatform2.setAngleDegrees(22);

        //vertical platforms
        Shape verticalPlatform = new BoxShape(0.5f, 2.2f);
        StaticBody verticalPlatform1 = new StaticBody(this,verticalPlatform);
        verticalPlatform1.setPosition(new Vec2(-10f, -14f));

        StaticBody verticalPlatform2 = new StaticBody(this,verticalPlatform);
        verticalPlatform2.setPosition(new Vec2(-4f,-11f));

        StaticBody verticalPlatform3 = new StaticBody(this,verticalPlatform);
        verticalPlatform3.setPosition(new Vec2(3f, -9f));

        StaticBody verticalPlatform4 = new StaticBody(this,verticalPlatform);
        verticalPlatform4.setPosition(new Vec2(8f, -14f));

        StaticBody verticalPlatform5 = new StaticBody(this,verticalPlatform);
        verticalPlatform5.setPosition(new Vec2(6f, -2f));

        StaticBody verticalPlatform6 = new StaticBody(this,verticalPlatform);
        verticalPlatform6.setPosition(new Vec2(9.5f, -6f));

        StaticBody verticalPlatform7 = new StaticBody(this,verticalPlatform);
        verticalPlatform7.setPosition(new Vec2(10f, 4f));

        // walls:
        Shape wallShape = new BoxShape(0.5f, 15f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-17f, -3));


        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(17f, -3));


        //collisions between the chakra balls and naruto, and collisions between sasuke, itachi, kisame and naruto
        //respawn portal teleports naruto back to spawn location

        RespawnPortal respawnPortal = new RespawnPortal(this);//portal which respawns naruto back to starting location
        respawnPortal.setPosition(new Vec2(-7f, 11f));//setting location of portal
        RespawnPortalCollision respawnPortalCollision = new RespawnPortalCollision(respawnPortal);
        respawnPortal.addCollisionListener(respawnPortalCollision);

        RespawnPortal respawnPortal2 = new RespawnPortal(this);
        respawnPortal2.setPosition(new Vec2(9f, 13f));//setting location of portal
        RespawnPortalCollision respawnPortalCollision2 = new RespawnPortalCollision(respawnPortal2);
        respawnPortal2.addCollisionListener(respawnPortalCollision2);

        RespawnPortal respawnPortal3 = new RespawnPortal(this);
        respawnPortal3.setPosition(new Vec2(0f, -1f));//setting location of portal
        RespawnPortalCollision respawnPortalCollision3 = new RespawnPortalCollision(respawnPortal3);
        respawnPortal3.addCollisionListener(respawnPortalCollision3);

        RespawnPortal respawnPortal4 = new RespawnPortal(this);
        respawnPortal4.setPosition(new Vec2(14.5f, -14.5f));//setting location of portal
        RespawnPortalCollision respawnPortalCollision4 = new RespawnPortalCollision(respawnPortal4);
        respawnPortal4.addCollisionListener(respawnPortalCollision4);


        Sasuke sasuke = new Sasuke(this);
        sasuke.setPosition(new Vec2(0f,12.5f));
        SasukeCollision sasukeCollision = new SasukeCollision(sasuke);
        sasuke.addCollisionListener(sasukeCollision);

        Madara madara = new Madara(this);
        madara.setPosition(new Vec2(-15f, 3f));
        MadaraCollision madaraCollision = new MadaraCollision(madara);
        madara.addCollisionListener(madaraCollision);

        Sasuke sasuke1 = new Sasuke(this);
        sasuke1.setPosition(new Vec2(3f,-5f));
        SasukeCollision sasukeCollision1 = new SasukeCollision(sasuke1);
        sasuke1.addCollisionListener(sasukeCollision1);

        Itachi itachi = new Itachi(this);
        itachi.setPosition(new Vec2(15.5f,-2f));
        ItachiCollision itachiCollision = new ItachiCollision(itachi);
        itachi.addCollisionListener(itachiCollision);

        Kisame kisame = new Kisame(this);
        kisame.setPosition(new Vec2(3f,8f));
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
        if (getNaruto().getBallCount() >= 25) //amount of energy balls required in order to go to the next level
            return true;
        else
            return false;
    }
    @Override
    public Image paintBackground(){
        Image background2 = new ImageIcon("data/background2.png").getImage();
        return background2;
    }

    @Override
    public String getLevelName() {
        return "Level3";
    }
}