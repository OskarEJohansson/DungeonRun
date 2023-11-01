package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Characters.Assassin;
import com.OskarJohansson.DungeonRun.Model.Characters.Barbarian;
import com.OskarJohansson.DungeonRun.Model.Characters.CodeMonkey;
import com.OskarJohansson.DungeonRun.Model.Characters.Hero;
import com.OskarJohansson.DungeonRun.Model.Items.Potions.HealthPotion;
import com.OskarJohansson.DungeonRun.Model.Items.Weapon.Sword;
import com.OskarJohansson.DungeonRun.Model.Items.Weapon.Weapon;

import java.util.*;

public class PlayerControl implements CombatInterface {

    private Hero hero;

    public Hero getHero() {
        return hero;
    }

    public PlayerControl() {
        setCharacter();
        System.out.printf("You have chosen to play as a %s\n", this.hero.getHeroClass());
        System.out.println("Chose a name for your Hero: ");
        this.hero.setName(new Scanner(System.in).nextLine());
        System.out.printf("Welcome %s the %s ", this.hero.getName(), this.hero.getHeroClass());
    }

    public void setCharacter() {

        boolean on = true;
        do {
            System.out.printf("""
                              
                    ++++|                 Pick a Hero                   |++++
                    _________________________________________________________              
                    #1 - Barbarian  |   #2 - Code Monkey  |   #3 - Assassin |
                                    
                    """);

            switch (new UserInputControl().inputInt(new Scanner(System.in))) {
                case 1 -> {
                    this.hero = new Barbarian();
                    on = false;
                }
                case 2 -> {
                    this.hero = new CodeMonkey();
                    on = false;
                }
                case 3 -> {
                    this.hero = new Assassin();
                    on = false;
                }
                default -> System.out.println("Input must be 1 - 3!");
            }
        } while (on);
    }

    public void getPlayerStats() {
        System.out.printf("""
                ++++|                                         Stats                                              |++++
                ______________________________________________________________________________________________________             
                Level  %d   |   Experience Points   %d  |   Strength    %d  |   Intelligence   %d  |   Agility   %d  |
                                
                """, this.hero.getLevel(), this.hero.getExperiencePoints(), this.hero.getStrength(), this.hero.getIntelligence(), this.hero.getAgility());

    }

    @Override
    public int attack() {
        this.hero.setTurningPoints(this.hero.getWeapon().getTurnPoints());
        return this.hero.getWeapon().getDamage();
    }

    @Override
    public boolean block() {

        if (new Random().nextInt(1, 10) < 5) {
            System.out.println(">>>>    Player blocked the attack successfully!     <<<<\n");
            return true;
        } else
            System.out.println(">>>>    Player fails to block the attack!    <<<<\n");
        checkHealthPoints();
        return false;
    }

    @Override
    public void takeDamage(Boolean block, int damage) {
        if (!block) {
            this.hero.setHealthPoints(damage);
        }
    }

    @Override
    public void resetTurningPoints() {
        this.hero.setTurningPoints(this.hero.getTurningPointsBase());
    }

    @Override
    public boolean flee() {
        if (this.hero.getTurningPoints() > 2) {
            System.out.println("You are fleeing like a coward");
            this.hero.setTurningPoints(-2);
            return true;
        }
        System.out.println("Not enough TurningPoints, you are to tired to flee!");
        return false;
    }

    @Override
    public void getStatus() {
        System.out.printf("""
                ++++|                                                       Stats                                                       |++++
                _____________________________________________________________________________________________________________________________
                %s the %s  |   Level   %d  |   Health Points   %d/%d  |   Turning Points  %d/%d  |   Experience Points   %d  |   Gold    %d |
                                
                """, this.hero.getName(), this.hero.getHeroClass(), this.hero.getLevel(), this.hero.getHealthPoints(), this.hero.getHealthPointsBase(), this.hero.getTurningPoints(), this.hero.getTurningPointsBase(), this.hero.getExperiencePoints(), this.hero.getGold());

    }

    public void addHealthPoition(HealthPotion healthPotion) {
        this.hero.addPotionStash(healthPotion);
    }

    public void drinkHealthPotion() {
        this.hero.getPotionStash().forEach(c -> {
            if (c instanceof HealthPotion && !((HealthPotion) c).isUsed()) {
                this.hero.addHealthPoints(((HealthPotion) c).drinkHealthPotion());
                ;
                ((HealthPotion) c).setUsed(true);
            }
        });
    }

    public void checkHealthPoints() {
        if (this.hero.getHealthPoints() < 3) {
            System.out.println("You are running low in Health! Drink a potion or flee the battle!");
        }
    }

    public void isKilled() {
        if (this.hero.getHealthPoints() <= 0) {
            System.out.println("You have been killed!");
            // BUILD A REST FUNCTION THAT SENDS PLAYER BACK TO MAIN MENU AND RESTORES HEALTH OF ENEMIES FROM CURRENT ROUND!
        }
    }

    public void levelUp() {
        if (this.hero.getExperiencePoints() > 10) {

            System.out.printf("""
                    //////////
                    Level Up!|
                    //////////
                    """);

            this.hero.setLevel(1);
            this.hero.setStrength(1);
            this.hero.setIntelligence(1);
            this.hero.setAgility(1);
            this.hero.setHealthPointsBase(3);
            this.hero.setTurningPoints(2);
            this.hero.setTurningPointsBase(2);


            this.hero.setHealthPoints(this.hero.getHealthPointsBase());
        }
    }


}
