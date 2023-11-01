package com.OskarJohansson.DungeonRun.Model.Monster.Bosses;

import com.OskarJohansson.DungeonRun.Control.CombatInterface;
import com.OskarJohansson.DungeonRun.Model.Monster.EnemyParentModel;

import java.util.Random;

public class IcaBoss extends EnemyParentModel implements CombatInterface {

    public IcaBoss() {
        super();
        this.setName("The Meat Cleaver Maniac");
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
        if (new Random().nextInt(1, 10) > 9) {
            System.out.println(">>>>    Monster blocked the attack successfully!    <<<<\n");
            return true;
        }
        System.out.println(">>>>    Monster fails to block the attack   <<<<\n");
        return false;
    }

    @Override
    public boolean flee() {
        return true;
    }

    @Override
    public void getStatus() {
        System.out.printf("""
                ++++                    Enemy Stats                     ++++
                ____________________________________________________________                
                Enemy   %s  |   Health Points   %d  |   Turning Points  %d  |
                                
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
