package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Characters.Barbarian;
import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;

public class PlayerControlTest extends TestCase {


    @Test
    public void testCheckHealthPoints() {
        PlayerControl player = new PlayerControl();
        player.setHero(new Barbarian());
        player.getHero().setHealthPoints(0);

        assertEquals(player.checkHealthPoints(), true);

        player.resetHealthPoints();
        assertEquals(player.checkHealthPoints(), false);

        //Display running low in HP
        player.getHero().setHealthPoints(3);
        assertEquals(player.checkHealthPoints(), false);
    }

    public void testTestBlock() {
        PlayerControl player = new PlayerControl();
        player.setHero(new Barbarian());
    }

    public void testTestTakeDamage() {
    }

    public void testTestFlee() {
    }
}