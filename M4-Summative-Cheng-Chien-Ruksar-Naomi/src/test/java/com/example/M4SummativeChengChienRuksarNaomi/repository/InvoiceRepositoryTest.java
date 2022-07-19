package com.example.M4SummativeChengChienRuksarNaomi.repository;

import com.example.M4SummativeChengChienRuksarNaomi.models.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
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
        invoice.setItemType("Console");
        invoice.setItemId(12);
        invoice.setUnitPrice(new BigDecimal("10.00"));
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("20.00"));
        invoice.setTax(new BigDecimal("1.00"));
        invoice.setProcessingFee(new BigDecimal("1.98"));
        invoice.setTotal(new BigDecimal("22.98"));

        invoice = invoiceRepository.save(invoice);
        Optional<Invoice> invoice1 = invoiceRepository.findById(invoice.getId());
        assertEquals(invoice1.get().getId(),invoice.getId());

        invoiceRepository.deleteById(invoice.getId());
        invoice1 = invoiceRepository.findById(invoice.getId());
        assertFalse(invoice1.isPresent());



    }


    //update
    @Test
    public void updateInvoice() {
// add value
        Invoice invoice = new Invoice();
        invoice.setName("Cheng3");
        invoice.setStreet("Aurora1");
        invoice.setCity("Kirkland");
        invoice.setState("WA");
        invoice.setZipcode("86543");
        invoice.setItemType("Consoles");
        invoice.setItemId(12);
        invoice.setUnitPrice(new BigDecimal("10.00"));
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("20.00"));
        invoice.setTax(new BigDecimal("1.00"));
        invoice.setProcessingFee(new BigDecimal("1.98"));
        invoice.setTotal(new BigDecimal("22.98"));

        invoice =invoiceRepository.save(invoice);
        invoice.setZipcode("12345");
        invoiceRepository.save(invoice);
        Optional<Invoice> invoice1 =invoiceRepository.findById(invoice.getId());
        assertEquals(invoice1.get(),invoice);

    }
    //findInvoiceByID
    @Test
    public void shouldFindInvoiceById(){
        Invoice invoice = new Invoice();

        invoice.setName("Cheng3");
        invoice.setStreet("Aurora1");
        invoice.setCity("Kirkland");
        invoice.setState("WA");
        invoice.setZipcode("86543");
        invoice.setItemType("Consoles");
        invoice.setItemId(12);
        invoice.setUnitPrice(new BigDecimal("10.00"));
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("20.00"));
        invoice.setTax(new BigDecimal("1.00"));
        invoice.setProcessingFee(new BigDecimal("1.98"));
        invoice.setTotal(new BigDecimal("22.98"));

        invoice =invoiceRepository.save(invoice);
        Optional<Invoice> invoice1 =invoiceRepository.findById(invoice.getId());
        assertEquals(invoice1.get(),invoice);


    }

//    //findALLInvoice
//    @Test
//    public void getAllInvoices(){
//        Invoice invoice = new Invoice();
//
//        invoice.setName("Cheng3");
//        invoice.setStreet("Aurora1");
//        invoice.setCity("Kirkland");
//        invoice.setState("WA");
//        invoice.setZipcode("86543");
//        invoice.setItemType("Consoles");
//        invoice.setItemId(12);
//        invoice.setUnitPrice(new BigDecimal("10.00"));
//        invoice.setQuantity(2);
//        invoice.setSubtotal(new BigDecimal("20.00"));
//        invoice.setTax(new BigDecimal("1.00"));
//        invoice.setProcessingFee(new BigDecimal("1.98"));
//        invoice.setTotal(new BigDecimal("22.98"));
//
//        invoice =invoiceRepository.save(invoice);
//
//        Invoice invoice1 = new Invoice();
//
//        invoice1.setName("Cheng4");
//        invoice1.setStreet("Aurora3");
//        invoice1.setCity("Kirkland");
//        invoice1.setState("WA");
//        invoice1.setZipcode("86543");
//        invoice1.setItemType("Consoles");
//        invoice1.setItemId(12);
//        invoice1.setUnitPrice(new BigDecimal("10.00"));
//        invoice1.setQuantity(2);
//        invoice1.setSubtotal(new BigDecimal("20.00"));
//        invoice1.setTax(new BigDecimal("1.00"));
//        invoice1.setProcessingFee(new BigDecimal("1.98"));
//        invoice1.setTotal(new BigDecimal("22.98"));
//        invoice1 =invoiceRepository.save(invoice1);
//
//

//        invoice1 =invoiceRepository.save(invoice1);
//        Optional<Invoice> invoice1 =invoiceRepository.findAll();
//        assertEquals(5,invoice.size());
//
////        invoice =invoiceRepository.save(invoice);
////        Optional<Invoice> invoice1 =invoiceRepository.findById(invoice.getId());
////        assertEquals(invoice1.get(),invoice);
//
//    }

}