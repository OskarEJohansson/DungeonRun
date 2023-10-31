package com.OskarJohansson.DungeonRun.Model.Monster;

import com.OskarJohansson.DungeonRun.Control.Combat;

import java.util.Random;

public class Minion extends Monster implements Combat {

    public Minion() {
        super();
        this.setName("Minion");
        this.setHealthPoints(3);
        this.setDamage(1);
        this.setAttackCost(1);
        this.setTurningPoints(1);
        this.setExperiencePoints(3);
        this.setGold(1);
        this.setLevel(1);
        this.setArmour(2);
    }
    @Override
    public int attack() {
        this.setTurningPoints(this.getTurningPoints() - this.getAttackCost());
        return this.getDamage();
    }

    @Override
    public boolean block() {
        if (new Random().nextInt(1, 2) > 10) {
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
                                
                Enemy                %s
                Health Points        %d
                Turning Points       %d
                                
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
