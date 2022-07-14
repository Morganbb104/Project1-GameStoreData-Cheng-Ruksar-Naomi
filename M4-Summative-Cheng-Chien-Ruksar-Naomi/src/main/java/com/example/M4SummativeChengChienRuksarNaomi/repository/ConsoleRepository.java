package com.example.M4SummativeChengChienRuksarNaomi.repository;

import com.example.M4SummativeChengChienRuksarNaomi.models.Console;
import com.example.M4SummativeChengChienRuksarNaomi.models.Games;
import com.example.M4SummativeChengChienRuksarNaomi.viewmodel.ConsoleViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, Integer> {

    List<Games> findByManufacturer(String manufacturer);


    List<ConsoleViewModel> findAllConsoles();

    void updateConsole(ConsoleViewModel consoleViewModel);

    ConsoleViewModel findConsoleById(int id);

    ConsoleViewModel saveConsole(ConsoleViewModel consoleviewModel);

    void removeConsole(int id);
}
