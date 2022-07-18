package com.example.M4SummativeChengChienRuksarNaomi.repository;

import com.example.M4SummativeChengChienRuksarNaomi.models.SalesTaxRate;
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
public class SalesTaxRateRepositoryTest {

    @Autowired
    SalesTaxRateRepository salesTaxRateRepository;

    @Before
    public void setUp() throws Exception{
        salesTaxRateRepository.deleteAll();

        salesTaxRateRepository.save(new SalesTaxRate(1, "WA", BigDecimal.valueOf(0.05)));
        salesTaxRateRepository.save(new SalesTaxRate(2, "CA", BigDecimal.valueOf(0.06)));
        salesTaxRateRepository.save(new SalesTaxRate(3, "OR", BigDecimal.valueOf(0.07)));
    }

    @Test
    public void shouldReturnSalesTaxRateOfAllStates() throws Exception{
        Optional<SalesTaxRate> oregonSalesTax = salesTaxRateRepository.findById("OR");
        assertEquals(new BigDecimal("0.07"), oregonSalesTax.get().getRate());
    }




}