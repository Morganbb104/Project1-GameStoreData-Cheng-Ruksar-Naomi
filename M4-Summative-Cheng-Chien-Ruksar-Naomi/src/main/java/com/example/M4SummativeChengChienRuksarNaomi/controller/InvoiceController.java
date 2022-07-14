package com.example.M4SummativeChengChienRuksarNaomi.controller;

import com.example.M4SummativeChengChienRuksarNaomi.repository.InvoiceRepository;
import com.example.M4SummativeChengChienRuksarNaomi.service.ServiceLayer;
import com.example.M4SummativeChengChienRuksarNaomi.viewmodel.GameViewModel;
import com.example.M4SummativeChengChienRuksarNaomi.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping("/invoice")
    //using created to give us the status on whether or not the record was creaated
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel addInvoice(@RequestBody InvoiceViewModel invoiceViewModel) {
//
        //saving the new customer in  the repo, whys this so simple
        return serviceLayer.saveInvoice(invoiceViewModel);
    }
    @GetMapping("/invoice")
    @ResponseStatus(HttpStatus.OK)
    public List<InvoiceViewModel> getAllInvoices() {
        return serviceLayer.findAllInvoice();

    }

    @GetMapping("/invoice/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InvoiceViewModel getInvoiceById(@PathVariable Integer id){
        return serviceLayer.findInvoice(id);
    }

    @PutMapping("/invoice/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInvoice(@RequestBody InvoiceViewModel invoiceViewModel) {
        serviceLayer.updateInvoice(invoiceViewModel);
    }
    @DeleteMapping("/invoice/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInvoice(@PathVariable int id) {
        serviceLayer.removeGame(id);
    }


}
