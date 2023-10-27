package com.OskarJohansson.DungeonRun.Model.Menu;

public class IcaMenu {

    public void welcome(int input){
        System.out.println("Welcome to Level 1");

        switch(input){
            case 1 -> System.out.println("");
            case 2 -> System.out.println("explainMap()");
            case 3 -> System.out.println("enterStageOne()");
            case 4 -> System.out.println("enterFinalBoss()");
            case 5 -> System.out.println("exitLevel()");
        }
    }

    public void explainLevel(){
        System.out.println("Defeat 3 minions to be able to challenge the level boss!");
    }
}
