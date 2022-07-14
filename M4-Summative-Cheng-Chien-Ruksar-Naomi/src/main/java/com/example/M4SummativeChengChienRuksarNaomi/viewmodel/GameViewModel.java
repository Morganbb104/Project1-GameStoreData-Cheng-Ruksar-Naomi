package com.example.M4SummativeChengChienRuksarNaomi.viewmodel;

import com.example.M4SummativeChengChienRuksarNaomi.models.Games;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class GameViewModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    @NotNull
    private Integer id;
    @Column(name = "esrb_rating")
    @NotNull
    private String esrbRating;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private double price;
    @NotNull
    private String studio;
    @NotNull
    private int quantity;


    public GameViewModel() {
    }

    public GameViewModel(Integer id, String esrbRating, String title, String description, double price, String studio, int quantity) {
        this.id = id;
        this.esrbRating = esrbRating;
        this.title = title;
        this.description = description;
        this.price = price;
        this.studio = studio;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(String esrbRating) {
        this.esrbRating = esrbRating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
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
        if (o == null || getClass() != o.getClass()) return false;
        GameViewModel that = (GameViewModel) o;
        return Double.compare(that.price, price) == 0 && quantity == that.quantity && Objects.equals(id, that.id) && Objects.equals(esrbRating, that.esrbRating) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(studio, that.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, esrbRating, title, description, price, studio, quantity);
    }

    @Override
    public String toString() {
        return "GameViewModel{" +
                "id=" + id +
                ", esrbRating='" + esrbRating + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", studio='" + studio + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

