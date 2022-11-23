package com.harrypotter.apirest.entities;

import javax.persistence.*;

@Entity
@Table(name = "Places")
public class Places {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Place Name")
    private String name;
    @Column(name = "Place Category")
    private String category;

    public Places() {}

    public Places(Long id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
