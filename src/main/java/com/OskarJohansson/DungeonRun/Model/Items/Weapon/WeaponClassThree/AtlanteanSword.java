package com.OskarJohansson.DungeonRun.Model.Items.Weapon.WeaponClassThree;

import com.OskarJohansson.DungeonRun.Model.Items.Weapon.WeaponParentModel;

public class AtlanteanSword extends WeaponParentModel {

    public AtlanteanSword(){
        this.setName("Atlantean - Sword of Conan The Barbarian");
        this.setDamage(10);
        this.setTurnPoints(3);
        this.setMinimumLevel(5);
        this.setCost(50);
    }
}
