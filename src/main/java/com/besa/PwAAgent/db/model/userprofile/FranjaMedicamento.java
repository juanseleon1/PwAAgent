package com.besa.PwAAgent.db.model.userprofile;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
    @Basic
    private boolean isDone;
    @Column(nullable = false)
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

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        this.isDone = done;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        String horaFormateada = hora.format(formatter);

        StringBuilder sb = new StringBuilder();
        sb.append("Hora: ").append(horaFormateada).append("\n");
        sb.append("Completado: ").append(isDone).append("\n");
        sb.append("Dosis:\n");
        for (Dosis dosis : this.dosis) {
            sb.append(dosis.toString()).append("\n");
        }
        return sb.toString();
    }

}
