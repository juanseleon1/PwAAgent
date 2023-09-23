
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
@Table(name = "act_x_preferencia")

@NamedQueries({
    @NamedQuery(name = "ActXPreferencia.findAll", query = "SELECT a FROM ActXPreferencia a"),
    @NamedQuery(name = "ActXPreferencia.findByActividadPwaId", query = "SELECT a FROM ActXPreferencia a WHERE a.actXPreferenciaPK.actividadPwaId = :actividadPwaId"),
    @NamedQuery(name = "ActXPreferencia.findByPreferenciaPwaCedula", query = "SELECT a FROM ActXPreferencia a WHERE a.actXPreferenciaPK.preferenciaPwaCedula = :preferenciaPwaCedula"),
    @NamedQuery(name = "ActXPreferencia.findByActiva", query = "SELECT a FROM ActXPreferencia a WHERE a.activa = :activa"),
    @NamedQuery(name = "ActXPreferencia.findByGusto", query = "SELECT a FROM ActXPreferencia a WHERE a.gusto = :gusto"),
    @NamedQuery(name = "ActXPreferencia.findByEnriq", query = "SELECT a FROM ActXPreferencia a WHERE a.enriq = :enriq")})
public class ActXPreferencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActXPreferenciaPK actXPreferenciaPK;
    @Basic(optional = false)
    @Column(name = "activa")
    private double activa;
    @Basic(optional = false)
    @Column(name = "gusto")
    private double gusto;
    @Column(name = "enriq")
    private String enriq;
    @JoinColumn(name = "actividad_pwa_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ActividadPwa actividadPwa;
    @JoinColumn(name = "preferencia_pwa_cedula", referencedColumnName = "perfil_pwa_cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PwAPreferenceContext pwaPreferenceContext;

    public ActXPreferencia() {
    }

    public ActXPreferencia(ActXPreferenciaPK actXPreferenciaPK) {
        this.actXPreferenciaPK = actXPreferenciaPK;
    }

    public ActXPreferencia(ActXPreferenciaPK actXPreferenciaPK, double activa, double gusto) {
        this.actXPreferenciaPK = actXPreferenciaPK;
        this.activa = activa;
        this.gusto = gusto;
    }

    public ActXPreferencia(int actividadPwaId, String preferenciaPwaCedula) {
        this.actXPreferenciaPK = new ActXPreferenciaPK(actividadPwaId, preferenciaPwaCedula);
    }

    public ActXPreferenciaPK getActXPreferenciaPK() {
        return actXPreferenciaPK;
    }

    public void setActXPreferenciaPK(ActXPreferenciaPK actXPreferenciaPK) {
        this.actXPreferenciaPK = actXPreferenciaPK;
    }

    public double getActiva() {
        return activa;
    }

    public void setActiva(double activa) {
        this.activa = activa;
    }

    public double getGusto() {
        return gusto;
    }

    public void setGusto(double gusto) {
        this.gusto = gusto;
    }

    public String getEnriq() {
        return enriq;
    }

    public void setEnriq(String enriq) {
        this.enriq = enriq;
    }

    public ActividadPwa getActividadPwa() {
        return actividadPwa;
    }

    public void setActividadPwa(ActividadPwa actividadPwa) {
        this.actividadPwa = actividadPwa;
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
        hash += (actXPreferenciaPK != null ? actXPreferenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActXPreferencia)) {
            return false;
        }
        ActXPreferencia other = (ActXPreferencia) object;
        if ((this.actXPreferenciaPK == null && other.actXPreferenciaPK != null) || (this.actXPreferenciaPK != null && !this.actXPreferenciaPK.equals(other.actXPreferenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.ActXPreferencia[ actXPreferenciaPK=" + actXPreferenciaPK + " ]";
    }
    
}
