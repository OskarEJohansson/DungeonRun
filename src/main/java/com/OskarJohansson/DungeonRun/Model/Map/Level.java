package com.OskarJohansson.DungeonRun.Model.Map;

import com.OskarJohansson.DungeonRun.Model.Monster.Minion;
import com.OskarJohansson.DungeonRun.Model.Monster.Monster;
import com.OskarJohansson.DungeonRun.Model.Player;

import java.util.List;

public class Level {

    List<Monster> monsterList;
    private int goldchest;
    private boolean levelCompleted;
    private Object stash;


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

    public void mapStructure(Player player) {
    }

    public void battle(Player player) {
    }
}
