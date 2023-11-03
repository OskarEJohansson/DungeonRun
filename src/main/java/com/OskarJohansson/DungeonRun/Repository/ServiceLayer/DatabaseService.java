package com.OskarJohansson.DungeonRun.Repository.ServiceLayer;

import com.OskarJohansson.DungeonRun.Model.Characters.Hero;
import com.OskarJohansson.DungeonRun.Repository.DataAccessLayer.PlayerRepository;

public class DatabaseService {

    private PlayerRepository.HeroRepository heroRepository;

    public Hero saveHero(Hero hero) {
        return heroRepository.save(hero);
    }

    public Hero findHeroById(Long id) {
        return heroRepository.findById(id);
    }

    public void updateHero(Hero hero) {
        heroRepository.update(hero);
    }

    public void deleteHero(Hero hero) {
        heroRepository.delete(hero);
    }
    }

