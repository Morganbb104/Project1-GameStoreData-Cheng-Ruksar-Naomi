package com.example.M4SummativeChengChienRuksarNaomi.repository;

import com.example.M4SummativeChengChienRuksarNaomi.models.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleRepositoryTest {


    @Autowired
    ConsoleRepository consoleRepository;


    @Before
    public void setUp() throws Exception{

        consoleRepository.deleteAll();

    }

    @Test
    public void ShouldGetAllConsole(){

        Console console = new Console();

        console.setManufacturer("sony");
        console.setMemoryAmount("5GB");
        console.setQuantity(6);
        console.setPrice(BigDecimal.valueOf(250));
        console.setProcessor("intel 8th Gen");
        console.setModel("model-1");

        console = consoleRepository.save(console);
        Optional<Console> console1 = consoleRepository.findById(console.getId());

        assertEquals(console1.get(), console);
        consoleRepository.deleteById(console.getId());

        console1 = consoleRepository.findById(console.getId());

        assertFalse(console1.isPresent());

    }


    @Test
    public void shouldFindByManufacturer() {


    }

    @org.junit.jupiter.api.Test
    void findByManufacturer() {
    }
}