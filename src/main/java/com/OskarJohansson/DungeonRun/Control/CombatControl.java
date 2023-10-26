package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Monster.Monster;
import com.OskarJohansson.DungeonRun.Model.Player;

import java.util.Random;

public class CombatControl {

    Random randomizer = new Random();

    public void combat(Monster monster, Player player) {
        System.out.println("You are attacked by a monster!");
    }

    public void monsterCombatTurn(Monster monster, Player player) {
        int damage = monster.attack();
        monster.setTurningPoints(monster.getTurningPoints() - monster.getAttackCost());
        System.out.println(monster.getName() + "inflicts " + damage + "in damage. ");
        monster.setHealthPoints(monster.getHealthPoints() - damage);
    }
    
    public void playerCombatBlock(Player player){
        int armour = player.getArmour();
    }

    public void playerCombatTurn(Monster monster, Player player) {
            int damage = player.attack();

            player.setTurningPoints(player.getTurningPoints() - player.getWeapon().getWeaponTurnPoints());

            System.out.println(player.getName() + " inflicts " + damage + " in damage. ");

            monster.setHealthPoints(monster.getHealthPoints() - damage);
    }

    // TAKES PLAYERS LEVEL AS MIN NUMBER AND PLAYERS AGILITY AS MAX NUMBER TO GET A RANDOM NUMBER. IF ABOVE AGILITY/2 DODGE IS SUCCSESSFULL
    public boolean dodgeRandomizer(Monster monster, Player player, Randomizer randomizer){
        return (randomizer.randomizer(player.getLevel(), player.getAgility()) < player.getAgility()/2);
    }

    public boolean playerDodgeAttack(Monster monster, Player player, Randomizer randomizer) {

        int monsterDamage = monster.attack();

        if (!dodgeRandomizer(monster, player, randomizer)) {
            player.setHealthPoints(player.getHealthPoints() - monsterDamage);
            System.out.println("Monster inflicts " + monsterDamage + " in damage");
            return false; //Unsuccessful  dodge

        } else
            System.out.println(player.getName() + "dodged the attack!");
        return true; //Successful dodge
    }


}
