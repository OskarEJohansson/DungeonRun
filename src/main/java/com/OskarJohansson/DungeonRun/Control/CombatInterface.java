package com.OskarJohansson.DungeonRun.Control;

public interface CombatInterface {

    public int attack();

    boolean block();

    public boolean flee();
    public void getStatus();

    void takeDamage(Boolean takeDamage, int damage);

    public void resetTurningPoints();

    public void resetHealthPoints();
}
