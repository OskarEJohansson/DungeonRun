package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Characters.Hero;
import com.OskarJohansson.DungeonRun.Model.Items.Potions.HealthPotion;

import javax.swing.*;
import java.util.*;

public class PlayerControl {

    private Hero hero;

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public int attack(PlayerControl player) {
        player.getHero().setTurningPoints(-player.getHero().getWeapon().getTurnPoints());
        return player.getHero().getWeapon().getDamage();
    }

    public boolean block() {
        if (new Random().nextInt(1, 10) > 5) {
            System.out.println(">>>>    \033[0;32mPlayer blocked the attack successfully!\033[0m    <<<<\n");
            return true;
        } else
            System.out.println(">>>>    \033[0;31mPlayer fails to block the attack!\033[0m    <<<<\n");
        return false;
    }

    public void takeDamage(PlayerControl player, Boolean block, int damage) {
        if (!block) {
            player.getHero().setHealthPoints(-damage);
            System.out.printf("Player takes %d damage!", damage);
        }
    }

    public boolean flee(PlayerControl player) {
        if (player.getHero().getTurningPoints() > 2) {
            System.out.println("You are fleeing like a coward");
            player.getHero().setTurningPoints(-2);
            return true;
        }
        System.out.println("You are to tired to flee!");
        return false;
    }


    public void addHealthPoition(PlayerControl player, HealthPotion healthPotion) {
        player.getHero().addPotionStash(healthPotion);
    }

    public void drinkHealthPotion(PlayerControl player) {
        checkPotionList();

        if (player.getHero().getPotionStash().size() == 0) {
            System.out.println("You don't have any potion to drink!");
            return;
        }

        for (HealthPotion potion : player.getHero().getPotionStash()) {
            if (!potion.isUsed()) {
                if (player.getHero().getHealthPoints() == player.getHero().getHealthPointsBase()) {
                    System.out.println("You have maimum health points!");
                } else {
                    player.getHero().addHealthPoints(potion.drinkHealthPotion());
                    potion.setUsed(true);
                    checkMaxHealthPoints(player);
                    System.out.printf(">>>>     You added \033[0;34m%d\033[0m Health points. You now have \033[0;34m%d/%d\033[0m health points!     <<<<", potion.gethP(), player.getHero().getHealthPoints(), player.getHero().getHealthPointsBase());
                    getHero().setTurningPoints(-1);
                    return;
                }
            }
        }
    }

    private void checkMaxHealthPoints(PlayerControl player) {
        if (player.getHero().getHealthPoints() > this.hero.getHealthPointsBase()) {
            player.getHero().resetHealthPoints();
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
            player.getHero().setDeathCount(1);
            return true;
        }

        if (player.getHero().getHealthPoints() <= 3) {
            System.out.println("You are running low in Health! Drink a potion or flee the battle!");
        }
        return false;
    }

    public void levelUp(PlayerControl player) {
        if (player.getHero().getExperiencePoints() >= 10 * this.hero.getLevel()) {
            levelUpTraits(player);
        }
    }

    public void levelUpTraits(PlayerControl player) {
        System.out.printf("""
                //////////
                Level Up!|
                //////////
                """);

        player.getHero().setLevel(1);
        player.getHero().setStrength(1);
        player.getHero().setIntelligence(1);
        player.getHero().setAgility(1);
        player.getHero().setHealthPointsBase(3);
        player.getHero().setTurningPoints(1);
        player.getHero().setTurningPointsBase(1);

        player.getHero().resetHealthPoints();

    }


}
