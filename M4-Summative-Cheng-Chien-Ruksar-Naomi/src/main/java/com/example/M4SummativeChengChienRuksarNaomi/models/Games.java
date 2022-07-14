package com.example.M4SummativeChengChienRuksarNaomi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "game")
public class Games {
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
    private double decimal;
    @NotNull
    private String studio;
    @NotNull
    private int quantity;

    public Games(Integer id, String esrbRating, String title, String description, double decimal, String studio, int quantity) {
        this.id = id;
        this.esrbRating = esrbRating;
        this.title = title;
        this.description = description;
        this.decimal = decimal;
        this.studio = studio;
        this.quantity = quantity;
    }

    public Games() {
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
        if (!(o instanceof Games)) return false;
        Games games = (Games) o;
        return Double.compare(games.getPrice(), getPrice()) == 0 && getQuantity() == games.getQuantity() && Objects.equals(getId(), games.getId()) && Objects.equals(getEsrbRating(), games.getEsrbRating()) && Objects.equals(getTitle(), games.getTitle()) && Objects.equals(getDescription(), games.getDescription()) && Objects.equals(getStudio(), games.getStudio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEsrbRating(), getTitle(), getDescription(), getPrice(), getStudio(), getQuantity());
    }

    @Override
    public String toString() {
        return "Games{" +
                "id=" + id +
                ", esrbRating='" + esrbRating + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + decimal +
                ", studio='" + studio + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
