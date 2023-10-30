package com.OskarJohansson.DungeonRun.Model.Weapon;

public class Sword {

    private int damage;
    private int turnPoints;

    public Sword(){
        this.damage = 3;
        this.turnPoints = 1;

    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getTurnPoints() {
        return turnPoints;
    }

    public void setTurnPoints(int turnPoints) {
        this.turnPoints = turnPoints;
    }
}
