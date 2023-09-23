
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
@Table(name = "preferencia_x_cancion")

@NamedQueries({
    @NamedQuery(name = "PreferenciaXCancion.findAll", query = "SELECT p FROM PreferenciaXCancion p"),
    @NamedQuery(name = "PreferenciaXCancion.findByCancionNombre", query = "SELECT p FROM PreferenciaXCancion p WHERE p.preferenciaXCancionPK.cancionNombre = :cancionNombre"),
    @NamedQuery(name = "PreferenciaXCancion.findByPreferenciaPwaCedula", query = "SELECT p FROM PreferenciaXCancion p WHERE p.preferenciaXCancionPK.preferenciaPwaCedula = :preferenciaPwaCedula"),
    @NamedQuery(name = "PreferenciaXCancion.findByGusto", query = "SELECT p FROM PreferenciaXCancion p WHERE p.gusto = :gusto"),
    @NamedQuery(name = "PreferenciaXCancion.findByReminiscencia", query = "SELECT p FROM PreferenciaXCancion p WHERE p.reminiscencia = :reminiscencia")})
public class PreferenciaXCancion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PreferenciaXCancionPK preferenciaXCancionPK;
    @Basic(optional = false)
    @Column(name = "gusto")
    private double gusto;
    @Basic(optional = false)
    @Column(name = "reminiscencia")
    private int reminiscencia;
    @JoinColumn(name = "cancion_nombre", referencedColumnName = "nombre", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cancion cancion;
    @JoinColumn(name = "preferencia_pwa_cedula", referencedColumnName = "perfil_pwa_cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PwAPreferenceContext pwaPreferenceContext;

    public PreferenciaXCancion() {
    }

    public PreferenciaXCancion(PreferenciaXCancionPK preferenciaXCancionPK) {
        this.preferenciaXCancionPK = preferenciaXCancionPK;
    }

    public PreferenciaXCancion(PreferenciaXCancionPK preferenciaXCancionPK, double gusto, int reminiscencia) {
        this.preferenciaXCancionPK = preferenciaXCancionPK;
        this.gusto = gusto;
        this.reminiscencia = reminiscencia;
    }

    public PreferenciaXCancion(String cancionNombre, String preferenciaPwaCedula) {
        this.preferenciaXCancionPK = new PreferenciaXCancionPK(cancionNombre, preferenciaPwaCedula);
    }

    public PreferenciaXCancionPK getPreferenciaXCancionPK() {
        return preferenciaXCancionPK;
    }

    public void setPreferenciaXCancionPK(PreferenciaXCancionPK preferenciaXCancionPK) {
        this.preferenciaXCancionPK = preferenciaXCancionPK;
    }

    public double getGusto() {
        return gusto;
    }

    public void setGusto(double gusto) {
        this.gusto = gusto;
    }

    public int getReminiscencia() {
        return reminiscencia;
    }

    public void setReminiscencia(int reminiscencia) {
        this.reminiscencia = reminiscencia;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
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
        hash += (preferenciaXCancionPK != null ? preferenciaXCancionPK.hashCode() : 0);
        return hash;
    }

}
