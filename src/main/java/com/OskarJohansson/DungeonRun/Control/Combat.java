package com.OskarJohansson.DungeonRun.Control;

public interface Combat {

    public int attack();
    public int block();
    public int flee();

    public void getStatus();

    public int dodge();
}
