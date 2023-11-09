package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Characters.Barbarian;
import com.OskarJohansson.DungeonRun.Model.Items.Weapon.WeaponClassTwo.TwoHandSword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;


class PlayerControlTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void attack() {
        PlayerControl player = new PlayerControl();
        player.setHero(new Barbarian());
        player.getHero().setWeapon(new TwoHandSword());

        assertThat(player.attack(player), greaterThanOrEqualTo(player.getHero().getWeapon().getDamageMin()));
        assertThat(player.attack(player), lessThanOrEqualTo(player.getHero().getWeapon().getDamageMax()));
    }


    @Test
    void block() {
    }

    @Test
    void takeDamage() {
    }

    @Test
    void flee() {
    }

    @Test
    void drinkHealthPotion() {
    }

    @Test
    void levelUp() {
    }
}