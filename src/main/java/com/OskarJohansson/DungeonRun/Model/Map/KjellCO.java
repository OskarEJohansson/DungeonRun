package com.OskarJohansson.DungeonRun.Model.Map;

import com.OskarJohansson.DungeonRun.Model.Monster.*;
import com.OskarJohansson.DungeonRun.Model.Monster.Bosses.KjellCOBoss;
import com.OskarJohansson.DungeonRun.Model.Monster.Minions.Nerd;

import java.util.ArrayList;
import java.util.List;

public class KjellCO extends Level {

    private String levelName;
    private String levelNumber;
    private List<EnemyParentModel> minionMonsterList;
    private EnemyParentModel finalBoss;

    public KjellCO() {
        List<EnemyParentModel> setMinionMonsterList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            setMinionMonsterList.add(new Nerd());
        }
        this.setMinionMonsterList(setMinionMonsterList);
        this.setFinalBoss(new KjellCOBoss());
        this.setLevelNumber("3");
        this.setLevelName("Dungeon of Kjell & Co");
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(String levelNumber) {
        this.levelNumber = levelNumber;
    }

    public List<EnemyParentModel> getMinionMonsterList() {
        return minionMonsterList;
    }

    public void setMinionMonsterList(List<EnemyParentModel> minionMonsterList) {
        this.minionMonsterList = minionMonsterList;
    }

    public EnemyParentModel getFinalBoss() {
        return finalBoss;
    }

    public void setFinalBoss(EnemyParentModel finalBoss) {
        this.finalBoss = finalBoss;
    }
}
