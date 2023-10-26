package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Monster.Monster;
import com.OskarJohansson.DungeonRun.Model.Player;

import java.util.Random;

public class CombatControl {

    Random randomizer = new Random();

    public void combat(Monster monster, Player player) {

        System.out.println("You are attacked by a monster!");
    }


    public void playerAttack(Monster monster, Player player) {

        if (player.getTurningPoints() > 0) {

            int damage = player.attack();
            int turningPoints = player.getWeapon().getTurnPoints();
            player.setTurningPoints(player.getTurningPoints() - turningPoints);
            System.out.println(player.getName() + "inflicts " + damage + "health points of damage. ");
            monster.setHealthPoints(monster.getHealthPoints() - damage);

        }
    }

    public boolean dodgeRandomizer(Monster monster, Player player, Randomizer randomizer){

        int randomizer1 = randomizer.randomizer(monster.getExperiencePoints(), player.dodge());
        int randomizer2 = randomizer1 * player.getLevel();
        int randomizer3 = randomizer2/player.dodge();
        int randomizer4 = player.dodge() * player.getLevel();
        System.out.println(randomizer3);
        System.out.println(randomizer4);


        return randomizer.randomizer(monster.getExperiencePoints(), player.dodge()) * player.getLevel() / player.dodge() > player.dodge() * player.getLevel();

    }

    public boolean dodgeAttack(Monster monster, Player player, Randomizer randomizer) {

        int monsterDamage = monster.attack();

        if (dodgeRandomizer(monster, player, randomizer)) {
            player.setHealthPoints(player.getHealthPoints() - monsterDamage);
            System.out.println("Monster inflicts " + monsterDamage + "health points in damage");
            return false; //Unsuccessful  dodge

        } else
            System.out.println(player.getName() + "dodged the attack!");
        return true; //Successful dodge
    }
}
