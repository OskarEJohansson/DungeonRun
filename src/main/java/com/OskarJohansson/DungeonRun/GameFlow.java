package com.OskarJohansson.DungeonRun;

import com.OskarJohansson.DungeonRun.Control.CombatControl;
import com.OskarJohansson.DungeonRun.Control.Randomizer;
import com.OskarJohansson.DungeonRun.Model.*;
import com.OskarJohansson.DungeonRun.Model.Menu.MainMenu;
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
        MainMenu main = new MainMenu();

        player1.setCharacter(1);
        player1.setName("Oskar");

        main.showUniqueCharacter(player1);


    }
}
