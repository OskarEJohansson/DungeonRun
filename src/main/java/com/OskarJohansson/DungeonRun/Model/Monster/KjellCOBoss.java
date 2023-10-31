package com.OskarJohansson.DungeonRun.Model.Monster;

import com.OskarJohansson.DungeonRun.Control.Combat;

import java.util.Random;

public class KjellCOBoss extends Monster implements Combat {

    public KjellCOBoss() {
        super();
        this.setName("Nerd Wizard");
        this.setHealthPoints(10);
        this.setDamage(3);
        this.setAttackCost(2);
        this.setTurningPoints(5);
        this.setTurningpointsBase(5);
        this.setExperiencePoints(5);
        this.setGold(10);
        this.setLevel(2);
        this.setArmour(3);
    }
    @Override
    public int attack() {
        this.setTurningPoints(this.getTurningPoints() - this.getAttackCost());
        return this.getDamage();
    }

    @Override
    public boolean block() {
        if (new Random().nextInt(1, 10) > 6) {
            System.out.println("Monster blocked the attack successfully!");
            return true;
        }
        System.out.println("Monster fails to block the attack\n");
        return false;
    }

    @Override
    public boolean flee() {
        return true;
    }

    @Override
    public void getStatus() {
        System.out.printf("""
                                
                Enemy   %s  |   Health Points   %d  |   Turning Points  %d
                                
                """, this.getName(), this.getHealthPoints(), this.getTurningPoints());
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
