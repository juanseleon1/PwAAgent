
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

}
