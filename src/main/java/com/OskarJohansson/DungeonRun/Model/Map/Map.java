package com.OskarJohansson.DungeonRun.Model.Map;

import com.OskarJohansson.DungeonRun.Model.Monster.Monster;

import java.util.ArrayList;
import java.util.List;

public class Map {

    List<Monster> monsterList;

    public List<Monster> getMonsterList() {
        return monsterList;
    }

    public void setMonsterList(List<Monster> monsterList) {
        this.monsterList = monsterList;
    }
}
