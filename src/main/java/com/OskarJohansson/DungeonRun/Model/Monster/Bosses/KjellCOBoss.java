package com.OskarJohansson.DungeonRun.Model.Monster.Bosses;

import com.OskarJohansson.DungeonRun.Control.CombatInterface;
import com.OskarJohansson.DungeonRun.Model.Monster.EnemyParentModel;

import java.util.Random;

public class KjellCOBoss extends EnemyParentModel implements CombatInterface {

    public KjellCOBoss() {
        super();
        this.setName("Nerd Wizard");
        this.setHealthPoints(10);
        this.setHealthPointsBase(10);
        this.setDamageMin(3);
        this.setDamageMax(7);
        this.setAttackCost(2);
        this.setTurningPoints(2);
        this.setTurningPointsBase(2);
        this.setExperiencePoints(5);
        this.setGold(10);
        this.setLevel(2);
        this.setKilled(false);
    }

    @Override
    public boolean block() {
        if (new Random().nextInt(1, 10) > 6) {
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

    @Override
    public void resetTurningPoints() {
        this.setTurningPoints(this.getTurningPointsBase());
    }
}
