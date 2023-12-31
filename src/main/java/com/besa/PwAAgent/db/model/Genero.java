
package com.besa.PwAAgent.db.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "genero")

@NamedQueries({
    @NamedQuery(name = "Genero.findAll", query = "SELECT g FROM Genero g"),
    @NamedQuery(name = "Genero.findByGenero", query = "SELECT g FROM Genero g WHERE g.genero = :genero")})
public class Genero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "genero")
    private String genero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genero", fetch = FetchType.EAGER)
    private List<Cuento> cuentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genero", fetch = FetchType.EAGER)
    private List<Baile> baileList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genero", fetch = FetchType.EAGER)
    private List<Cancion> cancionList;

    public Genero() {
    }

    public Genero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    
    public List<Cuento> getCuentoList() {
        return cuentoList;
    }

    public void setCuentoList(List<Cuento> cuentoList) {
        this.cuentoList = cuentoList;
    }

    
    public List<Baile> getBaileList() {
        return baileList;
    }

    public void setBaileList(List<Baile> baileList) {
        this.baileList = baileList;
    }

    
    public List<Cancion> getCancionList() {
        return cancionList;
    }

    public void setCancionList(List<Cancion> cancionList) {
        this.cancionList = cancionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (genero != null ? genero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Genero)) {
            return false;
        }
        Genero other = (Genero) object;
        if ((this.genero == null && other.genero != null) || (this.genero != null && !this.genero.equals(other.genero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.Genero[ genero=" + genero + " ]";
    }
    
}
