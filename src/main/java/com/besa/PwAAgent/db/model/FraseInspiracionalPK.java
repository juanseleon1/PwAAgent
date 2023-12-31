
package com.besa.PwAAgent.db.model;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class FraseInspiracionalPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "ejercicio")
    private String ejercicio;

    public FraseInspiracionalPK() {
    }

    public FraseInspiracionalPK(int id, String ejercicio) {
        this.id = id;
        this.ejercicio = ejercicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(String ejercicio) {
        this.ejercicio = ejercicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (ejercicio != null ? ejercicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof FraseInspiracionalPK)) {
            return false;
        }
        FraseInspiracionalPK other = (FraseInspiracionalPK) object;
        if (this.id != other.id) {
            return false;
        }
        if ((this.ejercicio == null && other.ejercicio != null) || (this.ejercicio != null && !this.ejercicio.equals(other.ejercicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.FraseInspiracionalPK[ id=" + id + ", ejercicio=" + ejercicio + " ]";
    }
    
}
