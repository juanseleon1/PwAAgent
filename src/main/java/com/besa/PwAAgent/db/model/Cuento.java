
package com.besa.PwAAgent.db.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "cuento")

@NamedQueries({
    @NamedQuery(name = "Cuento.findAll", query = "SELECT c FROM Cuento c"),
    @NamedQuery(name = "Cuento.findByNombre", query = "SELECT c FROM Cuento c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cuento.findByAutor", query = "SELECT c FROM Cuento c WHERE c.autor = :autor")})
public class Cuento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "autor")
    private String autor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuento", fetch = FetchType.EAGER)
    private List<PreferenciaXCuento> preferenciaXCuentoList;
    @JoinColumn(name = "genero", referencedColumnName = "genero")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Genero genero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuento", fetch = FetchType.EAGER)
    private List<Frase> fraseList;

    public Cuento() {
    }

    public Cuento(String nombre) {
        this.nombre = nombre;
    }

    public Cuento(String nombre, String autor) {
        this.nombre = nombre;
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    
    public List<PreferenciaXCuento> getPreferenciaXCuentoList() {
        return preferenciaXCuentoList;
    }

    public void setPreferenciaXCuentoList(List<PreferenciaXCuento> preferenciaXCuentoList) {
        this.preferenciaXCuentoList = preferenciaXCuentoList;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    
    public List<Frase> getFraseList() {
        return fraseList;
    }

    public void setFraseList(List<Frase> fraseList) {
        this.fraseList = fraseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Cuento)) {
            return false;
        }
        Cuento other = (Cuento) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.Cuento[ nombre=" + nombre + " ]";
    }
    
}
