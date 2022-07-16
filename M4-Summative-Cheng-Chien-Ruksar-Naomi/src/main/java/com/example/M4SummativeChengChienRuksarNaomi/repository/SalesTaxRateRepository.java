package com.example.M4SummativeChengChienRuksarNaomi.repository;

import com.example.M4SummativeChengChienRuksarNaomi.models.Console;
import com.example.M4SummativeChengChienRuksarNaomi.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesTaxRateRepository extends JpaRepository<Invoice, String> {
}
