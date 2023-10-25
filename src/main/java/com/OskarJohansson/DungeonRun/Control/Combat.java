package com.OskarJohansson.DungeonRun.Control;

public interface Combat {

    public int attack();
    public void block();
    public void flee();
    public void getStatus();

    public int dodge();
}
