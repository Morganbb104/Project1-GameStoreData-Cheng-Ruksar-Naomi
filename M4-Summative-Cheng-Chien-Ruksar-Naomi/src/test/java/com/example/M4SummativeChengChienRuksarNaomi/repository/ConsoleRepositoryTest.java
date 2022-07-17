package com.example.M4SummativeChengChienRuksarNaomi.repository;

import com.example.M4SummativeChengChienRuksarNaomi.models.Console;

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
    GameRepository gameRepository;
    @Autowired
    ConsoleRepository consoleRepository;
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    TshirtRepository tshirtRepository;
    @Autowired
    ProcessingFeeRepository processingFeeRepository;
    @Autowired
    SalesTaxRateRepository salesTaxRateRepository;

    @Before
    public void setUp() throws Exception {

        gameRepository.deleteAll();
        consoleRepository.deleteAll();
        invoiceRepository.deleteAll();
        tshirtRepository.deleteAll();
        processingFeeRepository.deleteAll();
        salesTaxRateRepository.deleteAll();
    }

    @Test
    public void addGetDeleteGame() {

        // Need to create a Label and an Artist first

        Console console = new Console();
        console.setMemoryAmount("5g");
        console.setProcessor("intel");
        console.setPrice(BigDecimal.valueOf(20.00));
        console.setModel("newest");
        console.setManufacturer("this");
        console.setQuantity(5);


        console = consoleRepository.save(console);

        Optional<Console> console1 = consoleRepository.findById(console.getId());

        assertEquals(console1.get(), console);

        consoleRepository.deleteById(console.getId());

        console1 = consoleRepository.findById(console.getId());

        assertFalse(console1.isPresent());

    }

    @Test(expected  = DataIntegrityViolationException.class)
    public void addWithRefIntegrityException() {

        Console console = new Console();
        console.setMemoryAmount("5g");
        console.setProcessor("intel");
        console.setPrice(BigDecimal.valueOf(20.00));
        console.setModel("newest");
        console.setManufacturer("this");
        console.setQuantity(5);
        console = consoleRepository.save(console);

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

        console1.setQuantity(4);
        console1.setMemoryAmount("5g");
        console1.setProcessor("intel");
        console1.setPrice(BigDecimal.valueOf(20.00));
        console1.setModel("newest");
        console1.setManufacturer("this");
        console1.setQuantity(5);

        console1 = consoleRepository.save(console1);

        List<Console> aList = consoleRepository.findAll();

        assertEquals(aList.size(), 2);

    }

    @Test
    public void updateGame() {

        Console console = new Console();
        console.setMemoryAmount("5g");
        console.setProcessor("intel");
        console.setPrice(BigDecimal.valueOf(20.00));
        console.setModel("newest");
        console.setManufacturer("this");
        console.setQuantity(5);
        console = consoleRepository.save(console);

        console.setQuantity(5);
        console.setModel("newr");
        console.setPrice(BigDecimal.valueOf(20));

        consoleRepository.save(console);

        Optional<Console> console1 = consoleRepository.findById(console.getId());
        assertEquals(console1.get(), console);

    }


    @Test
    public void findByManufacturer() {
        Console console = new Console();

        console.setQuantity(4);
        console.setMemoryAmount("5g");
        console.setProcessor("intel");
        console.setPrice(BigDecimal.valueOf(20.00));
        console.setModel("newest");
        console.setManufacturer("this");
        console.setQuantity(5);
        consoleRepository.save(console);


        List<Console> console1 = consoleRepository.findByManufacturer(console.getManufacturer());

        assertEquals(console1.get(1), console);
    }



}