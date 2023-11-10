package com.OskarJohansson.DungeonRun.Model.Monster.Monster;

import com.OskarJohansson.DungeonRun.Control.CombatInterface;
import com.OskarJohansson.DungeonRun.Model.Monster.EnemyParentModel;

import java.util.Random;

public class Minion extends EnemyParentModel implements CombatInterface {

    public Minion() {
        this.setName("Minion");
        this.setHealthPoints(3);
        this.setHealthPointsBase(3);
        this.setDamageMin(1);
        this.setDamageMax(2);
        this.setAttackCost(1);
        this.setTurningPoints(1);
        this.setTurningPointsBase(1);
        this.setExperiencePoints(1);
        this.setGold(1);
        this.setLevel(1);
    }


    @Override
    public boolean block() {
        if (new Random().nextInt(1, 10) > 10) {
            System.out.printf(">>>>    \033[0;32m %s blocked the attack successfully!\033[0m    <<<<\n", this.getName());
            return true;
        }
        System.out.printf(">>>>    \033[0;31m%s fails to block the attack!\033[0m    <<<<\n", this.getName());
        return false;
    }

    @Override
    public boolean flee() {
        return true;
    }
}
