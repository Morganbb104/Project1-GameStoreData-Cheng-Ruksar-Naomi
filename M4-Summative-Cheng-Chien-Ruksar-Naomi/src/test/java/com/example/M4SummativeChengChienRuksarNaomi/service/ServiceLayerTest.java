package com.example.M4SummativeChengChienRuksarNaomi.service;

import com.example.M4SummativeChengChienRuksarNaomi.models.Games;
import com.example.M4SummativeChengChienRuksarNaomi.repository.*;
import com.example.M4SummativeChengChienRuksarNaomi.viewmodel.GameViewModel;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.doReturn;


import static org.junit.Assert.*;

public class ServiceLayerTest {
    ServiceLayer serviceLayer;
    GameRepository gameRepository;
    ConsoleRepository consoleRepository;
    ProcessingFeeRepository processingFeeRepository;
    SalesTaxRateRepository salesTaxRateRepository;
    TshirtRepository tshirtRepository;
    @Before
    public void setUp() throws Exception{
        setUpGameRepositoryMock();
        Games game= new Games();

        game.setTitle("Star Wars");
        game.setPrice(50);
        game.setStudio("Lucas Films");
        game.setDescription("Its basically harry potter but in space");
        game.setQuantity(4);
        game.setEsrbRating("not suitable for children");
//        System.out.println("Game repository.save will return "+gameRepository.save(game));
   }

    @Test
    public void justRunTheTest(){
        System.out.println("placeholder");
    }

    @Test
    public void saveGame() {
    }

    @Test
    public void findGame() {
    }

    @Test
    public void findAllGames() {
        //Act
        List<GameViewModel> actualResult =serviceLayer.findAllGames();


        //Assert
        assertEquals(1,actualResult.size());
    }

    @Test
    public void updateGame() {
    }

    @Test
    public void removeGame() {
    }
    private void setUpGameRepositoryMock() {
        Games game= new Games();

        game.setTitle("Star Wars");
        game.setPrice(50);
        game.setStudio("Lucas Films");
        game.setDescription("Its basically harry potter but in space");
        game.setQuantity(4);
        game.setEsrbRating("not suitable for children");
        List<Games> games =new ArrayList<>();
        //doReturn(game).when(gameRepository).save(game);
        //doReturn(Optional.of(games)).when(gameRepository).findById(1);
        doReturn(games).when(gameRepository).findAll();
    }
}