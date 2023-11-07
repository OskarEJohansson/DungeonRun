package com.OskarJohansson.DungeonRun.Model.Items.Weapon.WeaponClassOne;

import com.OskarJohansson.DungeonRun.Model.Items.Weapon.WeaponParentModel;

public class Sword extends WeaponParentModel {


    public Sword(){
        this.setName("Sword");
        this.setDamage(1);
        this.setTurnPoints(1);
        this.setMinimumLevel(1);
        this.setSoundOfAttack("Kling kling");

    }
}
