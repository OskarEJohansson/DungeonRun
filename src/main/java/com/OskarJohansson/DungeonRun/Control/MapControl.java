package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Map.ICA;
import com.OskarJohansson.DungeonRun.Model.Map.KjellCO;
import com.OskarJohansson.DungeonRun.Model.Map.Level;
import com.OskarJohansson.DungeonRun.Model.Map.Sats;

public class MapControl {

    Level currentLevel;
    ICA ica;
    Sats sats;
    KjellCO kjellCO;

    MapControl(){
        this.currentLevel = new Level();
        this.ica  = new ICA();
        this.sats = new Sats();
        this.kjellCO = new KjellCO();
    }

    public void setMap(int choice) {
        switch (choice) {
            case 1 -> {
                this.currentLevel = this.ica;
            }
            case 2 -> {
                this.currentLevel = this.sats;
            }
            case 3 -> {
                this.currentLevel = this.kjellCO;
            }
        }
    }
}