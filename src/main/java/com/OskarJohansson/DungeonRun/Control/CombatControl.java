package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Monster.Monster;
import com.OskarJohansson.DungeonRun.Model.Player;

public class CombatControl {

    public int monsterCombatAttack(Monster monster, Player player) {
        monster.setTurningPoints(monster.getTurningPoints() - monster.getAttackCost());
        return monster.getDamage();
    }

    public boolean monsterCombatAttack(Monster monster, Randomizer randomizer){

        if (!randomizer.block(monster.getLevel(),monster.getArmour())){
            System.out.println("Monster blocked attack successfully!");
            return true;
        }
        System.out.println("Block botched");
        return false;
    }

    public void playerCombatAttack(Monster monster, Player player) {
        int damage = player.attack();
        player.setTurningPoints(player.getTurningPoints() - player.getWeapon().getWeaponTurnPoints());
        System.out.println(player.getName() + " inflicts " + damage + " in damage. ");
        monster.setHealthPoints(monster.getHealthPoints() - damage);
    }

    public boolean playerCombatBlock(Player player, Randomizer randomizer) {

        if (randomizer.block(player.getLevel(), player.getArmour())) {
            System.out.println("Player blocked attack successfully!");
            return true;

        } else
            System.out.println("Block botched!");
        return false;
    }

    public boolean playerDodgeAttack(Monster monster, Player player, Randomizer randomizer) {

        if (!randomizer.dodge(monster.getExperiencePoints(), player.getAgility())) {
            player.setHealthPoints(player.getHealthPoints() - monster.getDamage());
            System.out.println("Monster inflicts " + monster.getDamage() + " in damage");
            return false;

        } else
            System.out.println(player.getName() + "dodged the attack!");
        return true;
    }
}
