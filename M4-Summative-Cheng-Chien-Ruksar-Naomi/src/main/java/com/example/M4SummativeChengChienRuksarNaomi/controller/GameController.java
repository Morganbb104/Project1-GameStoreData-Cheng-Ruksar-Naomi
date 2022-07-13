package com.example.M4SummativeChengChienRuksarNaomi.controller;

import com.example.M4SummativeChengChienRuksarNaomi.models.Games;
import com.example.M4SummativeChengChienRuksarNaomi.repository.GameRepository;
import com.example.M4SummativeChengChienRuksarNaomi.service.ServiceLayer;
import com.example.M4SummativeChengChienRuksarNaomi.viewmodel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class GameController {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    ServiceLayer serviceLayer;
    @PostMapping("/game")
    //using created to give us the status on whether or not the record was creaated
    @ResponseStatus(HttpStatus.CREATED)
    public GameViewModel addGame(@RequestBody GameViewModel gameViewModel) {
//
        //saving the new customer in  the repo, whys this so simple
        return serviceLayer.saveGame(gameViewModel);

    }

    @GetMapping("/game")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getAllGames() {
        return serviceLayer.findAllGames();

    }

    @GetMapping("/game/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel getGameById(@PathVariable Integer id){
        return serviceLayer.findGame(id);

    }

    @PutMapping("/game/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody GameViewModel gameViewModel) {
        serviceLayer.updateGame(gameViewModel);
    }
    @DeleteMapping("/game/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int id) {
        serviceLayer.removeGame(id);
    }


//    @Autowired
//    Repository gameRepository =
}
