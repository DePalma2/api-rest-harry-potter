package com.apiharrypotter.entities;

import javax.persistence.*;

@Entity
@Table(name = "Potion")
public class Potion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String ingredients;
    private String effects;
    private String characteristics;
    @Column(name = "Difficulty level")
    private String level;

    public Potion() {}

    public Potion(Long id, String name, String ingredients, String effects, String characteristics, String level) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.effects = effects;
        this.characteristics = characteristics;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getEffects() {
        return effects;
    }

    public void setEffects(String effects) {
        this.effects = effects;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
