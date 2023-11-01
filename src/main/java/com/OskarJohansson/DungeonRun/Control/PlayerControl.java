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

    private String name;
    private Weapon weapon;
    private Hero hero;
    private String heroClass;
    private int strength;
    private int intelligence;
    private int agility;
    private int healthPoints = 5;
    private int healthPointsBase = 5;
    private int turningPoints = 5;
    private int turningPointsBase = 5;
    private int armour = 1;
    private int experiencePoints = 0;
    private int gold = 10;
    private int level = 1;
    private int killList = 0;
    private List<Object> stash = new ArrayList<>();

    public PlayerControl() {
        setCharacter();
        System.out.printf("You have chosen to play as a %s\n", getHeroClass());
        System.out.println("Chose a name for your Hero: ");
        setName(new Scanner(System.in).nextLine());
        System.out.printf("Welcome %s the %s ", getName(), getHeroClass());
    }

    public void setCharacter() {

        boolean on = true;
        do {
            System.out.printf("""
                              
                    ++++|                 Pick a Hero                   |++++
                    _________________________________________________________              
                    #1 - Barbarian  |   #2 - Code Monkey  |   #3 - Assassin |
                                    
                    """);

            switch (new UserInput().inputInt(new Scanner(System.in))) {
                case 1 -> {
                    this.hero = new Barbarian();
                    this.heroClass = getHero().getHeroClass();
                    this.strength += getHero().getStrength();
                    this.intelligence += getHero().getIntelligence();
                    this.armour += getHero().getArmour();
                    this.agility += getHero().getAgility();
                    this.weapon = new Sword();
                    this.healthPoints += getHero().getHealthPoints();
                    this.healthPointsBase += getHero().getHealthPoints();
                    this.turningPointsBase += getHero().getTurningPoints();
                    this.turningPoints += getHero().getTurningPoints();
                    on = false;
                }
                case 2 -> {
                    this.hero = new CodeMonkey();
                    this.heroClass = getHero().getHeroClass();
                    this.strength += getHero().getStrength();
                    this.intelligence += getHero().getIntelligence();
                    this.armour += getHero().getArmour();
                    this.agility += getHero().getAgility();
                    this.weapon = new Sword();
                    this.healthPoints += getHero().getHealthPoints();
                    this.healthPointsBase += getHero().getHealthPoints();
                    this.turningPointsBase += getHero().getTurningPoints();
                    this.turningPoints += getHero().getTurningPoints();
                    on = false;
                }
                case 3 -> {
                    this.hero = new Assassin();
                    this.heroClass = getHero().getHeroClass();
                    this.strength += getHero().getStrength();
                    this.intelligence += getHero().getIntelligence();
                    this.armour += getHero().getArmour();
                    this.agility += getHero().getAgility();
                    this.weapon = new Sword();
                    this.healthPoints += getHero().getHealthPoints();
                    this.healthPointsBase += getHero().getHealthPoints();
                    this.turningPointsBase += getHero().getTurningPoints();
                    this.turningPoints += getHero().getTurningPoints();
                    on = false;
                }
                default -> System.out.println("Input must be 1 - 3!");
            }
        } while (on);
    }

    public int getKillList() {
        return killList;
    }

    public void setKillList(int killList) {
        this.killList += killList;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hero getHero() {
        return this.hero;
    }

    public void setCharacter(int choice) {

    }

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getTurningPoints() {
        return turningPoints;
    }

    public void setTurningPoints(int turningPoints) {
        this.turningPoints = turningPoints;
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints += experiencePoints;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold += gold;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void levelUp() {
        if (this.experiencePoints > 10) {
            System.out.printf("""
                    //////////
                    Level Up!|
                    //////////
                    """);
            this.level += 1;
            this.strength += 1;
            this.intelligence += 1;
            this.agility += 1;
            this.healthPoints += 3;
            this.healthPointsBase += 3;
            this.turningPointsBase += 2;
            this.turningPoints += 2;

            this.healthPoints = this.healthPointsBase;
        }
    }

    public void getPlayerStats() {
        System.out.printf("""
                ++++|                                           Stats                                               |++++
                _________________________________________________________________________________________________________              
                Strength    %d  |   Intelligence   %d  |   Agility   %d  |   Turning Points  %d |   Health Points   %d  |
                                
                """, this.strength, this.intelligence, this.agility, this.turningPoints, this.healthPoints);

    }


    @Override
    public int attack() {
        this.turningPoints -= weapon.getTurnPoints();
        return this.weapon.getDamage();
    }

    @Override
    public boolean block() {

        if (new Random().nextInt(1, 10) < 5) {
            System.out.println(">>>>    Player blocked the attack successfully!     <<<<\n");
            return true;
        } else
            System.out.println(">>>>    Player fails to block the attack!    <<<<\n");
        return false;
    }

    @Override
    public void takeDamage(Boolean block, int damage) {
        if (!block) {
            this.healthPoints -= damage;
        }
    }

    @Override
    public void resetTurningPoints() {
        this.turningPoints = this.turningPointsBase;
    }

    @Override
    public boolean flee() {
        if (this.turningPoints > 2) {
            System.out.println("You are fleeing like a coward");
            return true;
        }
        System.out.println("You are to tired to flee!");
        return false;
    }

    @Override
    public void getStatus() {
        System.out.printf("""
                ++++|                                                       Stats                                                       |++++
                _____________________________________________________________________________________________________________________________
                %s the %s  |   Level   %d  |   Health Points   %d/%d  |   Turning Points  %d/%d  |   Experience Points   %d  |   Gold    %d |
                                
                """, this.name, this.heroClass, this.level, this.healthPoints, this.healthPointsBase, this.turningPoints, this.turningPointsBase, this.experiencePoints, this.gold);

    }

    public void addHealthPoition(HealthPotion healthPotion) {
        this.stash.add(healthPotion);
    }

    public void drinkHealthPotion() {
        this.stash.forEach(c -> {
            if(c instanceof HealthPotion && !((HealthPotion) c).isUsed()){
                this.healthPoints += ((HealthPotion) c).drinkHealthPotion();
                ((HealthPotion) c).setUsed(true);
            }
        });
    }
}
