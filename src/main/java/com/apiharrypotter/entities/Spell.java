package com.apiharrypotter.entities;;

import javax.persistence.*;

@Entity
@Table(name = "Spells")
public class Spell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String incantation;
    private String type;
    private String effect;
    private String light;

    public Spell() {}

    public Spell(Long id, String name, String incantation, String type, String effect, String light) {
        this.id = id;
        this.name = name;
        this.incantation = incantation;
        this.type = type;
        this.effect = effect;
        this.light = light;
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

    public String getIncantation() {
        return incantation;
    }

    public void setIncantation(String incantation) {
        this.incantation = incantation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }
}
