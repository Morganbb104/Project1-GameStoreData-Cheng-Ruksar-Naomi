package com.example.M4SummativeChengChienRuksarNaomi.service;

import com.example.M4SummativeChengChienRuksarNaomi.models.Console;
import com.example.M4SummativeChengChienRuksarNaomi.models.Games;
import com.example.M4SummativeChengChienRuksarNaomi.models.Invoice;
import com.example.M4SummativeChengChienRuksarNaomi.models.SalesTaxRate;
import com.example.M4SummativeChengChienRuksarNaomi.repository.*;
import com.example.M4SummativeChengChienRuksarNaomi.viewmodel.ConsoleViewModel;
import com.example.M4SummativeChengChienRuksarNaomi.viewmodel.GameViewModel;
import com.example.M4SummativeChengChienRuksarNaomi.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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
                            TshirtRepository tshirtRepository, ProcessingFeeRepository processingFeeRepository,SalesTaxRateRepository salesTaxRateRepository,InvoiceRepository invoiceRepository) {
            this.gameRepository =gameRepository;
            this.consoleRepository=consoleRepository;
            this.tshirtRepository = tshirtRepository;
            this.processingFeeRepository = processingFeeRepository;
            this.salesTaxRateRepository=salesTaxRateRepository;
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
                GameViewModel avm = buildGameViewModel(game);
                gvmList.add(avm);
            }

            return gvmList;
        }

        @Transactional
        public void updateGame(GameViewModel viewModel) {

            // Update the game information
            Games game= new Games();
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
        invoice.setId(viewModel.getId());

        invoice.setName(viewModel.getName());
        invoice.setStreet(viewModel.getStreet());
        invoice.setCity(viewModel.getCity());
        invoice.setState(viewModel.getState());
        invoice.setZipcode(viewModel.getZipcode());
        invoice.setItemType(viewModel.getItemType());
        invoice.setItemId(viewModel.getItemId());
        invoice.setUnitPrice(viewModel.getUnitPrice());
        invoice.setQuantity(viewModel.getQuantity());
        invoice.setSubtotal(viewModel.getSubtotal());
        invoice.setTax(viewModel.getTax());
        invoice.setProcessingFee(viewModel.getProcessingFee());
        invoice.setTotal(viewModel.getTotal());

        invoice = invoiceRepository.save(invoice);
        viewModel.setId(invoice.getId());

        return viewModel;
    }

//    public InvoiceViewModel findInvoice(Integer id) {
//
//        // Get the invoice object first
//        Optional<Invoice> invoice = invoiceRepository.findById(id);
//
//        return invoice.isPresent() ? buildInvoiceViewModel(invoice.get()) : null;
//    }

//    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
//
//        // Get the associated invoice
//        // Optional<SalesTaxRate> salesTax = salesTaxRateRepository.findById(game.getId());
//
//        // Assemble the InvoiceViewModel
//        InvoiceViewModel ivm = new InvoiceViewModel();
//        ivm.setId(invoice.getId());
//        ivm.setTitle(game.getTitle());
//        ivm.setDescription(game.getDescription());
//        ivm.setPrice(game.getPrice());
//        ivm.setEsrbRating(game.getEsrbRating());
//        ivm.setQuantity(game.getQuantity());
//        ivm.setStudio(game.getStudio());
//
//
//        // Return the AlbumViewModel
//        return ivm;
//    }
//
//    public List<GameViewModel> findAllGames() {
//
//        List<Games> gamesList = gameRepository.findAll();
//
//        List<GameViewModel> gvmList = new ArrayList<>();
//
//        for (Games game : gamesList) {
//            GameViewModel avm = buildGameViewModel(game);
//            gvmList.add(avm);
//        }
//
//        return gvmList;
//    }
//
//    @Transactional
//    public void updateGame(GameViewModel viewModel) {
//
//        // Update the album information
//        Games game= new Games();
//        game.setId(viewModel.getId());
//        game.setTitle(viewModel.getTitle());
//        game.setPrice(viewModel.getPrice());
//        game.setStudio(viewModel.getStudio());
//        game.setDescription(viewModel.getDescription());
//        game.setQuantity(viewModel.getQuantity());
//        game.setEsrbRating(viewModel.getEsrbRating());
//
//
//        gameRepository.save(game);
//
//    }
//
//    @Transactional
//    public void removeGame(int id) {
//
//
//        // Remove album
//        gameRepository.deleteById(id);

//    }




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

}



