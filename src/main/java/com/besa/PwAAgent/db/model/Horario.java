
package com.besa.PwAAgent.db.model;

import java.io.Serializable;

import com.besa.PwAAgent.db.model.userprofile.PwAExerciseProfile;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;



@Entity
@Table(name = "horario")

@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h"),
    @NamedQuery(name = "Horario.findByIndice", query = "SELECT h FROM Horario h WHERE h.indice = :indice"),
    @NamedQuery(name = "Horario.findByHora", query = "SELECT h FROM Horario h WHERE h.hora = :hora")})
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "indice")
    private Integer indice;
    @Basic(optional = false)
    @Column(name = "hora")
    private int hora;
    @JoinColumn(name = "cedula", referencedColumnName = "perfil_pwa_cedula")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PwAExerciseProfile cedula;

    public Horario() {
    }

    public Horario(Integer indice) {
        this.indice = indice;
    }

    public Horario(Integer indice, int hora) {
        this.indice = indice;
        this.hora = hora;
    }

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public PwAExerciseProfile getCedula() {
        return cedula;
    }

    public void setCedula(PwAExerciseProfile cedula) {
        this.cedula = cedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (indice != null ? indice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.indice == null && other.indice != null) || (this.indice != null && !this.indice.equals(other.indice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.Horario[ indice=" + indice + " ]";
    }
    
}
