package com.example.M4SummativeChengChienRuksarNaomi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "game")
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private int id;
    @Column(name = "esrb_rating")
    private String esrbRating;
    private String title;
    private String description;
    private double decimal;
    private String studio;
    private int quantity;

    public int getId() {
        return id;
    }

    public Games() {
    }

    public Games(int id, String esrbRating, String title, String description, double decimal, String studio, int quantity) {
        this.id = id;
        this.esrbRating = esrbRating;
        this.title = title;
        this.description = description;
        this.decimal = decimal;
        this.studio = studio;
        this.quantity = quantity;
    }

    public void setId(int id) {
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

    public double getDecimal() {
        return decimal;
    }

    public void setDecimal(double decimal) {
        this.decimal = decimal;
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
        Games games = (Games) o;
        return id == games.id && Double.compare(games.decimal, decimal) == 0 && quantity == games.quantity && Objects.equals(esrbRating, games.esrbRating) && Objects.equals(title, games.title) && Objects.equals(description, games.description) && Objects.equals(studio, games.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, esrbRating, title, description, decimal, studio, quantity);
    }

    @Override
    public String toString() {
        return "Games{" +
                "id=" + id +
                ", esrbRating='" + esrbRating + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", decimal=" + decimal +
                ", studio='" + studio + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
