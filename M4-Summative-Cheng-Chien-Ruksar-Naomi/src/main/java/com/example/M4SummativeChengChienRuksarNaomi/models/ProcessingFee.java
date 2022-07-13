package com.example.M4SummativeChengChienRuksarNaomi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "processing_fee")
public class ProcessingFee {

    @NotNull
    @Column(name = "product_type")
    private String productType;

    private double fee;

    public ProcessingFee(String productType, double fee) {
        this.productType = productType;
        this.fee = fee;
    }

    public ProcessingFee() {
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProcessingFee)) return false;
        ProcessingFee that = (ProcessingFee) o;
        return Double.compare(that.getFee(), getFee()) == 0 && Objects.equals(getProductType(), that.getProductType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductType(), getFee());
    }

    @Override
    public String toString() {
        return "ProcessingFee{" +
                "productType='" + productType + '\'' +
                ", fee=" + fee +
                '}';
    }
}
