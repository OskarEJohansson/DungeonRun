package com.OskarJohansson.DungeonRun.Model.Menu;

import com.OskarJohansson.DungeonRun.Model.Player;

import java.util.Scanner;

public class MainMenu extends Menu {

    public void welcome() {
        System.out.println("Welcome to the STI DungeonRun. Pick a Hero to fight your way to the Final Boss!");
    }

    public void heros() {
        System.out.println("""

                You can play as a Barbarian, Coder or an Assassin.
                
                Barbarian           Status
                    Strenght        5
                    Intelligence    1
                    Agility         2
                    Armour          + 2
                    HealthPoints    + 3
                    TurningPoints   + 0
                    
                Weapon              Damage
                    Sword           3       
                """);
    }

    public void pickHero(Player player) {
        boolean correctInput = true;

        if (player.getCharacter().equals(null)) {
            System.out.println("""
                    Pick Hero: 
                    1 - Barbarian
                    2 - Assassin
                    3 - Coder
                    """);

            do switch(new Scanner(System.in).nextInt()){
                case 1 -> {player.setCharacter(1);
                correctInput = true;}
                case 2 -> {player.setCharacter(2);
                    correctInput = true;}
                case 3 -> {player.setCharacter(3);
                    correctInput = true;}
                default ->
                {System.out.println("Input must be integer 1-3!");
                    correctInput = false;
                }
            }while (correctInput);
        }

        if(player.getName().equals(null)){
            System.out.println("Enter the Hero's name: ");
            player.setName(new Scanner(System.in).nextLine());
            System.out.println("Welcome to STI" + player.getName());
        }
    }
    public void showUniqueCharacter(Player player){

        System.out.println("You have created a " + player.getHeroClass() + " that is know as " + player.getName());
        System.out.printf(""" 
                Stats: 
                
                Strength            %d
                Intelligence        %d
                Agility             %d
                Armour              %d
                Health Points       %d
                Turning Points      %d
                
                """, player.getStrength(), player.getIntelligence(), player.getAgility(), player.getArmour(), player.getHealthPoints(), player.getTurningPoints());
    }
}

