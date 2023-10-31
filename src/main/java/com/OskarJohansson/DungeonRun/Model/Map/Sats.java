package com.OskarJohansson.DungeonRun.Model.Map;

import com.OskarJohansson.DungeonRun.Model.Monster.*;

import java.util.ArrayList;
import java.util.List;

public class Sats extends Level{

    public Sats() {
        super();
        List<Monster> setMinionMonsterList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            setMinionMonsterList.add(new Grunt());
        }
        this.setMinionMonsterList(setMinionMonsterList);
        this.setFinalBoss(new SatsBoss());
        this.setLevelNumber("2");
        this.setLevelName("Dungeon of Sats");
    }
}
