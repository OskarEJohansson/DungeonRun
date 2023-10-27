package com.OskarJohansson.DungeonRun.Model.Map;

import com.OskarJohansson.DungeonRun.Model.Monster.Minion;
import com.OskarJohansson.DungeonRun.Model.Monster.Monster;
import com.OskarJohansson.DungeonRun.Model.Player;

import java.util.ArrayList;
import java.util.List;

public class ICA extends Map{

    List<Monster> monsterListIca;

    public ICA(){
        this.monsterListIca = new ArrayList<>();
        this.monsterListIca.add(new Minion());
    }
    public List<Monster> getMonsterListIca() {
        return monsterListIca;
    }

    public void fightMinion(Monster monster, Player player){

    }

    public void enterStageOne(Monster monster, Player player){

        System.out.println("You are being attacked by a monster!");

    }

}
