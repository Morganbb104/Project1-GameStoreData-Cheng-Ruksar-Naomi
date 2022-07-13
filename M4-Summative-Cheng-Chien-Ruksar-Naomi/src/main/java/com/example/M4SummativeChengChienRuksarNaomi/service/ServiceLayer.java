package com.example.M4SummativeChengChienRuksarNaomi.service;

import com.example.M4SummativeChengChienRuksarNaomi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLayer {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private ConsoleRepository consoleRepository;

    @Autowired
    private TshirtRepository tshirtRepository;

    @Autowired
    private ProcessingFeeRepository processingFeeRepository;

    @Autowired
    private SalesTaxRateRepository salesTaxRateRepository;



}
