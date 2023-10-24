package com.OskarJohansson.DungeonRun.Model;

public class Weapon {

    public static Weapon Sword;
    public static Weapon Computer;
    public static Weapon Knife;

    public static class Sword{
        private int damage = 3;
        private int turnPoints = 1;

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public int getTurnPoints() {
            return turnPoints;
        }

        public void setTurnPoints(int turnPoints) {
            this.turnPoints = turnPoints;
        }
    }
    public static class Computer{
        private int damage = 2;
        private int turnPoints = 1;

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public int getTurnPoints() {
            return turnPoints;
        }

        public void setTurnPoints(int turnPoints) {
            this.turnPoints = turnPoints;
        }
    }
    public static class Knife{
        private int damage = 1;
        private int turnPoints = 1;

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public int getTurnPoints() {
            return turnPoints;
        }

        public void setTurnPoints(int turnPoints) {
            this.turnPoints = turnPoints;
        }
    }

}
