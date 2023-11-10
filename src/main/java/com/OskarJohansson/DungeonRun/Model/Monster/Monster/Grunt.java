package com.OskarJohansson.DungeonRun.Model.Monster.Monster;

import com.OskarJohansson.DungeonRun.Control.CombatInterface;
import com.OskarJohansson.DungeonRun.Model.Monster.EnemyParentModel;

import java.util.Random;

public class Grunt extends EnemyParentModel implements CombatInterface {

    public Grunt() {
        super();
        this.setName("Grunt");
        this.setHealthPoints(5);
        this.setHealthPointsBase(5);
        this.setDamageMin(1);
        this.setDamageMax(3);
        this.setAttackCost(1);
        this.setTurningPoints(2);
        this.setTurningPointsBase(2);
        this.setExperiencePoints(5);
        this.setGold(3);
        this.setLevel(2);
    }
    @Override
    public int attack() {
        this.setTurningPoints(this.getTurningPoints() - this.getAttackCost());
        return this.getDamageMin();
    }

    @Override
    public boolean block() {
        if (new Random().nextInt(1, 10) > 8) {
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