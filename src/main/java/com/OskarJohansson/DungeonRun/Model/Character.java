package com.OskarJohansson.DungeonRun.Model;

public class Character {

    public static Character Barbarian;
    public static Character Coder;
    public static Character Assassin;

    private class Barbarian{
        int strength = 5;
        int intelligence = 1;
        int agility = 2;

        int armor = 2;
    }

    public class Coder{

        int strength = 1;
        int intelligence = 5;
        int agility = 2;

        int armor = 2;
    }

    public class Assassin{

        int strength = 1;
        int intelligence = 3;
        int agility = 5;

        int armor = 1;

    }
}
