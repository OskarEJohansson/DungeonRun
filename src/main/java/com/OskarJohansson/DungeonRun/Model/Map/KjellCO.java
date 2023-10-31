package com.OskarJohansson.DungeonRun.Model.Map;

import com.OskarJohansson.DungeonRun.Model.Monster.*;

import java.util.ArrayList;
import java.util.List;

public class KjellCO extends Level{

    public KjellCO() {
        super();
        List<Monster> setMinionMonsterList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            setMinionMonsterList.add(new Nerd());
        }
        this.setMinionMonsterList(setMinionMonsterList);
        this.setFinalBoss(new KjellCOBoss());
        this.setLevelNumber("3");
        this.setLevelName("Dungeon of Kjell & Co");
    }

}
