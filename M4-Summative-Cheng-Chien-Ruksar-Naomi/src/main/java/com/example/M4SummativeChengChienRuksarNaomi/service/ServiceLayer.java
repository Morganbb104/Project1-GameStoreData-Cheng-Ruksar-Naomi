package com.example.M4SummativeChengChienRuksarNaomi.service;

import com.example.M4SummativeChengChienRuksarNaomi.models.Games;
import com.example.M4SummativeChengChienRuksarNaomi.models.SalesTaxRate;
import com.example.M4SummativeChengChienRuksarNaomi.repository.*;
import com.example.M4SummativeChengChienRuksarNaomi.viewmodel.GameViewModel;
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
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private ConsoleRepository consoleRepository;

    @Autowired
    private TshirtRepository tshirtRepository;

    @Autowired
    private ProcessingFeeRepository processingFeeRepository;

    @Autowired
    private SalesTaxRateRepository salesTaxRateRepository;





        @Autowired
        public ServiceLayer(GameRepository gameRepository, ConsoleRepository consoleRepository,
                            TshirtRepository tshirtRepository, ProcessingFeeRepository processingFeeRepository,SalesTaxRateRepository salesTaxRateRepository) {
            this.gameRepository =gameRepository;
            this.consoleRepository=consoleRepository;
            this.tshirtRepository = tshirtRepository;
            this.processingFeeRepository = processingFeeRepository;
            this.salesTaxRateRepository=salesTaxRateRepository;
        }

        @Transactional
        public GameViewModel saveGame(GameViewModel viewModel) {

            // Persist Album
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

            // Get the album object first
            Optional<Games> game = gameRepository.findById(id);

            return game.isPresent() ? buildGameViewModel(game.get()) : null;
        }

        private GameViewModel buildGameViewModel(Games game) {

            // Get the associated artist
           // Optional<SalesTaxRate> salesTax = salesTaxRateRepository.findById(game.getId());

            // Assemble the AlbumViewModel
            GameViewModel gvm = new GameViewModel();
            gvm.setId(game.getId());
            gvm.setTitle(game.getTitle());
            gvm.setDescription(game.getDescription());
            gvm.setPrice(game.getPrice());
            gvm.setEsrbRating(game.getEsrbRating());
            gvm.setQuantity(game.getQuantity());
            gvm.setStudio(game.getStudio());


            // Return the AlbumViewModel
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

            // Update the album information
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


            // Remove album
            gameRepository.deleteById(id);

        }
    }



