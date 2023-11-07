package com.OskarJohansson.DungeonRun.Model.Monster.Minions;

import com.OskarJohansson.DungeonRun.Control.CombatInterface;
import com.OskarJohansson.DungeonRun.Model.Monster.EnemyParentModel;

import java.util.Random;

public class Minion extends EnemyParentModel implements CombatInterface {

    public Minion() {
        this.setName("Minion");
        this.setHealthPoints(3);
        this.setHealthPointsBase(3);
        this.setDamage(1);
        this.setAttackCost(1);
        this.setTurningPoints(1);
        this.setTurningPointsBase(1);
        this.setExperiencePoints(1);
        this.setGold(1);
        this.setLevel(1);
    }

    @Override
    public int attack() {
        this.setTurningPoints(this.getTurningPoints() - this.getAttackCost());
        return this.getDamage();
    }

    @Override
    public boolean block() {
        if (new Random().nextInt(1, 10) > 10) {
            System.out.println(">>>>    Monster blocked the attack successfully!    <<<<");
            return true;
        }
        System.out.println(">>>>    Monster fails to block the attack   <<<<");
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

    public void resetTurningPoints() {
    }
}
