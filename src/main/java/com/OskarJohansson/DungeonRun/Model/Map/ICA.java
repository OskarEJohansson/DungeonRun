package com.OskarJohansson.DungeonRun.Model.Map;

import com.OskarJohansson.DungeonRun.Control.CombatControl;
import com.OskarJohansson.DungeonRun.Control.Randomizer;
import com.OskarJohansson.DungeonRun.Model.Monster.Minion;
import com.OskarJohansson.DungeonRun.Model.Monster.Monster;
import com.OskarJohansson.DungeonRun.Model.Player;

import java.util.ArrayList;
import java.util.List;

public class ICA extends Map{

    List<Monster> monsterListIca;

    public ICA(){
        this.monsterListIca = new ArrayList<>();
        this.monsterListIca.add(new Minion());
    }
    public List<Monster> getMonsterListIca() {
        return monsterListIca;
    }

    public void fightMinion(Monster monster, Player player){
    }

    public void enterStageOne(CombatControl combatControl, Monster monster, Player player, Randomizer randomizer) {

        boolean activeCombat = true;

        do {
            combatControl.monsterCombatAttack(monster);
            if(!combatControl.playerDodgeAttack(monster, player, randomizer)){
                player.setHealthPoints(player.getHealthPoints() - monster.getDamage());
            }

            if (monster.getTurningPoints() > 0) {
                int damage = combatControl.monsterCombatAttack(monster);
                if (combatControl.playerCombatBlock(player, randomizer)) {
                } else player.setHealthPoints(player.getHealthPoints() - damage);
            }

            while (player.getTurningPoints() > 0) {
                int damage = combatControl.playerCombatAttack(player);

                if (combatControl.monsterCombatBlock(monster, randomizer)) {
                } else monster.setHealthPoints(monster.getHealthPoints() - damage);

                if (monster.getHealthPoints() < 1) {
                    System.out.println("You killed " + monster.getName());
                    activeCombat = false;
                }
            }

        } while (activeCombat);

    }
}
