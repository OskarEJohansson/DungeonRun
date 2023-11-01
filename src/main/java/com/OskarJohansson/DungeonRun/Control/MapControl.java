package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Map.KjellCO;
import com.OskarJohansson.DungeonRun.Model.Map.Level;
import com.OskarJohansson.DungeonRun.Model.Map.ICA;

import com.OskarJohansson.DungeonRun.Model.Map.Sats;
import com.OskarJohansson.DungeonRun.Model.Monster.EnemyParentModel;


import java.util.ArrayList;
import java.util.List;

public class MapControl {

    List<EnemyParentModel> monsterList;
    Level level;
    ICA ica;
    Sats sats;
    KjellCO kjellCo;
    EnemyParentModel boss;
    String levelName;
    String levelNumber;

    public MapControl() {
        this.monsterList = new ArrayList<>();
        this.level = new Level();
        this.ica = new ICA();
        this.sats = new Sats();
        this.kjellCo = new KjellCO();
        this.boss = new EnemyParentModel();
        this.levelName = "";
        this.levelNumber = "";
    }

    public String getLevelName() {
        return levelName;
    }

    public String getLevelNumber() {
        return levelNumber;
    }

    public void setMap(int choice) {
        switch (choice) {
            case 1 -> {
                this.level = this.ica;
                this.monsterList = this.ica.getMinionMonsterList();
                this.boss = this.ica.getFinalBoss();
                this.levelName = this.level.getLevelName();
                this.levelNumber = this.level.getLevelNumber();
            }
            case 2 -> {
                this.level = this.sats;
                this.monsterList = this.sats.getMinionMonsterList();
                this.boss = this.sats.getFinalBoss();
                this.levelName = this.level.getLevelName();
                this.levelNumber = this.level.getLevelNumber();
            }
            case 3 -> {
                this.level = this.kjellCo;
                this.monsterList = this.kjellCo.getMinionMonsterList();
                this.boss = this.kjellCo.getFinalBoss();
                this.levelName = this.level.getLevelName();
                this.levelNumber = this.level.getLevelNumber();
            }
        }
    }

    public List<EnemyParentModel> getMonsterList() {
        return monsterList;
    }

    public void setMonsterList(List<EnemyParentModel> monsterList) {
        this.monsterList = monsterList;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public ICA getIca() {
        return ica;
    }

    public void setIca(ICA ica) {
        this.ica = ica;
    }

    public Sats getSats() {
        return sats;
    }

    public void setSats(Sats sats) {
        this.sats = sats;
    }

    public KjellCO getKjellCo() {
        return kjellCo;
    }

    public void setKjellCo(KjellCO kjellCo) {
        this.kjellCo = kjellCo;
    }

    public EnemyParentModel getBoss() {
        return boss;
    }

    public void setBoss(EnemyParentModel boss) {
        this.boss = boss;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public void setLevelNumber(String levelNumber) {
        this.levelNumber = levelNumber;
    }
}