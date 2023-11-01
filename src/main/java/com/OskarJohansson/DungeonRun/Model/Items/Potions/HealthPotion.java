package com.OskarJohansson.DungeonRun.Model.Items.Potions;

public class HealthPotion {

    private int hP = 10;
    private boolean isUsed = false;

    public int drinkHealthPotion(){
        this.isUsed = true;
        return this.hP;
    }

    public int gethP() {
        return hP;
    }

    public void sethP(int hP) {
        this.hP = hP;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }
}
