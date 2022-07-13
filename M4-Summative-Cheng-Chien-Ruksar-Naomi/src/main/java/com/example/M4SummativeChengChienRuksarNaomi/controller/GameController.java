package com.example.M4SummativeChengChienRuksarNaomi.controller;

import com.example.M4SummativeChengChienRuksarNaomi.models.Games;
import com.example.M4SummativeChengChienRuksarNaomi.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class GameController {
    @Autowired
    GameRepository gameRepository;
    @PostMapping("/game")
    //using created to give us the status on whether or not the record was creaated
    @ResponseStatus(HttpStatus.CREATED)
    public Games addGame(@RequestBody Games game) {
//
        //saving the new customer in  the repo, whys this so simple
        return gameRepository.save(game);

    }
    @GetMapping("/game")
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getAllGames() {
        return gameRepository.findAll();

    }
    @GetMapping("/game/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGamesById(@PathVariable Integer id) {
        Optional<Games> game =gameRepository.findById(id);
        if(game.isPresent()==false) throw new IllegalArgumentException("invalid id");
        return game.get();


    }

//    @Autowired
//    Repository gameRepository =
}
