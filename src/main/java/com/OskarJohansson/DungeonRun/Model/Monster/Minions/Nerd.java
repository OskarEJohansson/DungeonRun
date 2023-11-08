package com.OskarJohansson.DungeonRun.Model.Monster.Minions;

import com.OskarJohansson.DungeonRun.Control.CombatInterface;
import com.OskarJohansson.DungeonRun.Model.Monster.EnemyParentModel;

import java.util.Random;

public class Nerd extends EnemyParentModel implements CombatInterface {

    public Nerd() {
        super();
        this.setName("Nerd");
        this.setHealthPoints(7);
        this.setHealthPointsBase(7);
        this.setDamageMin(2);
        this.setDamageMax(4);
        this.setAttackCost(1);
        this.setTurningPoints(3);
        this.setTurningPointsBase(3);
        this.setExperiencePoints(5);
        this.setGold(5);
        this.setLevel(3);
    }
    @Override
    public int attack() {
        this.setTurningPoints(this.getTurningPoints() - this.getAttackCost());
        return this.getDamageMin();
    }

    @Override
    public boolean block() {
        if (new Random().nextInt(1, 10) > 7) {
            System.out.printf(">>>>    \033[0;32m%s blocked the attack successfully!\033[0m    <<<<\n", this.getName());
            return true;
        }
        System.out.printf(">>>>    \033[0;31m%s fails to block the attack\033[0m    <<<<\n", this.getName());
        return false;
    }

    @Override
    public boolean flee() {
        return true;
    }

    @Override
    public void takeDamage(Boolean takeDamage, int damage) {
        if (!takeDamage) {
            this.setHealthPoints(this.getHealthPoints() - damage);
        }
    }
}
