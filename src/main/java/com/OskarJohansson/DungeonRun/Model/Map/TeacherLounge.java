package com.OskarJohansson.DungeonRun.Model.Map;

import com.OskarJohansson.DungeonRun.Model.Monster.Bosses.IcaBoss;
import com.OskarJohansson.DungeonRun.Model.Monster.Bosses.KjellCOBoss;
import com.OskarJohansson.DungeonRun.Model.Monster.Bosses.SatsBoss;
import com.OskarJohansson.DungeonRun.Model.Monster.Bosses.TechWizOfDoom;
import com.OskarJohansson.DungeonRun.Model.Monster.EnemyParentModel;
import com.OskarJohansson.DungeonRun.Model.Monster.Minions.Minion;

import java.util.ArrayList;
import java.util.List;

public class TeacherLounge extends Level {

    public TeacherLounge() {

        List<EnemyParentModel> setMinionMonsterList = new ArrayList<>();
        setMinionMonsterList.add(new IcaBoss());
        setMinionMonsterList.add(new SatsBoss());
        setMinionMonsterList.add(new KjellCOBoss());
        setMinionMonsterList.add(new TechWizOfDoom());
        this.setMinionMonsterList(setMinionMonsterList);
        this.setLevelNumber("4");
        this.setLevelName("Dungeon of The Teachers Lounge");
    }
}
