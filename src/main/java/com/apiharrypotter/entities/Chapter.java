package com.harrypotter.apirest.entities;

import javax.persistence.*;

@Entity
@Table(name = "Chapter")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Chapter Name")
    private String name;

    public Chapter() {}

    public Chapter(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
