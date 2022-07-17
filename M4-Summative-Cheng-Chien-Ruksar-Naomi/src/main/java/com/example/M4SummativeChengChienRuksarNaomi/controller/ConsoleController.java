package com.example.M4SummativeChengChienRuksarNaomi.controller;

import com.example.M4SummativeChengChienRuksarNaomi.models.Console;
import com.example.M4SummativeChengChienRuksarNaomi.repository.ConsoleRepository;
import com.example.M4SummativeChengChienRuksarNaomi.service.ServiceLayer;
import com.example.M4SummativeChengChienRuksarNaomi.viewmodel.ConsoleViewModel;
import com.example.M4SummativeChengChienRuksarNaomi.viewmodel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ConsoleController {

    @Autowired
    ConsoleRepository consoleRepository;

    @Autowired
    ServiceLayer serviceLayer;


    @GetMapping("/consoles")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getAllConsoles(){
        return serviceLayer.findAllConsoles();
    }

    @GetMapping("/consoles/{id}")
    public ConsoleViewModel getConsoleById(@PathVariable int id) {
        return serviceLayer.findConsoleById(id);
    }

    @GetMapping("/consoles/{manufacturer}")
    public List<ConsoleViewModel> getConsoleByManufacturer(@PathVariable String manufacturer) {
        return serviceLayer.findConsoleByManufacturer(manufacturer);
    }
    @PostMapping("/consoles")
    @ResponseStatus(HttpStatus.CREATED)
    public ConsoleViewModel addConsole(@RequestBody  @Valid ConsoleViewModel consoleViewModel) {
        return serviceLayer.saveConsole(consoleViewModel);
    }

    @PutMapping("/consoles")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@RequestBody @Valid ConsoleViewModel consoleViewModel) {
        serviceLayer.updateConsole(consoleViewModel);
    }

    @DeleteMapping("/consoles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {
        serviceLayer.removeConsole(id);
    }
}
