package com.OskarJohansson.DungeonRun.Model.Map;

import com.OskarJohansson.DungeonRun.Model.Monster.Minion;
import com.OskarJohansson.DungeonRun.Control.Player;
import com.OskarJohansson.DungeonRun.Model.Monster.Monster;

import java.util.List;

public class Level {

    List<Monster> minionMonsterList;
    private Monster finalBoss;

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

}
