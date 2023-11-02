package com.OskarJohansson.DungeonRun.Model.Items.Weapon.WeaponClassTwo;

import com.OskarJohansson.DungeonRun.Model.Items.Weapon.WeaponParentModel;

public class Spot extends WeaponParentModel {

    public Spot(){
        this.setName("Spot the Killer Robot Dog");
        this.setWeaponClass("Drone");
        this.setDamage(5);
        this.setTurnPoints(2);
        this.setMinimumLevel(3);
        this.setCost(20);
    }
}
