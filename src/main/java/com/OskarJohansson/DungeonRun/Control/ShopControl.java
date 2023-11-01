package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Items.Potions.HealthPotion;

import java.util.Scanner;

public class ShopControl {


    public void shop(PlayerControl player) {

        boolean on = true;
        System.out.println("Welcome to the Shop!");

        do switch (new UserInput().inputInt(new Scanner(System.in))) {
            case 1 -> System.out.println("BUY WEAPON");
            case 2 -> System.out.println("BUY ARMOUR");
            case 3 -> System.out.println("BUY POTION");
            case 4 -> {
                System.out.println("EXIT SHOP");
                on = false;
            }
            case 5 -> System.out.println("Input must be 1-4!");
        } while (on);
    }

    public void buyPotion(PlayerControl player) {
        if (player.getGold() < 5) {
            System.out.println("You can't afford the potion. Kill more minions and collect more gold!");
        } else {
            System.out.println("You purchased a 10 hp Potion for 5 gold.");
            player.setGold(-10);
            player.buy(new HealthPotion());
        }
    }
}
