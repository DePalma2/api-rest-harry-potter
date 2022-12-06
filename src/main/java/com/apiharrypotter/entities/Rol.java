package com.apiharrypotter.entities;

import com.apiharrypotter.enums.ERoles;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private ERoles roleName;

    public Rol() {}

    public Rol(@NotNull ERoles roleName) {
        this.roleName = roleName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERoles getRoleName() {
        return roleName;
    }

    public void setRoleName(ERoles roleName) {
        this.roleName = roleName;
    }
}
