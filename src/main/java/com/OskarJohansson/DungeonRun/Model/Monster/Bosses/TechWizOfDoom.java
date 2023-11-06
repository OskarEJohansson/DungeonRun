package com.OskarJohansson.DungeonRun.Model.Monster.Bosses;

import com.OskarJohansson.DungeonRun.Model.Monster.EnemyParentModel;

import java.util.Random;

public class TechWizOfDoom extends EnemyParentModel {

    public TechWizOfDoom() {
        super();
        this.setName("Kris The TechWiz of Doom");
        this.setHealthPoints(30);
        this.setHealthPointsBase(30);
        this.setDamage(10);
        this.setAttackCost(3);
        this.setTurningPoints(12);
        this.setTurningPointsBase(12);
        this.setExperiencePoints(100);
        this.setGold(100);
        this.setLevel(5);
    }
    @Override
    public int attack() {
        this.setTurningPoints(this.getTurningPoints() - this.getAttackCost());
        return this.getDamage();
    }

    @Override
    public boolean block() {
        if (new Random().nextInt(1, 10) > 5) {
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
    public void resetTurningPoints() {
    }
}
