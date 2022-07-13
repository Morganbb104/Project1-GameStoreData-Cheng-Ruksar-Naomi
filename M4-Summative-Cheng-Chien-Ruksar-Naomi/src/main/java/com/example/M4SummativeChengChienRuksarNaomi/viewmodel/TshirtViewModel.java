package com.example.M4SummativeChengChienRuksarNaomi.viewmodel;

import com.example.M4SummativeChengChienRuksarNaomi.models.Tshirt;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class TshirtViewModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_shirt_id")
    @NotNull
    private Integer id;

    @NotNull
    private String size;

    @NotNull
    private String color;

    @NotNull
    private String description;

    @NotNull
    private double price;

    @NotNull
    private int quantity;

    public TshirtViewModel(Integer id, String size, String color, String description, double price, int quantity) {
        this.id = id;
        this.size = size;
        this.color = color;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public TshirtViewModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tshirt)) return false;
        Tshirt tshirt = (Tshirt) o;
        return Double.compare(tshirt.getPrice(), getPrice()) == 0 && getQuantity() == tshirt.getQuantity() && Objects.equals(getId(), tshirt.getId()) && Objects.equals(getSize(), tshirt.getSize()) && Objects.equals(getColor(), tshirt.getColor()) && Objects.equals(getDescription(), tshirt.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSize(), getColor(), getDescription(), getPrice(), getQuantity());
    }

    @Override
    public String toString() {
        return "Tshirt{" +
                "id=" + id +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
