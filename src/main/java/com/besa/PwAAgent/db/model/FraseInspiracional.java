
package com.besa.PwAAgent.db.model;

import java.io.Serializable;
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
@Table(name = "frase_inspiracional")

@NamedQueries({
    @NamedQuery(name = "FraseInspiracional.findAll", query = "SELECT f FROM FraseInspiracional f"),
    @NamedQuery(name = "FraseInspiracional.findById", query = "SELECT f FROM FraseInspiracional f WHERE f.fraseInspiracionalPK.id = :id"),
    @NamedQuery(name = "FraseInspiracional.findByEjercicio", query = "SELECT f FROM FraseInspiracional f WHERE f.fraseInspiracionalPK.ejercicio = :ejercicio"),
    @NamedQuery(name = "FraseInspiracional.findByContenidos", query = "SELECT f FROM FraseInspiracional f WHERE f.contenidos = :contenidos"),
    @NamedQuery(name = "FraseInspiracional.findByTiempoEjecucion", query = "SELECT f FROM FraseInspiracional f WHERE f.tiempoEjecucion = :tiempoEjecucion"),
    @NamedQuery(name = "FraseInspiracional.findByPwaEmocion", query = "SELECT f FROM FraseInspiracional f WHERE f.pwaEmocion = :pwaEmocion")})
public class FraseInspiracional implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FraseInspiracionalPK fraseInspiracionalPK;
    @Basic(optional = false)
    @Column(name = "contenidos")
    private String contenidos;
    @Basic(optional = false)
    @Column(name = "tiempo_ejecucion")
    private double tiempoEjecucion;
    @Basic(optional = false)
    @Column(name = "pwa_emocion")
    private String pwaEmocion;
    @JoinColumn(name = "ejercicio", referencedColumnName = "nombre", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Ejercicio ejercicio1;

    public FraseInspiracional() {
    }

    public FraseInspiracional(FraseInspiracionalPK fraseInspiracionalPK) {
        this.fraseInspiracionalPK = fraseInspiracionalPK;
    }

    public FraseInspiracional(FraseInspiracionalPK fraseInspiracionalPK, String contenidos, double tiempoEjecucion, String pwaEmocion) {
        this.fraseInspiracionalPK = fraseInspiracionalPK;
        this.contenidos = contenidos;
        this.tiempoEjecucion = tiempoEjecucion;
        this.pwaEmocion = pwaEmocion;
    }

    public FraseInspiracional(int id, String ejercicio) {
        this.fraseInspiracionalPK = new FraseInspiracionalPK(id, ejercicio);
    }

    public FraseInspiracionalPK getFraseInspiracionalPK() {
        return fraseInspiracionalPK;
    }

    public void setFraseInspiracionalPK(FraseInspiracionalPK fraseInspiracionalPK) {
        this.fraseInspiracionalPK = fraseInspiracionalPK;
    }

    public String getContenidos() {
        return contenidos;
    }

    public void setContenidos(String contenidos) {
        this.contenidos = contenidos;
    }

    public double getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(double tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public String getPwaEmocion() {
        return pwaEmocion;
    }

    public void setPwaEmocion(String pwaEmocion) {
        this.pwaEmocion = pwaEmocion;
    }

    public Ejercicio getEjercicio1() {
        return ejercicio1;
    }

    public void setEjercicio1(Ejercicio ejercicio1) {
        this.ejercicio1 = ejercicio1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fraseInspiracionalPK != null ? fraseInspiracionalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof FraseInspiracional)) {
            return false;
        }
        FraseInspiracional other = (FraseInspiracional) object;
        if ((this.fraseInspiracionalPK == null && other.fraseInspiracionalPK != null) || (this.fraseInspiracionalPK != null && !this.fraseInspiracionalPK.equals(other.fraseInspiracionalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.FraseInspiracional[ fraseInspiracionalPK=" + fraseInspiracionalPK + " ]";
    }
    
}
