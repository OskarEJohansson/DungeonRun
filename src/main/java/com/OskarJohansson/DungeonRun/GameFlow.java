package com.OskarJohansson.DungeonRun;
import com.OskarJohansson.DungeonRun.Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class GameFlow {

    List<Object> gameList = new ArrayList<>();
    Player player;
    Scanner sc = new Scanner(System.in);
    private Random random = new Random();

    public void runApp(Player player){


            System.out.println("Welcome. Set player name: ");
            player.setName(sc.nextLine());
            System.out.println("Please set game character to play. 1> Barbarian 2> Coder 3> Assassin");
            player.setCharacter(sc.nextInt());





    }


         /* ++++++++++++++++++
         //                    \\
       //       Main Menu       \\
     //                          \\
    ||      * Enter name          ||
    ||      * Enter Character     ||
    ||      * Show STATUS         ||
    ||      *                     ||
    ||                            ||
    */




    //      Show menu
    //      Set player name
    //      Choose Character
    //      Show Status
    //      Show game play informaton
            //
            // Find your way to the teacher room to fight KRILLÖÖÖ to become THE TEACHER.
            //  Battle your way through the minions the dungeon of ICA, Conquer the Giants in the mountains of SATS
            //  and defeat the wizards at Kjell CO to retain the code breaker to be able to break in to the TeachersLounge
            //  and to enter the last battle against the TechWizOfDoom KRILLÖÖÖ.
            //





}
