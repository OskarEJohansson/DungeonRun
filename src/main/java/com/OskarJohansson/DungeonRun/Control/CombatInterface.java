package com.OskarJohansson.DungeonRun.Control;

public interface CombatInterface {

    public int attack();
    boolean block();
    public boolean flee();
    void takeDamage(Boolean takeDamage, int damage);
    public void resetTurningPoints();
    public void resetHealthPoints();
}
