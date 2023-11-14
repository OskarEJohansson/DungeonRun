package com.OskarJohansson.DungeonRun;

import com.OskarJohansson.DungeonRun.Control.MenuControl;

public class Main {
    public static void main(String[] args) {

        MenuControl menuControl = new MenuControl();

        menuControl.startGame(menuControl);

    }
}