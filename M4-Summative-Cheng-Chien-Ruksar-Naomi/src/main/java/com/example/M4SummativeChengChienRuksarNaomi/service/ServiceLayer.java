package com.example.M4SummativeChengChienRuksarNaomi.service;


import com.example.M4SummativeChengChienRuksarNaomi.models.*;

import com.example.M4SummativeChengChienRuksarNaomi.models.Console;
import com.example.M4SummativeChengChienRuksarNaomi.models.Games;
import com.example.M4SummativeChengChienRuksarNaomi.models.Invoice;
import com.example.M4SummativeChengChienRuksarNaomi.models.ProcessingFee;
import com.example.M4SummativeChengChienRuksarNaomi.models.SalesTaxRate;

import com.example.M4SummativeChengChienRuksarNaomi.repository.*;
import com.example.M4SummativeChengChienRuksarNaomi.viewmodel.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.NoTransactionException;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ServiceLayer {

    private GameRepository gameRepository;

    private ConsoleRepository consoleRepository;

    private TshirtRepository tshirtRepository;

    private ProcessingFeeRepository processingFeeRepository;

    private SalesTaxRateRepository salesTaxRateRepository;

    private InvoiceRepository invoiceRepository;


    @Autowired
    public ServiceLayer(GameRepository gameRepository, ConsoleRepository consoleRepository,
                        TshirtRepository tshirtRepository, ProcessingFeeRepository processingFeeRepository, SalesTaxRateRepository salesTaxRateRepository, InvoiceRepository invoiceRepository) {
        this.gameRepository = gameRepository;
        this.consoleRepository = consoleRepository;
        this.tshirtRepository = tshirtRepository;
        this.processingFeeRepository = processingFeeRepository;
        this.salesTaxRateRepository = salesTaxRateRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @Transactional
    public GameViewModel saveGame(GameViewModel viewModel) {

        // Persist Games
        Games game = new Games();
        game.setTitle(viewModel.getTitle());

        game.setPrice(viewModel.getPrice());
        game.setQuantity(viewModel.getQuantity());
        game.setDescription(viewModel.getDescription());
        game.setEsrbRating(viewModel.getEsrbRating());
        game.setStudio(viewModel.getStudio());

        game = gameRepository.save(game);
        viewModel.setId(game.getId());

        return viewModel;
    }

    public GameViewModel findGame(Integer id) {

        // Get the Game object first
        Optional<Games> game = gameRepository.findById(id);

        return game.isPresent() ? buildGameViewModel(game.get()) : null;
    }

    public List<GameViewModel> findGameByTitle(String title) {
//
        List<Games> gamesList = gameRepository.findByStudio(title);
        List<GameViewModel> games = new ArrayList<>();
        //test the list if its null then pass it to build tshirt view model and retrun list of tshirt view models
        for (int i = 0; i < gamesList.size(); i++) {
            if (games != null) {
                games.add(buildGameViewModel(gamesList.get(i)));
            }
        }
        return games;

    }

    public List<GameViewModel> findGameByStudio(String studio) {
        List<Games> gamesList = gameRepository.findByStudio(studio);
        List<GameViewModel> games = new ArrayList<>();
        //test the list if its null then pass it to build tshirt view model and retrun list of tshirt view models
        for (int i = 0; i < gamesList.size(); i++) {
            if (games != null) {
                games.add(buildGameViewModel(gamesList.get(i)));
            }
        }
        return games;
    }

    public List<GameViewModel> findGameByEsrbRating(String esrbRating) {
//
        List<Games> gamesList = gameRepository.findByStudio(esrbRating);
        List<GameViewModel> games = new ArrayList<>();
        //test the list if its null then pass it to build tshirt view model and retrun list of tshirt view models
        for (int i = 0; i < gamesList.size(); i++) {
            if (games != null) {
                games.add(buildGameViewModel(gamesList.get(i)));
            }
        }
        return games;

    }


    private GameViewModel buildGameViewModel(Games game) {

        // Get the associated Game
        // Optional<Game> game = gameRepository.findById(game.getId());

        // Assemble the GameViewModel
        GameViewModel gvm = new GameViewModel();
        gvm.setId(game.getId());
        gvm.setTitle(game.getTitle());
        gvm.setDescription(game.getDescription());
        gvm.setPrice(game.getPrice());
        gvm.setEsrbRating(game.getEsrbRating());
        gvm.setQuantity(game.getQuantity());
        gvm.setStudio(game.getStudio());


        // Return the GameViewModel
        return gvm;
    }

    public List<GameViewModel> findAllGames() {

        List<Games> gamesList = gameRepository.findAll();

        List<GameViewModel> gvmList = new ArrayList<>();

        for (Games game : gamesList) {
            GameViewModel gvm = buildGameViewModel(game);
            gvmList.add(gvm);
        }

        return gvmList;
    }

    @Transactional
    public void updateGame(GameViewModel viewModel) {

        // Update the game information
        Games game = new Games();
        game.setId(viewModel.getId());
        game.setTitle(viewModel.getTitle());
        game.setPrice(viewModel.getPrice());
        game.setStudio(viewModel.getStudio());
        game.setDescription(viewModel.getDescription());
        game.setQuantity(viewModel.getQuantity());
        game.setEsrbRating(viewModel.getEsrbRating());


        gameRepository.save(game);

    }

    @Transactional
    public void removeGame(int id) {


        // Remove game
        gameRepository.deleteById(id);

    }

    @Transactional
    public InvoiceViewModel saveInvoice(InvoiceViewModel viewModel) {

        // Persist invoice
        Invoice invoice = new Invoice();
//        invoice.setId(viewModel.getId());

        invoice.setName(viewModel.getName());
        invoice.setStreet(viewModel.getStreet());
        invoice.setCity(viewModel.getCity());
        invoice.setState(viewModel.getState());
        invoice.setZipcode(viewModel.getZipcode());
        invoice.setItemType(viewModel.getItemType());
        invoice.setItemId(viewModel.getItemId());
        invoice.setUnitPrice(viewModel.getUnitPrice());
        invoice.setQuantity(viewModel.getQuantity());
//        invoice.setSubtotal(viewModel.getSubtotal());// Don't exist
//        invoice.setTax(viewModel.getTax());// Don't exist
//        invoice.setProcessingFee(viewModel.getProcessingFee());// Don't exist
//        invoice.setTotal(viewModel.getTotal());

        invoice = invoiceRepository.save(invoice);
        viewModel.setId(invoice.getId());


        // Order quantity must be greater than zero.
        if (invoice.getQuantity() == 0) {
            throw new IllegalArgumentException("Your Quantity can not be null");
        }

        //getting state
//        if(invoice.getState().equals(invoice.getState(viewModel.getState(String )))){}

        //Order quantity must be less than or equal to the number of items available in inventory.
        if (invoice.getItemType().equals("game")) {
            if (invoice.getQuantity() <= findGame(invoice.getItemId()).getQuantity()) {
                GameViewModel game = findGame(invoice.getItemId());// got game items' ID
                game.setQuantity(game.getQuantity() - invoice.getQuantity());// checking the supply for invoice
                invoice.setUnitPrice(game.getPrice());//setting unit price from game
                invoice.setUnitPrice(invoice.getUnitPrice());// setting the unit price by getting the unit price from invoice

            } else {// go this way if there's no enough items for invoice
                throw new NoTransactionException("There are not enough game items for your order");
            }
        } else if (invoice.getItemType().equals("console")) {
            if (invoice.getQuantity() <= findConsoleById(invoice.getItemId()).getQuantity()) {
                ConsoleViewModel console = findConsoleById(invoice.getItemId());
                // checking the supply for invoice
                console.setQuantity(console.getQuantity() - invoice.getQuantity());
                //set price
                invoice.setUnitPrice(console.getPrice());
                invoice.setUnitPrice(invoice.getUnitPrice());
            } else {
                throw new NoTransactionException("There are not enough game items for your order");
            }
        } else if (invoice.getItemType().equals("tshirt")) {
            if (invoice.getQuantity() <= findTshirtById(invoice.getItemId()).getQuantity()) {
                TshirtViewModel tshirt = findTshirtById(invoice.getItemId());
                // checking the supply for invoice
                tshirt.setQuantity(tshirt.getQuantity() - invoice.getQuantity());
                //set price
                invoice.setUnitPrice(tshirt.getPrice());
                invoice.setUnitPrice(invoice.getUnitPrice());
            } else {
                throw new NoTransactionException("There are not enough tshirt items for your order");
            }


        } else {
            throw new IllegalArgumentException("no matching product type includes 'game' 'console' 'tshirt' ");
        }




//The processing fee is applied only once per order, regardless of the number of items in the order, unless the number of items in the order is greater than 10, in which case an additional processing fee of $15.49 is applied to the order.
//The order must contain a valid state code.
//The order-processing logic must properly update the quantity available for the item in the order
//Sales tax applies only to the cost of the items.

    //get Quantity
    //check the itemType,


    //Use a method
    //check the itemType,
    //check the UnitPrice,
    //check enough Quantity form database,
//    public void subTotal(){
//
//            //if ()
//
//    }
}

    public InvoiceViewModel findInvoice(Integer id) {

        // Get the invoice object first
        Optional<Invoice> invoice = invoiceRepository.findById(id);

        return invoice.isPresent() ? buildInvoiceViewModel(invoice.get()) : null;
    }

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {

        // Get the associated invoice
        // Optional<SalesTaxRate> salesTax = salesTaxRateRepository.findById(game.getId());

        // Assemble the InvoiceViewModel
        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setId(invoice.getId());
        ivm.setName(invoice.getName());
        ivm.setStreet(invoice.getStreet());
        ivm.setCity(invoice.getCity());
        ivm.setState(invoice.getState());
        ivm.setZipcode(invoice.getZipcode());
        ivm.setItemId(invoice.getItemId());
        ivm.setUnitPrice(invoice.getUnitPrice());
        ivm.setQuantity(invoice.getQuantity());
        ivm.setSubtotal(invoice.getSubtotal());
        ivm.setTax(invoice.getTax());
        ivm.setProcessingFee(invoice.getProcessingFee());
        ivm.setTotal(invoice.getTotal());

        // Return the AlbumViewModel
        return ivm;
    }

    public List<InvoiceViewModel> findAllInvoice() {

        List<Invoice> invoiceList = invoiceRepository.findAll();

        List<InvoiceViewModel> ivmList = new ArrayList<>();

        for (Invoice invoice : invoiceList) {
            InvoiceViewModel ivm = buildInvoiceViewModel(invoice);
            ivmList.add(ivm);
        }

        return ivmList;
    }

    @Transactional
    public void updateInvoice(InvoiceViewModel viewModel) {

        // Update the album information
        Invoice invoice= new Invoice();
        invoice.setId(viewModel.getId());
        invoice.setName(viewModel.getName());
        invoice.setStreet(viewModel.getStreet());
        invoice.setCity(viewModel.getCity());
        invoice.setState(viewModel.getState());
        invoice.setZipcode(viewModel.getZipcode());
        invoice.setItemId(viewModel.getItemId());
        invoice.setUnitPrice(viewModel.getUnitPrice());
        invoice.setQuantity(viewModel.getQuantity());
        invoice.setSubtotal(viewModel.getSubtotal());
        invoice.setTax(viewModel.getTax());
        invoice.setProcessingFee(viewModel.getProcessingFee());
        invoice.setTotal(viewModel.getTotal());


        invoiceRepository.save(invoice);

    }

    @Transactional
    public void removeInvoice(int id) {


        // Remove invoice
        invoiceRepository.deleteById(id);

    }

    //Create Operation For Processing Fee//Create Operation For Processing Fee



    // Console service layer


    @Transactional
    public ConsoleViewModel saveConsole(ConsoleViewModel viewModel){
        Console console = new Console();
        console.setManufacturer(viewModel.getManufacturer());
        console.setModel(viewModel.getModel());
        console.setMemoryAmount(viewModel.getMemoryAmount());
        console.setProcessor(viewModel.getProcessor());
        console.setPrice(viewModel.getPrice());
        console.setQuantity(viewModel.getQuantity());

        console=consoleRepository.save(console);

        viewModel.setId(console.getConsoleId());



        return viewModel;



    }

    public ConsoleViewModel findConsoleById(int id) {

        Optional<Console> console = consoleRepository.findById(id);

        return console.isPresent() ? buildConsoleViewModel(console.get()) : null;
    }
    public List<ConsoleViewModel> findConsoleByManufacturer(String manufacturer) {
        List<Console> consoleList = consoleRepository.findByManufacturer(manufacturer);
        List<ConsoleViewModel> consoles= new ArrayList<>();
        //test the list if its null then pass it to build tshirt view model and retrun list of tshirt view models
        for(int i = 0;i<consoleList.size(); i++){
            if(consoles!=null){
                consoles.add(buildConsoleViewModel(consoleList.get(i)));
            }
        }
        return consoles;
    }

    private ConsoleViewModel buildConsoleViewModel(Console console) {


        Optional<Games> game = gameRepository.findById(console.getConsoleId());


        ConsoleViewModel consoleView = new ConsoleViewModel();
        consoleView.setId(console.getConsoleId());
        consoleView.setModel(console.getModel());
        consoleView.setManufacturer(console.getManufacturer());
        consoleView.setMemoryAmount(console.getMemoryAmount());
        consoleView.setProcessor(console.getProcessor());
        consoleView.setPrice(console.getPrice());
        consoleView.setQuantity(console.getQuantity());


        return consoleView;

    }


    public List<ConsoleViewModel> findAllConsoles() {

        List<Console> consoleList = consoleRepository.findAll();

        List<ConsoleViewModel> cvmList = new ArrayList<>();

        for (Console console : consoleList) {
            ConsoleViewModel cvm = buildConsoleViewModel(console);
            cvmList.add(cvm);
        }

        return cvmList;
    }


    @Transactional
    public void updateConsole(ConsoleViewModel viewModel) {



        Console console = new Console();
        console.setManufacturer(viewModel.getManufacturer());
        console.setModel(viewModel.getModel());
        console.setMemoryAmount(viewModel.getMemoryAmount());
        console.setProcessor(viewModel.getProcessor());
        console.setPrice(viewModel.getPrice());
        console.setQuantity(viewModel.getQuantity());
        consoleRepository.save(console);


    }

    @Transactional
    public void removeConsole(int id) {


        consoleRepository.deleteById(id);

    }

    //T-shirt service layer

    @Transactional
    public TshirtViewModel saveTshirt(TshirtViewModel viewModel){
        Tshirt tshirt = new Tshirt();
        tshirt.setId(viewModel.getId());
        tshirt.setColor(viewModel.getColor());
        tshirt.setSize(viewModel.getSize());
        tshirt.setPrice(viewModel.getPrice());
        tshirt.setQuantity(viewModel.getQuantity());
        tshirt.setDescription(viewModel.getDescription());
        BigDecimal priceFormatter = tshirt.getPrice().setScale(2, BigDecimal.ROUND_HALF_UP);
        tshirt.setPrice(priceFormatter);
        tshirt = tshirtRepository.save(tshirt);

        viewModel.setId(tshirt.getId());



        return viewModel;



    }

    public TshirtViewModel findTshirtById(int id) {

        Optional<Tshirt> tshirt = tshirtRepository.findById(id);

        return tshirt.isPresent() ? buildTshirtViewModel(tshirt.get()) : null ;
        //buildTshirtViewModel(tshirt.get()) : null;
    }
    public List<TshirtViewModel> findTshirtBySize(String size) {
//            List<Tshirt> tshirts = tshirtRepository.findAll();
       List<Tshirt> tshirtList = tshirtRepository.findBySize(size);
        List<TshirtViewModel> tshirts= new ArrayList<>();
       //test the list if its null then pass it to build tshirt view model and retrun list of tshirt view models

        for(int i = 0;i<tshirtList.size(); i++){
            if(tshirts!=null){
                tshirts.add(buildTshirtViewModel(tshirtList.get(i)));
            }

        }
        return tshirts;
        //buildTshirtViewModel(tshirt.get()) : null;
    }
    public List<TshirtViewModel> findTshirtByColor(String color) {
//            List<Tshirt> tshirts = tshirtRepository.findAll();
        List<Tshirt> tshirtList = tshirtRepository.findByColor(color);
        List<TshirtViewModel> tshirts= new ArrayList<>();
        //test the list if its null then pass it to build tshirt view model and retrun list of tshirt view models
        for(int i = 0;i<tshirtList.size(); i++){
            if(tshirts!=null){
                tshirts.add(buildTshirtViewModel(tshirtList.get(i)));
            }

        }
        return tshirts;
    }

    private TshirtViewModel buildTshirtViewModel(Tshirt tshirt) {


        Optional<Tshirt> tshirt1 = tshirtRepository.findById(tshirt.getId());


        TshirtViewModel tshirtViewModel = new TshirtViewModel();

        tshirtViewModel.setId(tshirt.getId());
        tshirtViewModel.setColor(tshirt.getColor());
        tshirtViewModel.setPrice(tshirt.getPrice());
        tshirtViewModel.setSize(tshirt.getSize());
        tshirtViewModel.setQuantity(tshirt.getQuantity());
        tshirtViewModel.setDescription(tshirt.getDescription());
        BigDecimal priceFormatter = tshirtViewModel.getPrice().setScale(2, BigDecimal.ROUND_HALF_UP);
        tshirtViewModel.setPrice(priceFormatter);


        return tshirtViewModel;
    }


    public List<TshirtViewModel> findAllTshirts() {

        List<Tshirt> tshirtList = tshirtRepository.findAll();

        List<TshirtViewModel> tvmList = new ArrayList<>();

        for (Tshirt tshirt : tshirtList) {
            TshirtViewModel tvm = buildTshirtViewModel(tshirt);
            tvmList.add(tvm);
        }

        return tvmList;
    }


    @Transactional
    public void updateTshirt(TshirtViewModel viewModel) {



        Tshirt tshirt = new Tshirt();
        tshirt.setId(viewModel.getId());
        tshirt.setPrice(viewModel.getPrice());
        tshirt.setColor(viewModel.getColor());
        tshirt.setSize(viewModel.getSize());
        tshirt.setDescription(viewModel.getDescription());
        tshirt.setQuantity(viewModel.getQuantity());


        tshirtRepository.save(tshirt);


    }

    @Transactional
    public void removeTshirt(int id) {


        tshirtRepository.deleteById(id);

    }


}




