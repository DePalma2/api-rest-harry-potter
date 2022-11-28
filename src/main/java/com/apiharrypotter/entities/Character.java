package com.apiharrypotter.entities;

import javax.persistence.*;

@Entity
@Table(name = "person_characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "person_name")
    private String name;
    private String gender;
    private String job;
    private String house;
    private String patronus;
    private String species;
    @Column(name = "blood_status")
    private String blood_status;
    @Column(name = "hair_colour")
    private String hair_colour;
    @Column(name = "eye_colour")
    private String eye_colour;
    private String loyalty;
    private String skills;
    @Column(name = "date_birth")
    private String birth;
    private String death;

    public Character() {}

    public Character(Long id, String name, String gender, String job, String house, String patronus, String species, String blood_status, String hair_colour, String eye_colour, String loyalty, String skills, String birth, String death) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.job = job;
        this.house = house;
        this.patronus = patronus;
        this.species = species;
        this.blood_status = blood_status;
        this.hair_colour = hair_colour;
        this.eye_colour = eye_colour;
        this.loyalty = loyalty;
        this.skills = skills;
        this.birth = birth;
        this.death = death;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getPatronus() {
        return patronus;
    }

    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBlood_status() {
        return blood_status;
    }

    public void setBlood_status(String blood_status) {
        this.blood_status = blood_status;
    }

    public String getHair_colour() {
        return hair_colour;
    }

    public void setHair_colour(String hair_colour) {
        this.hair_colour = hair_colour;
    }

    public String getEye_colour() {
        return eye_colour;
    }

    public void setEye_colour(String eye_colour) {
        this.eye_colour = eye_colour;
    }

    public String getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(String loyalty) {
        this.loyalty = loyalty;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }
}
