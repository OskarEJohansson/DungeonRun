package com.OskarJohansson.DungeonRun.Controll;

import com.OskarJohansson.DungeonRun.Model.Character;
import com.OskarJohansson.DungeonRun.Model.Player;
import com.OskarJohansson.DungeonRun.Model.Weapon;

import java.util.Objects;

public class PlayerControll {

    public void  setWeapon(Player player){

        if (Objects.equals(player.getCharacter(), Character.Barbarian)){
            player.setWeapon(Weapon.Sword);
        } else if (Objects.equals(player.getCharacter(), Character.Assassin)){
            player.setWeapon(Weapon.Knife);
        } else if (Objects.equals(player.getCharacter(), Character.Coder)){
            player.setWeapon(Weapon.Computer);
        }

    }
}
