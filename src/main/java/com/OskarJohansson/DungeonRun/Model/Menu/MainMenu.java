package com.OskarJohansson.DungeonRun.Model.Menu;

import com.OskarJohansson.DungeonRun.Model.Map.Map;
import com.OskarJohansson.DungeonRun.Model.Player;

import java.util.Scanner;

public class MainMenu {



    public void mainMenu(Player player, Map map) {
        boolean on = true;

        System.out.println("""
                                    
                Welcome to the Main Menu.
                                    
                #1 - Show PLAYER STATS
                #2 - show MAP
                #3 - enter SHOP
                                    
                """);
        do
            switch (new Scanner(System.in).nextInt()) {
                case 1 -> player.getStatus();
                case 2 -> map.battle(player);
                case 3 -> System.out.println("ENTER SHOP");
            } while (on);
    }
}
