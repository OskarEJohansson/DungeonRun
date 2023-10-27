package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Monster.Monster;
import com.OskarJohansson.DungeonRun.Model.Player;

public class CombatControl {

    public int monsterCombatAttack(Monster monster) {
        monster.setTurningPoints(monster.getTurningPoints() - monster.getAttackCost());
        return monster.getDamage();
    }

    public boolean monsterCombatBlock(Monster monster, Randomizer randomizer){

        if (!randomizer.block(monster.getLevel(),monster.getArmour())){
            System.out.println("Monster blocked the attack successfully!");
            return true;
        }
        System.out.println("Monster blocked the attack successfully");
        return false;
    }

    public int playerCombatAttack(Player player) {
        player.setTurningPoints(player.getTurningPoints() - player.getWeapon().getWeaponTurnPoints());
        return player.attack();
    }

    public boolean playerCombatBlock(Player player, Randomizer randomizer) {

        if (randomizer.block(player.getLevel(), player.getArmour())) {
            System.out.println("Player blocked the attack successfully!");
            return true;

        } else
            System.out.println("Player unsuccessfully blocked the hit!");
        return false;
    }

    public boolean playerDodgeAttack(Monster monster, Player player, Randomizer randomizer) {

        if (!randomizer.dodge(monster.getExperiencePoints(), player.getAgility())) {
            System.out.println("Monster hits!");
            return false;
        } else
            System.out.println(player.getName() + "dodged the attack!");
        return true;
    }
}
