
package com.besa.PwAAgent.db.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "frase")

@NamedQueries({
    @NamedQuery(name = "Frase.findAll", query = "SELECT f FROM Frase f"),
    @NamedQuery(name = "Frase.findByOrden", query = "SELECT f FROM Frase f WHERE f.frasePK.orden = :orden"),
    @NamedQuery(name = "Frase.findByCuentoNombre", query = "SELECT f FROM Frase f WHERE f.frasePK.cuentoNombre = :cuentoNombre"),
    @NamedQuery(name = "Frase.findByContenido", query = "SELECT f FROM Frase f WHERE f.contenido = :contenido"),
    @NamedQuery(name = "Frase.findByEmotionalEvent", query = "SELECT f FROM Frase f WHERE f.emotionalEvent = :emotionalEvent"),
    @NamedQuery(name = "Frase.findByAccion", query = "SELECT f FROM Frase f WHERE f.accion = :accion"),
    @NamedQuery(name = "Frase.findByUrlImagen", query = "SELECT f FROM Frase f WHERE f.urlImagen = :urlImagen")})
public class Frase implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FrasePK frasePK;
    @Basic(optional = false)
    @Column(name = "contenido")
    private String contenido;
    @Column(name = "emotional_event")
    private String emotionalEvent;
    @Column(name = "accion")
    private String accion;
    @Column(name = "url_imagen")
    private String urlImagen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "frase", fetch = FetchType.EAGER)
    private List<Enriq> enriqList;
    @JoinColumn(name = "cuento_nombre", referencedColumnName = "nombre", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cuento cuento;

    public Frase() {
    }

    public Frase(FrasePK frasePK) {
        this.frasePK = frasePK;
    }

    public Frase(FrasePK frasePK, String contenido) {
        this.frasePK = frasePK;
        this.contenido = contenido;
    }

    public Frase(int orden, String cuentoNombre) {
        this.frasePK = new FrasePK(orden, cuentoNombre);
    }

    public FrasePK getFrasePK() {
        return frasePK;
    }

    public void setFrasePK(FrasePK frasePK) {
        this.frasePK = frasePK;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getEmotionalEvent() {
        return emotionalEvent;
    }

    public void setEmotionalEvent(String emotionalEvent) {
        this.emotionalEvent = emotionalEvent;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    
    public List<Enriq> getEnriqList() {
        return enriqList;
    }

    public void setEnriqList(List<Enriq> enriqList) {
        this.enriqList = enriqList;
    }

    public Cuento getCuento() {
        return cuento;
    }

    public void setCuento(Cuento cuento) {
        this.cuento = cuento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (frasePK != null ? frasePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Frase)) {
            return false;
        }
        Frase other = (Frase) object;
        if ((this.frasePK == null && other.frasePK != null) || (this.frasePK != null && !this.frasePK.equals(other.frasePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.Frase[ frasePK=" + frasePK + " ]";
    }
    
}
