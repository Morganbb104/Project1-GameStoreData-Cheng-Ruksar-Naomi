package com.example.M4SummativeChengChienRuksarNaomi.repository;

import com.example.M4SummativeChengChienRuksarNaomi.models.Invoice;
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
public class InvoiceRepositoryTest {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Before
    public void setUp() throws Exception{
        invoiceRepository.deleteAll();
        invoiceRepository.save(new Invoice(1,"Cheng", "Shoreline St", "Seattle", "WA", "98129", "game", 1, BigDecimal.valueOf(20.00), 2,BigDecimal.valueOf(40.00),BigDecimal.valueOf(2),BigDecimal.valueOf(1.49),BigDecimal.valueOf(43.49)));
        invoiceRepository.save(new Invoice(2,"Ruksar", "CA St", "Seattle", "WA", "90000", "console", 2, BigDecimal.valueOf(10.00), 2,BigDecimal.valueOf(20.00),BigDecimal.valueOf(1),BigDecimal.valueOf(14.99),BigDecimal.valueOf(35.99)));
        invoiceRepository.save(new Invoice(3,"Naomi", "WA St", "somewhere in CA", "CA", "90009", "tshirt", 3, BigDecimal.valueOf(5.00), 2,BigDecimal.valueOf(10.00),BigDecimal.valueOf(0.70),BigDecimal.valueOf(1.98),BigDecimal.valueOf(12.68)));

    }

    @Test
    public void addGetDeleteInvoice(){
        //add invoice
        Invoice invoice = new Invoice();
        invoice.setName("Cheng2");
        invoice.setStreet("Aurora");
        invoice.setCity("Kirkland");
        invoice.setState("WA");
        invoice.setZipcode("86543");
        invoice.setItemType("console");
        invoice.setItemId(12);
        invoice.setUnitPrice(new BigDecimal("10"));
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("20"));
        invoice.setTax(new BigDecimal("1"));
        invoice.setProcessingFee(new BigDecimal("1.98"));
        invoice.setTotal(new BigDecimal("22.98"));

        invoice = invoiceRepository.save(invoice);
        Optional<Invoice> invoice1 = invoiceRepository.findById(invoice.getId());
        assertEquals(invoice1.get().getId(),invoice);

        invoiceRepository.deleteById(invoice.getId());

        invoice1 = invoiceRepository.findById(invoice.getId());
        assertFalse(invoice1.isPresent());

    }


}