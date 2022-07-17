package com.example.M4SummativeChengChienRuksarNaomi.repository;

import com.example.M4SummativeChengChienRuksarNaomi.models.Console;
import com.example.M4SummativeChengChienRuksarNaomi.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
@Repository
public interface SalesTaxRateRepository extends JpaRepository<Invoice, String> {


=======
import java.util.List;
>>>>>>> 24c0a95e4dd16baef6a64a3fcf91f73e6b882d60

@Repository
public interface SalesTaxRateRepository extends JpaRepository<Invoice, String> {
}
