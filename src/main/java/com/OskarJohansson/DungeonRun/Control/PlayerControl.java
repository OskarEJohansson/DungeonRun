package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Characters.Barbarian;
import com.OskarJohansson.DungeonRun.Model.Characters.CodeMonkey;
import com.OskarJohansson.DungeonRun.Model.Characters.Hero;
import com.OskarJohansson.DungeonRun.Model.Items.Potions.HealthPotion;

import java.util.*;

public class PlayerControl implements CombatInterface {

    private Hero hero;

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setNameAndCharacter() {
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
                              
                    ++++|                 \033[0;92m    Pick a Hero \033[0m               |++++
                    _________________________________________________________              
                          |   #1 - Barbarian  |   #2 - Code Monkey   |
                                    
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

                default -> System.out.println("Input must be 1 - 2!");
            }
        } while (on);
    }

    public void getPlayerStats() {
        System.out.printf("""
                ++++|                                         \033[0;35m    Stats   \033[0m                                        |++++
                ______________________________________________________________________________________________________             
                Level  \033[1;33m%d\033[0m   |   Experience Points   \033[1;33m%d\033[0m  |   Strength    \033[1;35m%d\033[0m  |   Intelligence   \033[1;32m%d\033[0m  |   Agility   \033[1;31m%d\033[0m  |     Weapon   \033[4;31m%s\033[0m      |
                                
                """, this.hero.getLevel(), this.hero.getExperiencePoints(), this.hero.getStrength(), this.hero.getIntelligence(), this.hero.getAgility(), this.hero.getWeapon().getName());

    }

    @Override
    public int attack() {
        this.hero.setTurningPoints(- this.hero.getWeapon().getTurnPoints());
        return this.hero.getWeapon().getDamage();
    }


    public boolean block() {

        if (new Random().nextInt(1, 10) > 3) {
            System.out.println(">>>>    \033[0;32m  Player blocked the attack successfully! \033[0m     <<<<\n");
            return true;
        } else
            System.out.println(">>>>    \033[0;31m  Player fails to block the attack!   \033[0m    <<<<\n");
        checkHealthPoints();
        return false;
    }

    @Override
    public void takeDamage(Boolean block, int damage) {
        if (!block) {
            this.hero.setHealthPoints(-damage);
            System.out.printf("Player takes %d damage!", damage);
        }
    }

    @Override
    public void resetTurningPoints() {
        this.hero.resetTurningPoints();
    }

    @Override
    public boolean flee() {
        if (this.hero.getTurningPoints() > 2) {
            System.out.println("You are fleeing like a coward");
            this.hero.setTurningPoints(-2);
            return true;
        }
        System.out.println("You are to tired to flee!");
        return false;
    }

    @Override
    public void getStatus() {
        System.out.printf("""
                ++++|                                           \033[0;35m  Stats   \033[0m                                                                |++++
                _____________________________________________________________________________________________________________________________
                %s the %s  |   Level   %d  |   Health Points   %d/%d  |   Turning Points  %d/%d  |   Experience Points   %d  |   Gold    %d |
                                
                """, this.hero.getName(), this.hero.getHeroClass(), this.hero.getLevel(), this.hero.getHealthPoints(), this.hero.getHealthPointsBase(), this.hero.getTurningPoints(), this.hero.getTurningPointsBase(), this.hero.getExperiencePoints(), this.hero.getGold());

    }

    @Override
    public void resetHealthPoints() {
        this.hero.resetHealthPoinst();
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

    public boolean checkHealthPoints() {
        if (this.hero.getHealthPoints() <= 0) {
            System.out.println("You have been killed. You dropped all your gold!");
            this.hero.resetGold();
            resetHealthPoints();
            resetTurningPoints();
            return true;
        }

        if (this.hero.getHealthPoints() <= 3) {
            System.out.println("You are running low in Health! Drink a potion or flee the battle!");
        }
        return false;
    }

    public void levelUp() {
        if (this.hero.getExperiencePoints() >= 10 && this.hero.getLevel() < 2) {
            levelUpTraits();
        }
        if (this.hero.getExperiencePoints() >= 20 && this.hero.getLevel() < 3) {
            levelUpTraits();
        }
        if (this.hero.getExperiencePoints() >= 30 && this.hero.getLevel() < 4) {
            levelUpTraits();
        }
        if (this.hero.getExperiencePoints() >= 40 && this.hero.getLevel() < 5) {
            levelUpTraits();
        }
    }

    public void levelUpTraits() {
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


        this.hero.resetHealthPoinst();

    }


}
