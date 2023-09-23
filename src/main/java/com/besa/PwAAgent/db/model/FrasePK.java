
package com.besa.PwAAgent.db.model;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class FrasePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "orden")
    private int orden;
    @Basic(optional = false)
    @Column(name = "cuento_nombre")
    private String cuentoNombre;

    public FrasePK() {
    }

    public FrasePK(int orden, String cuentoNombre) {
        this.orden = orden;
        this.cuentoNombre = cuentoNombre;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getCuentoNombre() {
        return cuentoNombre;
    }

    public void setCuentoNombre(String cuentoNombre) {
        this.cuentoNombre = cuentoNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) orden;
        hash += (cuentoNombre != null ? cuentoNombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof FrasePK)) {
            return false;
        }
        FrasePK other = (FrasePK) object;
        if (this.orden != other.orden) {
            return false;
        }
        if ((this.cuentoNombre == null && other.cuentoNombre != null) || (this.cuentoNombre != null && !this.cuentoNombre.equals(other.cuentoNombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.FrasePK[ orden=" + orden + ", cuentoNombre=" + cuentoNombre + " ]";
    }
    
}
