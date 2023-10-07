package com.besa.PwAAgent.db.model.userprofile;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Versiculo {
    @Id
    private int id;
    @Basic
    @Column(length = 1000)
    private String texto;
    @Basic
    @Column(length = 65)
    private String informacion;

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public String getInformacion() {
        return informacion;
    }
    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }


    
}
