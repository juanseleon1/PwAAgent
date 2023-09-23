
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
@Table(name = "preferencia_x_baile")

@NamedQueries({
    @NamedQuery(name = "PreferenciaXBaile.findAll", query = "SELECT p FROM PreferenciaXBaile p"),
    @NamedQuery(name = "PreferenciaXBaile.findByBaileId", query = "SELECT p FROM PreferenciaXBaile p WHERE p.preferenciaXBailePK.baileId = :baileId"),
    @NamedQuery(name = "PreferenciaXBaile.findByPreferenciaPwaCedula", query = "SELECT p FROM PreferenciaXBaile p WHERE p.preferenciaXBailePK.preferenciaPwaCedula = :preferenciaPwaCedula"),
    @NamedQuery(name = "PreferenciaXBaile.findByGusto", query = "SELECT p FROM PreferenciaXBaile p WHERE p.gusto = :gusto")})
public class PreferenciaXBaile implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PreferenciaXBailePK preferenciaXBailePK;
    @Basic(optional = false)
    @Column(name = "gusto")
    private double gusto;
    @JoinColumn(name = "baile_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Baile baile;
    @JoinColumn(name = "preferencia_pwa_cedula", referencedColumnName = "perfil_pwa_cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PwAPreferenceContext PwAPreferenceContext;

    public PreferenciaXBaile() {
    }

    public PreferenciaXBaile(PreferenciaXBailePK preferenciaXBailePK) {
        this.preferenciaXBailePK = preferenciaXBailePK;
    }

    public PreferenciaXBaile(PreferenciaXBailePK preferenciaXBailePK, double gusto) {
        this.preferenciaXBailePK = preferenciaXBailePK;
        this.gusto = gusto;
    }

    public PreferenciaXBaile(int baileId, String preferenciaPwaCedula) {
        this.preferenciaXBailePK = new PreferenciaXBailePK(baileId, preferenciaPwaCedula);
    }

    public PreferenciaXBailePK getPreferenciaXBailePK() {
        return preferenciaXBailePK;
    }

    public void setPreferenciaXBailePK(PreferenciaXBailePK preferenciaXBailePK) {
        this.preferenciaXBailePK = preferenciaXBailePK;
    }

    public double getGusto() {
        return gusto;
    }

    public void setGusto(double gusto) {
        this.gusto = gusto;
    }

    public Baile getBaile() {
        return baile;
    }

    public void setBaile(Baile baile) {
        this.baile = baile;
    }

    public PwAPreferenceContext getPwAPreferenceContext() {
        return PwAPreferenceContext;
    }

    public void setPwAPreferenceContext(PwAPreferenceContext PwAPreferenceContext) {
        this.PwAPreferenceContext = PwAPreferenceContext;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preferenciaXBailePK != null ? preferenciaXBailePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreferenciaXBaile)) {
            return false;
        }
        PreferenciaXBaile other = (PreferenciaXBaile) object;
        if ((this.preferenciaXBailePK == null && other.preferenciaXBailePK != null) || (this.preferenciaXBailePK != null && !this.preferenciaXBailePK.equals(other.preferenciaXBailePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.PreferenciaXBaile[ preferenciaXBailePK=" + preferenciaXBailePK + " ]";
    }
    
}
