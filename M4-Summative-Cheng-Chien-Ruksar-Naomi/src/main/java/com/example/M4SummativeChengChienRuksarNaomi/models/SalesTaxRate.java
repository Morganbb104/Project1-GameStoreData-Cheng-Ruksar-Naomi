package com.example.M4SummativeChengChienRuksarNaomi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "sales_tax_rate")
public class SalesTaxRate {

    @NotNull
    @Size(min = 2, max = 2)
    public String state;

    @NotNull
    public BigDecimal rate;

    public SalesTaxRate(String state, BigDecimal rate) {
        this.state = state;
        this.rate = rate;
    }

    public SalesTaxRate() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
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
