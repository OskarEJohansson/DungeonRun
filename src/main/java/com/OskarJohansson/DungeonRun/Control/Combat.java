package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Monster.Minion;
import com.OskarJohansson.DungeonRun.Model.Player;

public interface Combat {

    public int attack();

    boolean block();

    public boolean flee();
    public void getStatus();

    void takeDamage(Boolean takeDamage, int damage);

}
