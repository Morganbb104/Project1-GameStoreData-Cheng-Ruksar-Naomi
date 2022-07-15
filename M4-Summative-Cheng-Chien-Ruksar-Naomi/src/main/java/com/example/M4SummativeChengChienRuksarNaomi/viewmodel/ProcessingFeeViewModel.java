package com.example.M4SummativeChengChienRuksarNaomi.viewmodel;

import com.example.M4SummativeChengChienRuksarNaomi.models.ProcessingFee;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class ProcessingFeeViewModel extends InvoiceViewModel{

    @NotNull
    private String productType;

    private BigDecimal fee;

    public void ProcessingFee(String productType, BigDecimal fee) {
        this.productType = productType;
        this.fee = fee;
    }

    public void ProcessingFee() {
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProcessingFee)) return false;
        ProcessingFee that = (ProcessingFee) o;
        return Objects.equals(getProductType(), that.getProductType()) && Objects.equals(getFee(), that.getFee());
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
