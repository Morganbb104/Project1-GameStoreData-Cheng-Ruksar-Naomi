package com.example.M4SummativeChengChienRuksarNaomi.viewmodel;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class GameViewModelTest {
    @Test
    public void testToCreateANewGameViewModel(){


//            ConsoleViewModel test1 = new ConsoleViewModel(
//                    "modelA",
//                    "Cheng company",
//                    "16 GB",
//                    "i7",
//                    BigDecimal.valueOf(500),
//                    5
//            );
//            ConsoleViewModel test2 = new ConsoleViewModel(
//                    "modelA",
//                    "Cheng company",
//                    "16 GB",
//                    "i7",
//                    BigDecimal.valueOf(500),
//                    5
//            );
//            assertEquals(test1, test2);
//
//

        GameViewModel test1 = new GameViewModel(
                1,
                "2",
                "Tasmania voyage",
                "An adventurous pioneer story",
                Double.valueOf(5.00),
                "UW story",
                5
        );
        GameViewModel test2 = new GameViewModel(
                1,
                "2",
                "Tasmania voyage",
                "An adventurous pioneer story",
                Double.valueOf(5.00),
                "UW story",
                5
        );
        assertEquals(test1,test2);


    }

}