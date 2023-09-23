
package com.besa.PwAAgent.db.model;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class PreferenciaXBailePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "baile_id")
    private int baileId;
    @Basic(optional = false)
    @Column(name = "preferencia_pwa_cedula")
    private String preferenciaPwaCedula;

    public PreferenciaXBailePK() {
    }

    public PreferenciaXBailePK(int baileId, String preferenciaPwaCedula) {
        this.baileId = baileId;
        this.preferenciaPwaCedula = preferenciaPwaCedula;
    }

    public int getBaileId() {
        return baileId;
    }

    public void setBaileId(int baileId) {
        this.baileId = baileId;
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
        hash += (int) baileId;
        hash += (preferenciaPwaCedula != null ? preferenciaPwaCedula.hashCode() : 0);
        return hash;
    }

}
