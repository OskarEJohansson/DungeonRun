package com.OskarJohansson.DungeonRun.Model.Map;

import com.OskarJohansson.DungeonRun.Model.Monster.Minion;
import com.OskarJohansson.DungeonRun.Model.Monster.Monster;
import com.OskarJohansson.DungeonRun.Model.Monster.IcaBoss;

import java.util.ArrayList;
import java.util.List;

public class ICA extends Level {

    public ICA() {
        super();
        List<Monster> setMinionMonsterList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            setMinionMonsterList.add(new Minion());
        }
        this.setMinionMonsterList(setMinionMonsterList);
        this.setFinalBoss(new IcaBoss());
        this.setLevelNumber("1");
        this.setLevelName("Dungeon of Ica");
    }
}
