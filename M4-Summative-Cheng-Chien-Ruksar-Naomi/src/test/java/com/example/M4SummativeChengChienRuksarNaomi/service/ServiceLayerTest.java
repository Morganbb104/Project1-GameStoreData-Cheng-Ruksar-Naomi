package com.example.M4SummativeChengChienRuksarNaomi.service;

import com.example.M4SummativeChengChienRuksarNaomi.models.Console;
import com.example.M4SummativeChengChienRuksarNaomi.models.Games;
import com.example.M4SummativeChengChienRuksarNaomi.models.Tshirt;
import com.example.M4SummativeChengChienRuksarNaomi.repository.*;
import com.example.M4SummativeChengChienRuksarNaomi.viewmodel.ConsoleViewModel;
import com.example.M4SummativeChengChienRuksarNaomi.viewmodel.GameViewModel;
import com.example.M4SummativeChengChienRuksarNaomi.viewmodel.TshirtViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;

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
    public void shouldUpdateGame() {
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
    public void shouldRemoveGame() {
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
    @Test
    public void shouldFindAllConsoles() {
        //Act
        List<ConsoleViewModel> actualResult =serviceLayer.findAllConsoles();


        //Assert
        assertEquals(1,actualResult.size());
    }
    @Test
    public void shouldSaveConsole() {
        ConsoleViewModel console1 =new ConsoleViewModel();
        console1.setId(1);
        console1.setManufacturer("Sony");
        console1.setPrice(BigDecimal.valueOf(10.10));
        console1.setQuantity(10);
        console1.setModel("the newest");
        console1.setProcessor("intel");
        console1.setMemoryAmount("100");
        console1 =serviceLayer.saveConsole(console1);

    }
    @Test
    public void shouldFindConsole() {
        ConsoleViewModel expectedConsoleViewModel =new ConsoleViewModel();
        expectedConsoleViewModel.setId(1);
        expectedConsoleViewModel.setManufacturer("Sony");
        expectedConsoleViewModel.setPrice(BigDecimal.valueOf(10.10));
        expectedConsoleViewModel.setQuantity(10);
        expectedConsoleViewModel.setModel("the newest");
        expectedConsoleViewModel.setProcessor("intel");
        expectedConsoleViewModel.setMemoryAmount("100");
        expectedConsoleViewModel=serviceLayer.findConsoleById(expectedConsoleViewModel.getId());


    }
    @Test
    public void shouldUpdateConsole() {
        ConsoleViewModel expectedConsoleViewModel =new ConsoleViewModel();
        expectedConsoleViewModel.setId(1);
        expectedConsoleViewModel.setManufacturer("Sony");
        expectedConsoleViewModel.setPrice(BigDecimal.valueOf(10.10));
        expectedConsoleViewModel.setQuantity(10);
        expectedConsoleViewModel.setModel("the newest");
        expectedConsoleViewModel.setProcessor("intel");
        expectedConsoleViewModel.setMemoryAmount("100");
        expectedConsoleViewModel =serviceLayer.saveConsole(expectedConsoleViewModel);

    }

    @Test
    public void shouldRemoveConsole() {
        ConsoleViewModel expectedConsoleViewModel =new ConsoleViewModel();
        expectedConsoleViewModel.setId(1);
        expectedConsoleViewModel.setManufacturer("Sony");
        expectedConsoleViewModel.setPrice(BigDecimal.valueOf(10.10));
        expectedConsoleViewModel.setQuantity(10);
        expectedConsoleViewModel.setModel("the newest");
        expectedConsoleViewModel.setProcessor("intel");
        expectedConsoleViewModel.setMemoryAmount("100");
        serviceLayer.removeGame(expectedConsoleViewModel.getId());
    }
    @Test
    public void shouldFindAllTshirts() {
        //Act
        List<TshirtViewModel> actualResult =serviceLayer.findAllTshirts();

        //Assert
        assertEquals(1,actualResult.size());
    }
    @Test
    public void shouldSaveTshirts() {
        TshirtViewModel tshirt1 =new TshirtViewModel();
        tshirt1.setId(1);
        tshirt1.setPrice(BigDecimal.valueOf(5.00));
        tshirt1.setDescription("this is a tshirt");
        tshirt1.setColor("Blue");
        tshirt1.setSize("Large");
        tshirt1.setQuantity(50);
        tshirt1 =serviceLayer.saveTshirt(tshirt1);

    }
    @Test
    public void shouldFindTshirts() {
        TshirtViewModel tshirt1 =new TshirtViewModel();
        tshirt1.setId(1);
        tshirt1.setPrice(BigDecimal.valueOf(5.00));
        tshirt1.setDescription("this is a tshirt");
        tshirt1.setColor("Blue");
        tshirt1.setSize("Large");
        tshirt1.setQuantity(50);
        tshirt1=serviceLayer.findTshirtById(tshirt1.getId());


    }
    @Test
    public void shouldUpdateTshirts() {
        TshirtViewModel tshirt1 =new TshirtViewModel();
        tshirt1.setId(1);
        tshirt1.setPrice(BigDecimal.valueOf(5.00));
        tshirt1.setDescription("this is a tshirt");
        tshirt1.setColor("Blue");
        tshirt1.setSize("Large");
        tshirt1.setQuantity(50);
        tshirt1=serviceLayer.saveTshirt(tshirt1);
    }

    @Test
    public void shouldRemoveTshirts() {
        TshirtViewModel tshirt1 =new TshirtViewModel();
        tshirt1.setId(1);
        tshirt1.setPrice(BigDecimal.valueOf(5.00));
        tshirt1.setDescription("this is a tshirt");
        tshirt1.setColor("Blue");
        tshirt1.setSize("Large");
        tshirt1.setQuantity(50);
     serviceLayer.removeTshirt(tshirt1.getId());
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

    private void setUpConsoleRepositoryMock() {
        consoleRepository = mock(ConsoleRepository.class);
        Console console= new Console();

    console.setManufacturer("Sony");
    console.setPrice(BigDecimal.valueOf(10.10));
    console.setQuantity(10);
    console.setModel("the newest");
    console.setProcessor("intel");
    console.setMemoryAmount("100");

        Console console1= new Console();
        console1.setId(1);
        console1.setManufacturer("Sony");
        console1.setPrice(BigDecimal.valueOf(10.10));
        console1.setQuantity(10);
        console1.setModel("the newest");
        console1.setProcessor("intel");
        console1.setMemoryAmount("100");



        List<Console> consoleList =new ArrayList<>();
        consoleList.add(console1);
        doReturn(console1).when(consoleRepository).save(console);
        doReturn(Optional.of(console)).when(consoleRepository).findById(1);
        doReturn(consoleList).when(consoleRepository).findAll();
    }
    private void setUpProcessingFeeRepositoryMock() {}
    private void setUpTshirtRepositoryMock() {
        tshirtRepository = mock(TshirtRepository.class);
        Tshirt tshirt= new Tshirt();
        tshirt.setPrice(BigDecimal.valueOf(5.00));
        tshirt.setDescription("this is a tshirt");
        tshirt.setColor("Blue");
        tshirt.setSize("Large");
        tshirt.setQuantity(50);

        Tshirt tshirt1= new Tshirt();
        tshirt1.setId(1);
        tshirt1.setPrice(BigDecimal.valueOf(5.00));
        tshirt1.setDescription("this is a tshirt");
        tshirt1.setColor("Blue");
        tshirt1.setSize("Large");
        tshirt1.setQuantity(50);

        List<Tshirt> tshirtList =new ArrayList<>();
        tshirtList.add(tshirt1);
        doReturn(tshirt1).when(tshirtRepository).save(tshirt1);
        doReturn(Optional.of(tshirt)).when(tshirtRepository).findById(1);
        doReturn(tshirtList).when(tshirtRepository).findAll();


    }
    private void setUpSalesTaxRateRepositoryMock() {}


}