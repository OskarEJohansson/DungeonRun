package com.OskarJohansson.DungeonRun.Model.Map;

import com.OskarJohansson.DungeonRun.Model.Monster.*;
import com.OskarJohansson.DungeonRun.Model.Monster.Bosses.SatsBoss;
import com.OskarJohansson.DungeonRun.Model.Monster.Minions.Grunt;

import java.util.ArrayList;
import java.util.List;

public class Sats extends Level{

    public Sats() {
        super();
        List<EnemyParentModel> setMinionMonsterList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            setMinionMonsterList.add(new Grunt());
        }
        this.setMinionMonsterList(setMinionMonsterList);
        this.setFinalBoss(new SatsBoss());
        this.setLevelNumber("2");
        this.setLevelName("Dungeon of Sats");
    }
}
