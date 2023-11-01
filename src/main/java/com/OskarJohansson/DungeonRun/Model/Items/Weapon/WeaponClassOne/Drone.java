package com.OskarJohansson.DungeonRun.Model.Items.Weapon.WeaponClassOne;

import com.OskarJohansson.DungeonRun.Model.Items.Weapon.WeaponParentModel;

public class Drone extends WeaponParentModel {

    public Drone(){
        this.setName("Drone");
        this.setDamage(3);
        this.setTurnPoints(1);
        this.setMinimumLevel(1);
    }
}
