package com.example.M4SummativeChengChienRuksarNaomi.viewmodel;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TshirtViewModelTest {
    @Test
    public void testToCreateANewTshirtViewModel(){

        TshirtViewModel test1 = new TshirtViewModel(
                10,
                "M",
                "yellow",
                "graduation limited",
                BigDecimal.valueOf(500),
                5
        );
        TshirtViewModel test2 = new TshirtViewModel(
                10,
                "M",
                "yellow",
                "graduation limited",
                BigDecimal.valueOf(500),
                5
        );
        assertEquals(test1, test2);

    }

}