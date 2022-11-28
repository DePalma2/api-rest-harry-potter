package com.apiharrypotter.entities;

import javax.persistence.*;

@Entity
@Table(name = "house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "house_name")
    private String name;
    @Column(name = "founder_name")
    private String founder;
    @Column(name = "house_colour")
    private String colour;
    @Column(name = "house_traits")
    private String traits;
    @Column(name = "common_room")
    private String commonRoom;
    @Column(name = "house_image")
    private String img;
    @Column(name = "house_animal")
    private String animal;

    public House() {}

    public House(Long id, String name, String founder, String colour, String traits, String commonRoom, String img, String animal) {
        this.id = id;
        this.name = name;
        this.founder = founder;
        this.colour = colour;
        this.traits = traits;
        this.commonRoom = commonRoom;
        this.img = img;
        this.animal = animal;
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

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getTraits() {
        return traits;
    }

    public void setTraits(String traits) {
        this.traits = traits;
    }

    public String getCommonRoom() {
        return commonRoom;
    }

    public void setCommonRoom(String commonRoom) {
        this.commonRoom = commonRoom;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }
}
