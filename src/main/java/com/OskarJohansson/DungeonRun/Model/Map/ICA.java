package com.OskarJohansson.DungeonRun.Model.Map;

import com.OskarJohansson.DungeonRun.Model.Monster.Minion;
import com.OskarJohansson.DungeonRun.Model.Monster.Monster;

import java.util.ArrayList;
import java.util.List;

public class ICA extends Level {

    private List<Monster> monsterList;
    private int goldchest;
    private Object stash;
    private boolean levelCompleted;

    public ICA() {
        this.monsterList = new ArrayList<>();
        this.goldchest = 10;

        for (int i = 0; i < 3; i++) {
            monsterList.add(new Minion());
        }
        Minion allMonstersKilled = new Minion();
        allMonstersKilled.setAllMonstersKilled(true);
        monsterList.add(allMonstersKilled);
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

    public List<Monster> getMonsterList() {
        return monsterList;
    }

    public void setMonsterList(List<Monster> monsterList) {
        this.monsterList = monsterList;
    }
}
