package com.example.M4SummativeChengChienRuksarNaomi.repository;


import com.example.M4SummativeChengChienRuksarNaomi.models.Games;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameRepositoryTest {


        @Autowired
        GameRepository gameRepository;

        @Before
        public void setUp() throws Exception {

            gameRepository.deleteAll();

            gameRepository.save(new Games("2","Tasmania","The Hobart creature",BigDecimal.valueOf(6.00),"Laucenston studio",7));
            gameRepository.save(new Games("3","Perth","The Perth fish",BigDecimal.valueOf(7.00),"Naevest studio",6));
            gameRepository.save(new Games("4","Canberra","The Canberra man",BigDecimal.valueOf(8.00),"Martera studio",5));
        }

        @Test
        public void addGetDeleteGame() {

            // Need to create a Label and an Artist first

            Games game = new Games();
            game.setTitle("The Game");
            game.setDescription("This is a game");
            game.setPrice(new BigDecimal("20.00"));
            game.setStudio("game studio");
            game.setEsrbRating("not suitable");
            game.setQuantity(5);


            game = gameRepository.save(game);

            Optional<Games> game1 = gameRepository.findById(game.getId());

            assertEquals(game1.get(), game);

            gameRepository.deleteById(game.getId());

            game1 = gameRepository.findById(game.getId());

            assertFalse(game1.isPresent());

        }

        @Test
        public void addWithRefIntegrityException() {

            Games game = new Games();
            game.setQuantity(4);
            game.setDescription("This is a game");
            game.setPrice(new BigDecimal("20.00"));
            game.setStudio("game studio");
            game.setEsrbRating("not suitable");
            game.setTitle("The Game");
            game = gameRepository.save(game);

        }

        @Test
        public void getAllGames() {

            // Need to create a Label and an Artist first
            Games game = new Games();
            game.setQuantity(4);
            game.setDescription("This is a game");
            game.setPrice(new BigDecimal("20.00"));
            game.setStudio("game studio");
            game.setEsrbRating("not suitable");
            game.setTitle("The Game");

            game = gameRepository.save(game);

            Games game1 = new Games();

            game1.setQuantity(4);
            game1.setDescription("This is a game");
            game1.setPrice(new BigDecimal("10.00"));
            game1.setStudio("game studio");
            game1.setEsrbRating("not suitable");
            game1.setTitle("The Game");

            game1 = gameRepository.save(game1);

            List<Games> Games = gameRepository.findAll();

            assertEquals(5,Games.size());

        }

        @Test
        public void updateGame() {

            Games game = new Games();

            game.setQuantity(4);
            game.setDescription("This is a game");
            game.setPrice(new BigDecimal("20.00"));
            game.setStudio("game studio");
            game.setEsrbRating("not suitable");
            game.setTitle("The Game");
            game = gameRepository.save(game);

            game.setQuantity(5);
            game.setTitle("New title");
            game.setDescription("This is a new description");

            gameRepository.save(game);

            Optional<Games> game1 = gameRepository.findById(game.getId());
            assertEquals(game1.get(), game);

        }


        @Test
        public void findByStudio() {
            Games game = new Games();

            List<Games> game1 = gameRepository.findByStudio("Naevest studio");

            assertEquals(1,game1.size());
        }




    @Test
    public void findByEsrbRating() {
        Games game = new Games();
        List<Games> game1 = gameRepository.findByEsrbRating("2");

        assertEquals(1,game1.size());
    }

    @Test
    public void findByTitle() {
        Games game = new Games();

        List<Games> game1 = gameRepository.findByTitle("Tasmania");

        assertEquals(1,game1.size());
    }
}