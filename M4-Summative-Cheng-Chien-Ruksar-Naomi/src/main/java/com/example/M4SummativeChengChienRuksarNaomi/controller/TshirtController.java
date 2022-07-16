package com.example.M4SummativeChengChienRuksarNaomi.controller;

import com.example.M4SummativeChengChienRuksarNaomi.repository.TshirtRepository;
import com.example.M4SummativeChengChienRuksarNaomi.service.ServiceLayer;

import com.example.M4SummativeChengChienRuksarNaomi.viewmodel.TshirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class TshirtController {


    @Autowired
    TshirtRepository tshirtRepository;

    @Autowired
    ServiceLayer serviceLayer;


    @GetMapping("/tshirts")
    @ResponseStatus(HttpStatus.OK)
    public List<TshirtViewModel> getAllTshirts(){
        return serviceLayer.findAllTshirts();
    }

    @GetMapping("/tshirts/{id}")
    public TshirtViewModel getTshirtById(@PathVariable int id) {
        return serviceLayer.findTshirtById(id);
    }
    @GetMapping("/tshirts/{size}")
    public List<TshirtViewModel> getTshirtBySize(@PathVariable String size) {
        return serviceLayer.findTshirtBySize(size);
    }
    @GetMapping("/tshirts/{color}")
    public List<TshirtViewModel> getTshirtByColor(@PathVariable String color) {
        return serviceLayer.findTshirtByColor(color);
    }

    @PostMapping("/tshirts")
    @ResponseStatus(HttpStatus.CREATED)
    public TshirtViewModel addTshirt(@RequestBody @Valid TshirtViewModel tshirtViewModel) {
        return serviceLayer.saveTshirt(tshirtViewModel);
    }

    @PutMapping("/tshirts")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTshirt(@RequestBody @Valid TshirtViewModel tshirtViewModel) {
        serviceLayer.updateTshirt(tshirtViewModel);
    }

    @DeleteMapping("/tshirts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTshirt(@PathVariable int id) {
        serviceLayer.removeTshirt(id);
    }
}
