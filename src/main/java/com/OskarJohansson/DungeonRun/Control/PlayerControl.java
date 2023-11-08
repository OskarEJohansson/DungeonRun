package com.OskarJohansson.DungeonRun.Control;

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

    @Override
    public int attack() {
        this.hero.setTurningPoints(-this.hero.getWeapon().getTurnPoints());
        return this.hero.getWeapon().getDamage();
    }

    public boolean block() {
        if (new Random().nextInt(1, 10) > 3) {
            System.out.println(">>>>    \033[0;32mPlayer blocked the attack successfully!\033[0m    <<<<\n");
            return true;
        } else
            System.out.println(">>>>    \033[0;31mPlayer fails to block the attack!\033[0m    <<<<\n");
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
    public void resetHealthPoints() {
        this.hero.resetHealthPoints();
    }
    @Override
    public void resetTurningPoints() {
        this.hero.resetTurningPoints();
    }


    public void addHealthPoition(HealthPotion healthPotion) {
        this.hero.addPotionStash(healthPotion);
    }

    public void drinkHealthPotion() {
        checkPotionList();

        if (this.hero.getPotionStash().size() == 0) {
            System.out.println("You don't have any potion to drink!");
            return;
        }

        for (HealthPotion potion : this.hero.getPotionStash()) {
            if (!potion.isUsed()) {
                if (this.hero.getHealthPoints() == this.hero.getHealthPointsBase()) {
                    System.out.println("You have maimum health points!");
                } else {
                    this.hero.addHealthPoints(potion.drinkHealthPotion());
                    potion.setUsed(true);
                    checkMaxHealthPoints();
                    System.out.printf(">>>>     You added \033[0;34m%d\033[0m Health points. You now have \033[0;34m%d/%d\033[0m health points!     <<<<", potion.gethP(), this.hero.getHealthPoints(), this.hero.getHealthPointsBase());
                    getHero().setTurningPoints(-1);
                    return;
                }
            }
        }
    }

    private void checkMaxHealthPoints() {
        if (this.hero.getHealthPoints() > this.hero.getHealthPointsBase()) {
            resetHealthPoints();
        }
    }

    public int checkPotionList() {
        Iterator<HealthPotion> iterator = this.hero.getPotionStash().iterator();

        while (iterator.hasNext()) {
            HealthPotion c = iterator.next();
            if (c.isUsed()) {
                iterator.remove();
            }
        }
        return this.hero.getPotionStash().size();
    }

    public boolean checkHealthPoints(PlayerControl player) {
        if (player.getHero().getHealthPoints() <= 0) {
            System.out.println("You have been killed. You dropped all your gold!");
            player.getHero().resetGold();
            player.getHero().resetHealthPoints();
            player.getHero().resetTurningPoints();
//            resetHealthPoints();
//            resetTurningPoints();
            player.getHero().setDeathCount(1);
            return true;
        }

        if (this.hero.getHealthPoints() <= 3) {
            System.out.println("You are running low in Health! Drink a potion or flee the battle!");
        }
        return false;
    }

    public void levelUp() {
        if (this.hero.getExperiencePoints() >= 10 * this.hero.getLevel()) {
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
        this.hero.setTurningPoints(1);
        this.hero.setTurningPointsBase(1);

        this.hero.resetHealthPoints();

    }


}
