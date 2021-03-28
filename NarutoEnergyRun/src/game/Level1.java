/**
 * @author      Sakibur Rahman sakibur.rahman@city.ac.uk
 * @version     1.0
 * @since       Mar 2021
 */


package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;


public class Level1 extends GameLevel {

    public Level1(Game game){
        super(game);

        getNaruto().setPosition(new Vec2(14,-10)); //spawn position for naruto in the level
        ChakraBallPickup chakraBallPickup= new ChakraBallPickup(getNaruto(), game);
        getNaruto().addCollisionListener(chakraBallPickup); // collision listener for when naruto collides with chakra balls
        getPortal().setPosition(new Vec2(16.5f,12));//position of portal used to teleport to next level

        //ground platform
        Shape shape = new BoxShape(17.5f, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -17.5f));

        //longer platforms:
        Shape platform1Shape = new BoxShape(5, 0.25f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-10, -9f));
        platform1.setFillColor(Color.lightGray);

        StaticBody platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(8f, 2.5f));
        platform2.setFillColor(Color.lightGray);

        StaticBody platform3 = new StaticBody(this, platform1Shape);
        platform3.setPosition(new Vec2(-11, 7f));
        platform3.setFillColor(Color.lightGray);

        StaticBody platform4 = new StaticBody(this, platform1Shape);
        platform4.setPosition(new Vec2(5, -13.5f));
        platform4.setFillColor(Color.lightGray);

        Shape platform3Shape = new BoxShape(7, 0.25f);
        StaticBody platform5 = new StaticBody(this, platform3Shape);
        platform5.setPosition(new Vec2(12, 11.5f));
        platform5.setFillColor(Color.lightGray);

        StaticBody platform6 = new StaticBody(this, platform1Shape);
        platform6.setPosition(new Vec2(10, -6f));
        platform6.setFillColor(Color.lightGray);

        // small platforms:
        Shape platform2Shape = new BoxShape(1.5f,0.25f);
        StaticBody platform7 = new StaticBody(this, platform2Shape);
        platform7.setPosition(new Vec2(-4f, -2f));
        platform7.setFillColor(Color.lightGray);

        StaticBody platform8 = new StaticBody(this, platform2Shape);
        platform8.setPosition(new Vec2(-15f, -5f));
        platform8.setFillColor(Color.lightGray);


        StaticBody platform9 = new StaticBody(this, platform2Shape);
        platform9.setPosition(new Vec2(0f, 11f));
        platform9.setFillColor(Color.lightGray);

        // walls:
        Shape wallShape = new BoxShape(0.5f, 15f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-17f, -3));


        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(17f, -3));


        //collisions between the chakra balls and naruto, and collisions between sasuke, itachi, kisame and naruto
        Sasuke sasuke3 = new Sasuke(this);
        sasuke3.setPosition(new Vec2(-14f,-5f));
        SasukeCollision sasukeCollision = new SasukeCollision(sasuke3);
        sasuke3.addCollisionListener(sasukeCollision);

        Sasuke sasuke1 = new Sasuke(this);
        sasuke1.setPosition(new Vec2(-15f, 13f));
        SasukeCollision sasukeCollision1 = new SasukeCollision(sasuke1);
        sasuke1.addCollisionListener(sasukeCollision1);

        Itachi itachi = new Itachi(this);
        itachi.setPosition(new Vec2(12f,10f));
        ItachiCollision itachiCollision = new ItachiCollision(itachi);
        itachi.addCollisionListener(itachiCollision);

        Kisame kisame = new Kisame(this);
        kisame.setPosition(new Vec2(12,-3));
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
        if (getNaruto().getBallCount() >= 15) //amount of energy balls required in order to go to the next level
            return true;
        else
            return false;
    }
    @Override
    public Image paintBackground(){
        Image background = new ImageIcon("data/background.png").getImage();
        return background;
    }

    @Override
    public String getLevelName() {
        return "Level1";
    }

}
