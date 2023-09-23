
package com.besa.PwAAgent.db.model;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;



@Entity
@Table(name = "enriq")

@NamedQueries({
    @NamedQuery(name = "Enriq.findAll", query = "SELECT e FROM Enriq e"),
    @NamedQuery(name = "Enriq.findByParams", query = "SELECT e FROM Enriq e WHERE e.params = :params"),
    @NamedQuery(name = "Enriq.findByValor", query = "SELECT e FROM Enriq e WHERE e.valor = :valor")})
public class Enriq implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "params")
    private String params;
    @Basic(optional = false)
    @Column(name = "valor")
    private String valor;
    @JoinColumn(name = "cancion_nombre", referencedColumnName = "nombre")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cancion cancionNombre;
    @JoinColumns({
        @JoinColumn(name = "frase_orden", referencedColumnName = "orden"),
        @JoinColumn(name = "frase_nombre", referencedColumnName = "cuento_nombre")})
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Frase frase;

    public Enriq() {
    }

    public Enriq(String params) {
        this.params = params;
    }

    public Enriq(String params, String valor) {
        this.params = params;
        this.valor = valor;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Cancion getCancionNombre() {
        return cancionNombre;
    }

    public void setCancionNombre(Cancion cancionNombre) {
        this.cancionNombre = cancionNombre;
    }

    public Frase getFrase() {
        return frase;
    }

    public void setFrase(Frase frase) {
        this.frase = frase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (params != null ? params.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Enriq)) {
            return false;
        }
        Enriq other = (Enriq) object;
        if ((this.params == null && other.params != null) || (this.params != null && !this.params.equals(other.params))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.Enriq[ params=" + params + " ]";
    }
    
}
