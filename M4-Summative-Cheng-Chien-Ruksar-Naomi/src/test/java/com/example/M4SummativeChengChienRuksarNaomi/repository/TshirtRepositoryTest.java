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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TshirtRepositoryTest {


    @Autowired
    TshirtRepository tshirtRepository;


    @Before
    public void setUp() throws Exception {
        tshirtRepository.deleteAll();

        tshirtRepository.save(new Tshirt(1, "small", "black", "Black t-shirt", BigDecimal.valueOf(10.00), 20 ));
        tshirtRepository.save(new Tshirt(2, "small", "white", "white t-shirts", BigDecimal.valueOf(10.00), 20 ));
        tshirtRepository.save(new Tshirt(3, "medium", "black", "T-Shirt", BigDecimal.valueOf(10.00), 10 ));

    }

    @Test
    public void addGetDeleteTshirt() {

        // Need to create a Label and an Artist first

        Tshirt tshirt = new Tshirt();
        tshirt.setQuantity(4);
        tshirt.setDescription("This is a tshirt");
        tshirt.setPrice(new BigDecimal("20.00"));
        tshirt.setSize("L");
        tshirt.setColor("Blue");

        tshirt = tshirtRepository.save(tshirt);

        Optional<Tshirt> tshirt1 = tshirtRepository.findById(tshirt.getId());

        assertEquals(tshirt1.get(), tshirt);

        tshirtRepository.deleteById(tshirt.getId());

        tshirt1 = tshirtRepository.findById(tshirt.getId());

        assertFalse(tshirt1.isPresent());

    }


    @Test
    public void getAllTshirts() {

        // Need to create a Label and an Artist first
        Tshirt tshirt = new Tshirt();
        tshirt.setQuantity(4);
        tshirt.setDescription("This is a tshirt");
        tshirt.setPrice(new BigDecimal("20.00"));
        tshirt.setSize("medium");
        tshirt.setColor("blue");

        tshirt = tshirtRepository.save(tshirt);

        Tshirt tshirt1 = new Tshirt();
        tshirt1.setQuantity(4);
        tshirt1.setDescription("This is a tshirt");
        tshirt1.setPrice(new BigDecimal("20.00"));
        tshirt1.setSize("small");
        tshirt1.setColor("blue");

        tshirt1 = tshirtRepository.save(tshirt1);

        List<Tshirt> tshirts = tshirtRepository.findAll();

        assertEquals(5, tshirts.size());

    }

    @Test
    public void updateTshirt() {

        Tshirt tshirt = new Tshirt();
        tshirt.setQuantity(4);
        tshirt.setDescription("This is a tshirt");
        tshirt.setPrice(new BigDecimal("20.00"));
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
    public void shouldReturnTshirtsBySize() {

        List<Tshirt> tshirt = tshirtRepository.findBySize("small");

        assertEquals(2, tshirt.size());
    }

    @Test
    public void findByColor() {

        List<Tshirt> tshirt = tshirtRepository.findByColor("black");
        assertEquals(2, tshirt.size());
    }
}