package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Items.Potions.HealthPotion;
import com.OskarJohansson.DungeonRun.Model.Items.Weapon.WeaponClassThree.AtlanteanSword;
import com.OskarJohansson.DungeonRun.Model.Items.Weapon.WeaponClassThree.PredatorDrone;
import com.OskarJohansson.DungeonRun.Model.Items.Weapon.WeaponClassTwo.Spot;
import com.OskarJohansson.DungeonRun.Model.Items.Weapon.WeaponClassTwo.TwoHandSword;
import com.OskarJohansson.DungeonRun.Model.Items.Weapon.WeaponParentModel;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ShopControl {


    public void shop(PlayerControl player) {

        boolean on = true;

        do {
            System.out.printf("""
                    Welcome to the Shop!
                                    
                    +++++|                                   Shop Menu                                  |+++++
                    ____________________________________________________________________________________________________
                    #1 - Buy Swords  |   #2 - Buy Drones  |   #3 - Buy Health Potion  |   #4 - Exit SHOP   |
                                    
                    You have %d gold
                    """, player.getHero().getGold());

            switch (new UserInputControl().inputInt(new Scanner(System.in))) {
                case 1 -> buySwords(player);
                case 2 -> buyDrone(player);
                case 3 -> buyPotion(player);
                case 4 -> {
                    System.out.println("You are leaving the Shop");
                    on = false;
                }
                case 5 -> System.out.println("Input must be 1-4!");
            }
        } while (on);
    }

    public void buyPotion(PlayerControl player) {
        if (player.getHero().getGold() < 5) {
            System.out.println("You can't afford the potion. Kill more minions and collect more gold!");
        } else {
            System.out.println("You purchased a 10 hp Potion for 5 gold.");
            player.getHero().setGold(-5);
            player.addHealthPoition(new HealthPotion());
        }
    }

    /// ADD STRENGHT REQUIERMENTS!
    public void buyWeapon(PlayerControl player, WeaponParentModel weapon){
        if(player.getHero().getLevel() < weapon.getMinimumLevel()){
            System.out.println("You need to level up to equip this weapon!");
            return;
        }
        if(player.getHero().getGold() < weapon.getCost()){
            System.out.println("You need more gold to purchase this item!");
            return;
        }
        System.out.printf("You bought %s for %d", weapon.getName(), weapon.getCost());
        player.getHero().setWeapon(weapon);
        player.getHero().setGold(-weapon.getCost());
    }

    public void buyDrone(PlayerControl player){

        boolean on = true;
        do {
            switch (new UserInputControl().inputInt(new Scanner(System.in))) {
                case 1 -> {
                    System.out.println("Buy Spot the Killer Robot Dog for 20 gold");
                    buyWeapon(player, new Spot());
                    on = false;
                }
                case 2 -> {
                    System.out.println("Buy a Predator Drone for 50 gold");
                    buyWeapon(player, new PredatorDrone());
                    on = false;
                }
                case 3 -> {
                    System.out.println("Leave Drone Menu");
                    on = false;
                }
                default -> System.out.println("Input must be 1 - 3!");
            }
        }while (on);
    }

    public void buySwords(PlayerControl player){

        boolean on = true;
        do {
            switch (new UserInputControl().inputInt(new Scanner(System.in))) {
                case 1 -> {
                    System.out.println("Buy Twohanded Sword for 20 gold");
                    buyWeapon(player, new TwoHandSword());
                    on = false;
                }
                case 2 -> {
                    System.out.println("Buy Atlantean Sword for 50 gold");
                    buyWeapon(player, new AtlanteanSword());
                    on = false;
                }
                case 3 -> {
                    System.out.println("Leave Sword Menu");
                    on = false;
                }
                default -> System.out.println("Input must be 1 - 3!");
            }
        }while (on);
    }


}


