package com.OskarJohansson.DungeonRun.Model;

public class Weapon {

    public static Weapon Sword;
    public static Weapon Computer;
    public static Weapon Knife;

    private static class Sword{
        int damage;
        int turnPoints = -3;
    }
    private static class Computer{
        int damage;
        int turnPoints = -2;
    }
    private static class Knife{
        int damage;
        int turnPoints = -1;
    }

}
