package com.example.M4SummativeChengChienRuksarNaomi.repository;

import com.example.M4SummativeChengChienRuksarNaomi.models.ProcessingFee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProcessingFeeRepositoryTest {

    @Autowired
    ProcessingFeeRepository processingFeeRepository;

    @Before
    public void setUp() throws Exception{

        processingFeeRepository.deleteAll();

        processingFeeRepository.save(new ProcessingFee(1,"Games", BigDecimal.valueOf(1.49)));
        processingFeeRepository.save(new ProcessingFee(2,"Consoles", BigDecimal.valueOf(14.99)));
        processingFeeRepository.save(new ProcessingFee(3,"T-Shirts", BigDecimal.valueOf(1.98)));
    }

    @Test
    public void shouldReturnProcessingFeeForGames(){

        Optional<ProcessingFee> gamesProcessingFee = processingFeeRepository.findById(("Games"));

        assertEquals(new BigDecimal("1.49"), gamesProcessingFee.get().getFee());

    }
    @Test
    public void shouldReturnProcessingFeeForConsoles(){

        Optional<ProcessingFee> consolesProcessingFee = processingFeeRepository.findById("Consoles");
        assertEquals(new BigDecimal("14.99"), consolesProcessingFee.get().getFee());
    }
    @Test
    public void shouldReturnProcessingFeeForTshirts(){

        Optional<ProcessingFee> tshirtsProcessingFee = processingFeeRepository.findById("T-Shirts");
        assertEquals(new BigDecimal("1.98"), tshirtsProcessingFee.get().getFee());
    }



}