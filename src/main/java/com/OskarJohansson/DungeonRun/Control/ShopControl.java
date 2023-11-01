package com.OskarJohansson.DungeonRun.Control;

import java.util.Scanner;

public class ShopControl {



    public void shop(PlayerControl player){

        boolean on = true;
        System.out.println("Welcome to the Shop!");

        do switch(new Scanner(System.in).nextInt()){
            case 1 -> System.out.println("BUY WEAPON");
            case 2 -> System.out.println("BUY ARMOUR");
            case 3 -> System.out.println("BUY POTION");
            case 4 -> System.out.println("EXIT SHOP");
        }while(on);

    }

}
