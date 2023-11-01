package com.OskarJohansson.DungeonRun.Model.Items.Weapon.WeaponClassTwo;

import com.OskarJohansson.DungeonRun.Model.Items.Weapon.WeaponParentModel;

public class TwoHandSword extends WeaponParentModel {


    public TwoHandSword(){
        this.setName("Two Handed Sword");
        this.setDamage(5);
        this.setTurnPoints(2);
        this.setMinimumLevel(3);
        this.setCost(20);
    }

}
