package com.example.M4SummativeChengChienRuksarNaomi.service;

import com.example.M4SummativeChengChienRuksarNaomi.models.Games;
import com.example.M4SummativeChengChienRuksarNaomi.repository.*;
import com.example.M4SummativeChengChienRuksarNaomi.viewmodel.GameViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;



import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {
    ServiceLayer serviceLayer;
    GameRepository gameRepository;
    ConsoleRepository consoleRepository;
    ProcessingFeeRepository processingFeeRepository;
    SalesTaxRateRepository salesTaxRateRepository;
    TshirtRepository tshirtRepository;

    InvoiceRepository invoiceRepository;
    @Before
    public void setUp() throws Exception{
        setUpGameRepositoryMock();
        setUpConsoleRepositoryMock();
        setUpTshirtRepositoryMock();
        setUpProcessingFeeRepositoryMock();
        setUpSalesTaxRateRepositoryMock();
        serviceLayer= new ServiceLayer(gameRepository, consoleRepository,
                 tshirtRepository, processingFeeRepository, salesTaxRateRepository,invoiceRepository);
        Games game= new Games();

        game.setTitle("Star Wars");
        game.setPrice(BigDecimal.valueOf(50));
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
    public void shouldSaveGame() {
        GameViewModel game =new GameViewModel();
        game.setTitle("Star Wars");
        game.setPrice(BigDecimal.valueOf(50));
        game.setStudio("Lucas Films");
        game.setDescription("Its basically harry potter but in space");
        game.setQuantity(4);
        game.setEsrbRating("not suitable for children");
        game =serviceLayer.saveGame(game);



    }

    @Test
    public void shouldFindGame() {
        GameViewModel expectedGameViewModel =new GameViewModel();
        expectedGameViewModel.setId(1);
        expectedGameViewModel.setTitle("Star Wars");
        expectedGameViewModel.setPrice(BigDecimal.valueOf(50));
        expectedGameViewModel.setStudio("Lucas Films");
        expectedGameViewModel.setDescription("Its basically harry potter but in space");
        expectedGameViewModel.setQuantity(4);
        expectedGameViewModel.setEsrbRating("not suitable for children");

     expectedGameViewModel=serviceLayer.findGame(expectedGameViewModel.getId());


    }

    @Test
    public void shouldFindAllGames() {
        //Act
        List<GameViewModel> actualResult =serviceLayer.findAllGames();


        //Assert
        assertEquals(1,actualResult.size());
    }

    @Test
    public void updateGame() {
        GameViewModel expectedGameViewModel =new GameViewModel();
        expectedGameViewModel.setId(1);
        expectedGameViewModel.setTitle("Star Wars");
        expectedGameViewModel.setPrice(BigDecimal.valueOf(50));
        expectedGameViewModel.setStudio("Lucas Films");
        expectedGameViewModel.setDescription("Its basically harry potter but in space");
        expectedGameViewModel.setQuantity(4);
        expectedGameViewModel.setEsrbRating("not suitable for children");
        expectedGameViewModel =serviceLayer.saveGame(expectedGameViewModel);

    }

    @Test
    public void removeGame() {
        GameViewModel expectedGameViewModel =new GameViewModel();
        expectedGameViewModel.setId(1);
        expectedGameViewModel.setTitle("Star Wars");
        expectedGameViewModel.setPrice(BigDecimal.valueOf(50));
        expectedGameViewModel.setStudio("Lucas Films");
        expectedGameViewModel.setDescription("Its basically harry potter but in space");
        expectedGameViewModel.setQuantity(4);
        expectedGameViewModel.setEsrbRating("not suitable for children");
        serviceLayer.removeGame(expectedGameViewModel.getId());
    }

    private void setUpGameRepositoryMock() {
        gameRepository = mock(GameRepository.class);
        Games game= new Games();

        game.setTitle("Star Wars");
        game.setPrice(BigDecimal.valueOf(50));
        game.setStudio("Lucas Films");
        game.setDescription("Its basically harry potter but in space");
        game.setQuantity(4);
        game.setEsrbRating("not suitable for children");

        Games game1= new Games();
        game1.setId(1);
        game1.setTitle("Star Wars");
        game1.setPrice(BigDecimal.valueOf(50));
        game1.setStudio("Lucas Films");
        game1.setDescription("Its basically harry potter but in space");
        game1.setQuantity(4);
        game1.setEsrbRating("not suitable for children");

        List<Games> games =new ArrayList<>();
        games.add(game1);
        doReturn(game1).when(gameRepository).save(game);
        doReturn(Optional.of(game)).when(gameRepository).findById(1);
        doReturn(games).when(gameRepository).findAll();
    }
    private void setUpConsoleRepositoryMock() {}
    private void setUpProcessingFeeRepositoryMock() {}
    private void setUpTshirtRepositoryMock() {}
    private void setUpSalesTaxRateRepositoryMock() {}


}