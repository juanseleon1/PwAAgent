
package com.besa.PwAAgent.db.model;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class PreferenciaXCancionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cancion_nombre")
    private String cancionNombre;
    @Basic(optional = false)
    @Column(name = "preferencia_pwa_cedula")
    private String preferenciaPwaCedula;

    public PreferenciaXCancionPK() {
    }

    public PreferenciaXCancionPK(String cancionNombre, String preferenciaPwaCedula) {
        this.cancionNombre = cancionNombre;
        this.preferenciaPwaCedula = preferenciaPwaCedula;
    }

    public String getCancionNombre() {
        return cancionNombre;
    }

    public void setCancionNombre(String cancionNombre) {
        this.cancionNombre = cancionNombre;
    }

    public String getPreferenciaPwaCedula() {
        return preferenciaPwaCedula;
    }

    public void setPreferenciaPwaCedula(String preferenciaPwaCedula) {
        this.preferenciaPwaCedula = preferenciaPwaCedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cancionNombre != null ? cancionNombre.hashCode() : 0);
        hash += (preferenciaPwaCedula != null ? preferenciaPwaCedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreferenciaXCancionPK)) {
            return false;
        }
        PreferenciaXCancionPK other = (PreferenciaXCancionPK) object;
        if ((this.cancionNombre == null && other.cancionNombre != null) || (this.cancionNombre != null && !this.cancionNombre.equals(other.cancionNombre))) {
            return false;
        }
        if ((this.preferenciaPwaCedula == null && other.preferenciaPwaCedula != null) || (this.preferenciaPwaCedula != null && !this.preferenciaPwaCedula.equals(other.preferenciaPwaCedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.PreferenciaXCancionPK[ cancionNombre=" + cancionNombre + ", preferenciaPwaCedula=" + preferenciaPwaCedula + " ]";
    }
    
}
