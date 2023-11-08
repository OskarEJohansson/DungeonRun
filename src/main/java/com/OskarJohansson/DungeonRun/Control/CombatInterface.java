package com.OskarJohansson.DungeonRun.Control;

public interface CombatInterface {

    boolean block();
    public boolean flee();
    void takeDamage(Boolean takeDamage, int damage);

}
