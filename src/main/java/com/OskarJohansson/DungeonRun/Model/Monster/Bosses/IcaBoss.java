package com.OskarJohansson.DungeonRun.Model.Monster.Bosses;

import com.OskarJohansson.DungeonRun.Control.CombatInterface;
import com.OskarJohansson.DungeonRun.Model.Monster.EnemyParentModel;

import java.util.Random;

public class IcaBoss extends EnemyParentModel implements CombatInterface {

    public IcaBoss() {
        super();
        this.setName("The Meat Cleaver Maniac");
        this.setHealthPoints(10);
        this.setHealthPointsBase(10);
        this.setDamageMin(2);
        this.setDamageMax(3);
        this.setAttackCost(2);
        this.setTurningPoints(5);
        this.setTurningPointsBase(5);
        this.setExperiencePoints(5);
        this.setGold(10);
        this.setLevel(2);
        this.setKilled(false);
    }

    @Override
    public boolean block() {
        if (new Random().nextInt(1, 10) > 5) {
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

}
