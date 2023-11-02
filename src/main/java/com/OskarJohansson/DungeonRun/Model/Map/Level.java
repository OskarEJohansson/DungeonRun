package com.OskarJohansson.DungeonRun.Model.Map;


import com.OskarJohansson.DungeonRun.Model.Monster.EnemyParentModel;

import java.util.List;

public class Level {

    private String levelName;
    private String levelNumber;
    private List<EnemyParentModel> minionMonsterList;
    private EnemyParentModel finalBoss;

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
