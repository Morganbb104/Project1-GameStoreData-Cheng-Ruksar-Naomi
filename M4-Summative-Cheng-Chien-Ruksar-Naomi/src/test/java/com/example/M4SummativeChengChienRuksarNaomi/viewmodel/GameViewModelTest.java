package com.example.M4SummativeChengChienRuksarNaomi.viewmodel;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class GameViewModelTest {
    @Test
    public void testToCreateANewGameViewModel(){

        GameViewModel test1 = new GameViewModel(
                1,
                "2",
                "Tasmania voyage",
                "An adventurous pioneer story",
                50,
                "UW story",
                5
        );
        GameViewModel test2 = new GameViewModel(
                1,
                "2",
                "Tasmania voyage",
                "An adventurous pioneer story",
                50,
                "UW story",
                5
        );
        assertEquals(test1, test2);


    }

}