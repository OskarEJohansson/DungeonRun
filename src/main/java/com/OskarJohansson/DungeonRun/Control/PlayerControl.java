package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Characters.Hero;
import com.OskarJohansson.DungeonRun.Model.Items.Potions.HealthPotion;

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
        return new Random().nextInt(getHero().getWeapon().getDamageMin(), getHero().getWeapon().getDamageMax() + 1);
    }

    public boolean block(PlayerControl player) {
        if (new Random().nextInt(1, 10) > 5) {
            System.out.printf(">>>>    \033[0;32m%s blocked the attack successfully!\033[0m    <<<<\n", player.getHero().getName());
            return true;
        } else
            System.out.printf(">>>>    \033[0;31m%s fails to block the attack!\033[0m    <<<<\n", player.getHero().getName());
        return false;
    }

    public int takeDamage(PlayerControl player, Boolean block, int damage) {
        if (!block) {
            player.getHero().setHealthPoints(-damage);
            System.out.printf(">>>>     %s takes \033[0;31m%d\033[0m damage    <<<<!\n", player.getHero().getName(), damage);
            return player.getHero().getHealthPoints();
        }
        return player.getHero().getHealthPoints();
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


    public void addHealthPotionToStash(PlayerControl player, HealthPotion healthPotion) {
        player.getHero().addPotionStash(healthPotion);
    }

    public boolean drinkHealthPotionOptions(PlayerControl player) {

        removeUsedPotionsFromPotionStash(player);

        if (playerHasNoHealthPotions(player)) {
            return false;
        }
        if (iterateThroughHealthPotionStash(player)) {
            return true;
        }

        return false;
    }

    public boolean iterateThroughHealthPotionStash(PlayerControl player) {
        for (HealthPotion potion : player.getHero().getPotionStash()) {
            if (!potion.isUsed()) {
                drinkHealtPotion(player, potion);
                return true;
            }
        }
        return false;
    }

    public boolean playerHasNoHealthPotions(PlayerControl player) {
        if (player.getHero().getPotionStash().size() == 0) {
            System.out.println("You don't have any potion to drink!");
            return true;
        }
        return false;
    }

    public boolean playerHasMaxHealthPoints(PlayerControl player) {
        if (player.getHero().getHealthPoints() == player.getHero().getHealthPointsBase()) {
            System.out.println("You already have maimum health points!");
            return true;
        }
        return false;
    }

    public boolean drinkHealtPotion(PlayerControl player, HealthPotion potion) {

        if (playerHasMaxHealthPoints(player)) {
            return false;
        }
        player.getHero().addHealthPoints(potion.useHealthPotion());
        potion.setUsed(true);
        isMaxHealthPointsExceeded(player);
        System.out.printf(">>>>     You added \033[0;34m%d\033[0m Health points. You now have \033[0;34m%d/%d\033[0m health points!     <<<<", potion.gethP(), player.getHero().getHealthPoints(), player.getHero().getHealthPointsBase());
        getHero().setTurningPoints(-1);
        return true;
    }


    private boolean isMaxHealthPointsExceeded(PlayerControl player) {
        if (player.getHero().getHealthPoints() > player.getHero().getHealthPointsBase()) {
            player.getHero().resetHealthPoints();
            return true;
        }
        return false;
    }

    public int removeUsedPotionsFromPotionStash(PlayerControl player) {
        player.getHero().getPotionStash().removeIf(c -> c.isUsed());
        return getHero().getPotionStash().size();
    }

    public boolean isPlayerKilledInCombat(PlayerControl player) {
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

    public boolean levelUp(PlayerControl player) {
        if (player.getHero().getExperiencePoints() >= 10 * this.hero.getLevel()) {
            levelUpTraits(player);
            return true;
        }
        return false;
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
