package com.example.M4SummativeChengChienRuksarNaomi.viewmodel;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ConsoleViewModelTest {

    @Test
    public void testToCreateANewConsoleViewModel(){

        ConsoleViewModel test1 = new ConsoleViewModel(
                "modelA",
                "Cheng company",
                "16 GB",
                "i7",
                BigDecimal.valueOf(500),
                5
        );
        ConsoleViewModel test2 = new ConsoleViewModel(
                "modelA",
                "Cheng company",
                "16 GB",
                "i7",
                BigDecimal.valueOf(500),
                5
        );
        assertEquals(test1, test2);

    }


}