package com.OskarJohansson.DungeonRun.Control;

public interface Combat {

    public int attack();

    boolean block();

    public boolean flee();
    public void getStatus();

    void takeDamage(Boolean takeDamage, int damage);

    abstract void resetTurningPoints();
}
