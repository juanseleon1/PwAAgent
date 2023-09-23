
package com.besa.PwAAgent.db.model;

import java.io.Serializable;

import com.besa.PwAAgent.db.model.userprofile.PwAPreferenceContext;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;



@Entity
@Table(name = "preferencia_x_cuento")

@NamedQueries({
    @NamedQuery(name = "PreferenciaXCuento.findAll", query = "SELECT p FROM PreferenciaXCuento p"),
    @NamedQuery(name = "PreferenciaXCuento.findByCuentoNombre", query = "SELECT p FROM PreferenciaXCuento p WHERE p.preferenciaXCuentoPK.cuentoNombre = :cuentoNombre"),
    @NamedQuery(name = "PreferenciaXCuento.findByPreferenciaPwaCedula", query = "SELECT p FROM PreferenciaXCuento p WHERE p.preferenciaXCuentoPK.preferenciaPwaCedula = :preferenciaPwaCedula"),
    @NamedQuery(name = "PreferenciaXCuento.findByGusto", query = "SELECT p FROM PreferenciaXCuento p WHERE p.gusto = :gusto")})
public class PreferenciaXCuento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PreferenciaXCuentoPK preferenciaXCuentoPK;
    @Basic(optional = false)
    @Column(name = "gusto")
    private double gusto;
    @JoinColumn(name = "cuento_nombre", referencedColumnName = "nombre", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cuento cuento;
    @JoinColumn(name = "preferencia_pwa_cedula", referencedColumnName = "perfil_pwa_cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PwAPreferenceContext pwaPreferenceContext;

    public PreferenciaXCuento() {
    }

    public PreferenciaXCuento(PreferenciaXCuentoPK preferenciaXCuentoPK) {
        this.preferenciaXCuentoPK = preferenciaXCuentoPK;
    }

    public PreferenciaXCuento(PreferenciaXCuentoPK preferenciaXCuentoPK, double gusto) {
        this.preferenciaXCuentoPK = preferenciaXCuentoPK;
        this.gusto = gusto;
    }

    public PreferenciaXCuento(String cuentoNombre, String preferenciaPwaCedula) {
        this.preferenciaXCuentoPK = new PreferenciaXCuentoPK(cuentoNombre, preferenciaPwaCedula);
    }

    public PreferenciaXCuentoPK getPreferenciaXCuentoPK() {
        return preferenciaXCuentoPK;
    }

    public void setPreferenciaXCuentoPK(PreferenciaXCuentoPK preferenciaXCuentoPK) {
        this.preferenciaXCuentoPK = preferenciaXCuentoPK;
    }

    public double getGusto() {
        return gusto;
    }

    public void setGusto(double gusto) {
        this.gusto = gusto;
    }

    public Cuento getCuento() {
        return cuento;
    }

    public void setCuento(Cuento cuento) {
        this.cuento = cuento;
    }

    public PwAPreferenceContext getPwAPreferenceContext() {
        return pwaPreferenceContext;
    }

    public void setPwAPreferenceContext(PwAPreferenceContext pwaPreferenceContext) {
        this.pwaPreferenceContext = pwaPreferenceContext;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preferenciaXCuentoPK != null ? preferenciaXCuentoPK.hashCode() : 0);
        return hash;
    }
}
