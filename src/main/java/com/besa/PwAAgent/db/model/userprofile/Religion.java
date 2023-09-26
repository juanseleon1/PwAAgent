package com.besa.PwAAgent.db.model.userprofile;

import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Religion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private String name;
    @Basic
    private String libro;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Versiculo> versiculos;
    @Basic
    private String oracion;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLibro() {
        return libro;
    }
    public void setLibro(String libro) {
        this.libro = libro;
    }
    public List<Versiculo> getVersiculos() {
        return versiculos;
    }
    public void setVersiculos(List<Versiculo> versiculos) {
        this.versiculos = versiculos;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getOracion() {
        return oracion;
    }
    public void setOracion(String oracion) {
        this.oracion = oracion;
    }

}
