package com.OskarJohansson.DungeonRun.Model.Monster.Bosses;

import com.OskarJohansson.DungeonRun.Model.Monster.EnemyParentModel;

import java.util.Random;

public class KjellCOBoss extends EnemyParentModel {

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
        this.setBlockLevel(4);
    }
}
