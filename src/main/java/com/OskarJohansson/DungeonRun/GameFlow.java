package com.OskarJohansson.DungeonRun;

import com.OskarJohansson.DungeonRun.Control.CombatControl;
import com.OskarJohansson.DungeonRun.Control.Randomizer;
import com.OskarJohansson.DungeonRun.Model.*;
import com.OskarJohansson.DungeonRun.Model.Monster.Minion;
import com.OskarJohansson.DungeonRun.Model.Monster.Monster;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class GameFlow {

    public static void main(String[] args) {

        List<Object> gameList = new ArrayList<>();
        CombatControl combat = new CombatControl();
        Randomizer randomizer = new Randomizer();
        Monster monster = new Minion();
        Player player1 = new Player();

        player1.setCharacter(1);
        player1.setName("Oskar");



    }


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


