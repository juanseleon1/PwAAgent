package com.besa.PwAAgent.db.model.userprofile;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class FranjaMedicamento {
    @Id
    private int id;
    @Basic
    private LocalTime hora;
    @Column(nullable= false)
	@OneToMany(fetch = FetchType.EAGER)
    private List<Dosis> dosis;

    public FranjaMedicamento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public List<Dosis> getDosis() {
        return dosis;
    }

    public void setDosis(List<Dosis> dosis) {
        this.dosis = dosis;
    }
}
