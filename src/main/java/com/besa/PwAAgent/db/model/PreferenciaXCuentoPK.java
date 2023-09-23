
package com.besa.PwAAgent.db.model;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class PreferenciaXCuentoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cuento_nombre")
    private String cuentoNombre;
    @Basic(optional = false)
    @Column(name = "preferencia_pwa_cedula")
    private String preferenciaPwaCedula;

    public PreferenciaXCuentoPK() {
    }

    public PreferenciaXCuentoPK(String cuentoNombre, String preferenciaPwaCedula) {
        this.cuentoNombre = cuentoNombre;
        this.preferenciaPwaCedula = preferenciaPwaCedula;
    }

    public String getCuentoNombre() {
        return cuentoNombre;
    }

    public void setCuentoNombre(String cuentoNombre) {
        this.cuentoNombre = cuentoNombre;
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
        hash += (cuentoNombre != null ? cuentoNombre.hashCode() : 0);
        hash += (preferenciaPwaCedula != null ? preferenciaPwaCedula.hashCode() : 0);
        return hash;
    }

}
