package com.example.M4SummativeChengChienRuksarNaomi.controller;

import com.example.M4SummativeChengChienRuksarNaomi.models.Games;
import com.example.M4SummativeChengChienRuksarNaomi.repository.GameRepository;
import com.example.M4SummativeChengChienRuksarNaomi.service.ServiceLayer;
import com.example.M4SummativeChengChienRuksarNaomi.viewmodel.GameViewModel;
import com.example.M4SummativeChengChienRuksarNaomi.viewmodel.TshirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
public class GameController {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    ServiceLayer serviceLayer;
    @PostMapping("/game")
    //using created to give us the status on whether or not the record was creaated
    @ResponseStatus(HttpStatus.CREATED)

    public GameViewModel addGame(@RequestBody @Valid  GameViewModel gameViewModel) {
//        if(gameViewModel.getStudio()==null){
//
//            System.out.println("This is the find all games");
//            throw new
//        }
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
    @GetMapping("/game/studio/{studio}")
    public List<GameViewModel> getGameByStudio(@PathVariable String studio) {
        return serviceLayer.findGameByStudio(studio);
    }
    @GetMapping("/game/esrbRating/{esrbRating}")
    public List<GameViewModel> getGameByEsrbRating(@PathVariable String esrbRating) {
        return serviceLayer.findGameByEsrbRating(esrbRating);
    }
    @GetMapping("/game/title/{title}")
    public List<GameViewModel> getGameByTitle(@PathVariable String title) {
        return serviceLayer.findGameByTitle(title);
    }

    @PutMapping("/game")
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
