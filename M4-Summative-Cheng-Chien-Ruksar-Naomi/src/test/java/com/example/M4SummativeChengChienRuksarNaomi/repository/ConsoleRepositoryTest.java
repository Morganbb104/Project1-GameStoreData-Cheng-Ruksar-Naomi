package com.example.M4SummativeChengChienRuksarNaomi.repository;

import com.example.M4SummativeChengChienRuksarNaomi.models.Console;

import com.example.M4SummativeChengChienRuksarNaomi.models.Games;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleRepositoryTest {

    @Autowired
    ConsoleRepository consoleRepository;

    @Before
    public void setUp() throws Exception {
        consoleRepository.deleteAll();

        consoleRepository.save(new Console("2","Sony","16GB","i7",BigDecimal.valueOf(600.00),54));
        consoleRepository.save(new Console("3","Apple","32GB","i8",BigDecimal.valueOf(700.00),40));
        consoleRepository.save(new Console("4","TSMC","64GB","i9",BigDecimal.valueOf(800.00),31));

    }

    @Test
    public void addGetDeleteConsole() {

        // Need to create a Label and an Artist first

        Console console = new Console();
        console.setMemoryAmount("5g");
        console.setProcessor("intel");
        console.setPrice(new BigDecimal("20.00"));
        console.setModel("newest");
        console.setManufacturer("this");
        console.setQuantity(5);


        console = consoleRepository.save(console);

        Optional<Console> console1 = consoleRepository.findById(console.getId());

        assertEquals(console1.get(),console);

        consoleRepository.deleteById(console.getId());

        console1 = consoleRepository.findById(console.getId());

        assertFalse(console1.isPresent());

    }


    @Test
    public void getAllConsole() {

        // Need to create a Label and an Artist first
        Console console = new Console();
        console.setMemoryAmount("5g");
        console.setProcessor("intel");
        console.setPrice(BigDecimal.valueOf(20.00));
        console.setModel("newest");
        console.setManufacturer("this");
        console.setQuantity(5);

        console = consoleRepository.save(console);

        Console console1 = new Console();


        console1.setMemoryAmount("5g");
        console1.setProcessor("intel");
        console1.setPrice(BigDecimal.valueOf(20.00));
        console1.setModel("newest");
        console1.setManufacturer("this");
        console1.setQuantity(5);

        console1 = consoleRepository.save(console1);

        List<Console> consoles = consoleRepository.findAll();

        assertEquals(5,consoles.size());

    }

    @Test
    public void updateGame() {

        Console console = new Console();
        console.setMemoryAmount("5g");
        console.setProcessor("intel");
        console.setPrice(new BigDecimal("20.00"));
        console.setModel("newest");
        console.setManufacturer("this");
        console.setQuantity(5);
        console = consoleRepository.save(console);

        console.setQuantity(5);
        console.setModel("newr");
        console.setPrice(new BigDecimal("30.00"));

        consoleRepository.save(console);

        Optional<Console> console1 = consoleRepository.findById(console.getId());
        assertEquals(console1.get(), console);

    }


    @Test
    public void findByManufacturer() {
        Console console = new Console();


        console.setMemoryAmount("5g");
        console.setProcessor("intel");
        console.setPrice(BigDecimal.valueOf(20.00));
        console.setModel("newest");
        console.setManufacturer("this");
        console.setQuantity(5);
        consoleRepository.save(console);


        List<Console> console1 = consoleRepository.findByManufacturer(console.getManufacturer());

        assertEquals(1,console1.size());
    }



}