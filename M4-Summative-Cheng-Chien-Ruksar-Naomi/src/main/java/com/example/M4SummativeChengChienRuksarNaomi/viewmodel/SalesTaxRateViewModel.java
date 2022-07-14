package com.example.M4SummativeChengChienRuksarNaomi.viewmodel;

import com.example.M4SummativeChengChienRuksarNaomi.models.SalesTaxRate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class SalesTaxRateViewModel {

    @NotNull
    @Size(min = 2, max = 2)
    private String state;

    @NotNull
    private BigDecimal rate;

    public void SalesTaxRate(String state, BigDecimal rate) {
        this.state = state;
        this.rate = rate;
    }

    public void SalesTaxRate() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesTaxRate)) return false;
        SalesTaxRate that = (SalesTaxRate) o;
        return Objects.equals(state, that.state) && Objects.equals(rate, that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, rate);
    }

    @Override
    public String toString() {
        return "SalesTaxRate{" +
                "state='" + state + '\'' +
                ", rate=" + rate +
                '}';
    }
}

