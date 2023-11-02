package com.OskarJohansson.DungeonRun.Model.Monster.Minions;

import com.OskarJohansson.DungeonRun.Control.CombatInterface;
import com.OskarJohansson.DungeonRun.Model.Monster.EnemyParentModel;

import java.util.Random;

public class Grunt extends EnemyParentModel implements CombatInterface {

    public Grunt() {
        super();
        this.setName("Grunt");
        this.setHealthPoints(5);
        this.setHealthPointsBase(5);
        this.setDamage(2);
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
        return this.getDamage();
    }

    @Override
    public boolean block() {
        if (new Random().nextInt(1, 10) > 8) {
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

    @Override
    public void resetHealthPoints() {

    }
}
