package com.OskarJohansson.DungeonRun.Repository;

import com.OskarJohansson.DungeonRun.Control.PlayerControl;
import com.OskarJohansson.DungeonRun.Model.Characters.Hero;

import java.io.*;

public class PlayerManager implements Serializable {

    private Hero hero;

    public void characterManager(PlayerControl player) {
        this.hero = player.getHero();
    }

    public String filePath = "/Users/oskarjohansson/Projects/Java2023/JavaB/Lab/DungeonRun/save/hero.dat";

    public void saveHeroToFile(Hero hero) {
        try (FileOutputStream fileOut = new FileOutputStream(this.filePath);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(hero);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Hero loadHeroFromFile() {
        try (FileInputStream fileIn = new FileInputStream(this.filePath);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            return (Hero) objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

