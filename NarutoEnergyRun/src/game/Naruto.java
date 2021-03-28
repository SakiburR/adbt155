package game;

import city.cs.engine.*;
import game.Weapons.Weapon;
import game.Weapons.Shuriken;

public class Naruto extends Walker { //main character
    private static final Shape narutoShape = new CircleShape(1.195f);

    private static final BodyImage image =
            new BodyImage("data/naruto.gif", 3.75f);


    private int ballCount;

    private Weapon[] weapons;
    private int activeWeapon;

    public Naruto(World world) {
        super(world, narutoShape);
        addImage(image);

        ballCount = 0;

        weapons = new Weapon[1];
        weapons[0] = new Shuriken(this);

    }

    public Weapon getActiveWeapon(){
        return weapons[activeWeapon];

    }

    public void setActiveWeapon(int i){
        activeWeapon = i;
    }


    public void addChakraBall() {
        ballCount++;//ball count increases when chakraballs collide with naruto
        System.out.println("Energy increased! " +
                "Energy Level = " + ballCount);
    }

    public int getBallCount() {
        return ballCount;
    }
    public void setBallCount(int bc){
        ballCount = bc;
    }
}


