package com.OskarJohansson.DungeonRun.Model.Map;

import com.OskarJohansson.DungeonRun.Model.Monster.Monster;

import java.util.List;

public class Level {

    List<Monster> minionMonsterList;
    private Monster finalBoss;
    private String levelNumber;
    private String levelName;

    public List<Monster> getMinionMonsterList() {
        return minionMonsterList;
    }

    public void setMinionMonsterList(List<Monster> minionMonsterList) {
        this.minionMonsterList = minionMonsterList;
    }

    public Monster getFinalBoss() {
        return finalBoss;
    }

    public void setFinalBoss(Monster finalBoss) {
        this.finalBoss = finalBoss;
    }

    public String getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(String levelNumber) {
        this.levelNumber = levelNumber;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}
