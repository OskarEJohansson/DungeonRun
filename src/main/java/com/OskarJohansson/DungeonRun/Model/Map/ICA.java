package com.OskarJohansson.DungeonRun.Model.Map;

import com.OskarJohansson.DungeonRun.Model.Monster.Minion;

import java.util.ArrayList;
import java.util.List;

public class ICA extends Level {

    private List<Minion> minionMonsterList;
    private int goldchest;
    private Object stash;
    private boolean levelCompleted;

    public ICA() {
        this.minionMonsterList = new ArrayList<>();
        this.goldchest = 10;

        for (int i = 0; i < 3; i++) {
            minionMonsterList.add(new Minion());
        }
        Minion allMonstersKilled = new Minion();
        allMonstersKilled.setAllMonstersKilled(true);
        minionMonsterList.add(allMonstersKilled);
    }

    public int getGoldchest() {
        return goldchest;
    }

    public void setGoldchest(int goldchest) {
        this.goldchest = goldchest;
    }

    public Object getStash() {
        return stash;
    }

    public void setStash(Object stash) {
        this.stash = stash;
    }

    public List<Minion> getMinionMonsterList() {
        return minionMonsterList;
    }

    public void setMinionMonsterList(List<Minion> minionMonsterList) {
        this.minionMonsterList = minionMonsterList;
    }
}
