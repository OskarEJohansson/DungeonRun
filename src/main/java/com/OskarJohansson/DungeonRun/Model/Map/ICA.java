package com.OskarJohansson.DungeonRun.Model.Map;

import com.OskarJohansson.DungeonRun.Model.Monster.Minions.Minion;
import com.OskarJohansson.DungeonRun.Model.Monster.EnemyParentModel;
import com.OskarJohansson.DungeonRun.Model.Monster.Bosses.IcaBoss;

import java.util.ArrayList;
import java.util.List;

public class ICA extends Level {

    public ICA() {

        List<EnemyParentModel> setMinionMonsterList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            setMinionMonsterList.add(new Minion());
        }
        this.setMinionMonsterList(setMinionMonsterList);
        this.setFinalBoss(new IcaBoss());
        this.setLevelNumber("1");
        this.setLevelName("Dungeon of Ica");
    }

}
