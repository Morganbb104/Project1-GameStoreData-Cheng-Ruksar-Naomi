package com.example.M4SummativeChengChienRuksarNaomi.repository;

import com.example.M4SummativeChengChienRuksarNaomi.models.Tshirt;
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
public class TshirtRepositoryTest {

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
        public void addGetDeleteTshirt() {

            // Need to create a Label and an Artist first

            Tshirt tshirt = new Tshirt();
            tshirt.setQuantity(4);
            tshirt.setDescription("This is a tshirt");
            tshirt.setPrice(BigDecimal.valueOf(20.00));
            tshirt.setSize("L");
            tshirt.setColor("Blue");

            tshirt = tshirtRepository.save(tshirt);

            Optional<Tshirt> tshirt1 = tshirtRepository.findById(tshirt.getId());

            assertEquals(tshirt1.get(), tshirt);

            tshirtRepository.deleteById(tshirt.getId());

            tshirt1 = tshirtRepository.findById(tshirt.getId());

            assertFalse(tshirt1.isPresent());

        }

        @Test(expected  = DataIntegrityViolationException.class)
        public void addWithRefIntegrityException() {

            Tshirt tshirt = new Tshirt();
            tshirt.setQuantity(4);
            tshirt.setDescription("This is a tshirt");
            tshirt.setPrice(BigDecimal.valueOf(20.00));
            tshirt.setSize("L");
            tshirt.setColor("Blue");

            tshirt = tshirtRepository.save(tshirt);

        }

        @Test
        public void getAllTshirts() {

            // Need to create a Label and an Artist first
            Tshirt tshirt = new Tshirt();
            tshirt.setQuantity(4);
            tshirt.setDescription("This is a tshirt");
            tshirt.setPrice(BigDecimal.valueOf(20.00));
            tshirt.setSize("L");
            tshirt.setColor("Blue");

            tshirt = tshirtRepository.save(tshirt);

            Tshirt tshirt1 = new Tshirt();
            tshirt1.setQuantity(4);
            tshirt1.setDescription("This is a tshirt");
            tshirt1.setPrice(BigDecimal.valueOf(20.00));
            tshirt1.setSize("L");
            tshirt1.setColor("Blue");

            tshirt1 = tshirtRepository.save(tshirt1);

            List<Tshirt> aList = tshirtRepository.findAll();

            assertEquals(aList.size(), 2);

        }

        @Test
        public void updateTshirt() {

            Tshirt tshirt = new Tshirt();
            tshirt.setQuantity(4);
            tshirt.setDescription("This is a tshirt");
            tshirt.setPrice(BigDecimal.valueOf(20.00));
            tshirt.setSize("L");
            tshirt.setColor("Blue");
            tshirt = tshirtRepository.save(tshirt);

            tshirt.setQuantity(5);
            tshirt.setColor("purple");
            tshirt.setDescription("This is a new description");

            tshirtRepository.save(tshirt);

            Optional<Tshirt> tshirt1 = tshirtRepository.findById(tshirt.getId());
            assertEquals(tshirt1.get(), tshirt);

        }


        @Test
    public void findBySize() {
    }

    @Test
    public void findByColor() {
    }
}