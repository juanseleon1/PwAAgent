
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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "cancion")

@NamedQueries({
    @NamedQuery(name = "Cancion.findAll", query = "SELECT c FROM Cancion c"),
    @NamedQuery(name = "Cancion.findByNombre", query = "SELECT c FROM Cancion c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cancion.findByUrl", query = "SELECT c FROM Cancion c WHERE c.url = :url")})
public class Cancion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "url")
    private String url;
    @JoinTable(name = "lista_tag", joinColumns = {
        @JoinColumn(name = "cancion_nombre", referencedColumnName = "nombre")}, inverseJoinColumns = {
        @JoinColumn(name = "tag_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tag> tagList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cancionNombre", fetch = FetchType.EAGER)
    private List<Enriq> enriqList;
    @JoinColumn(name = "genero", referencedColumnName = "genero")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Genero genero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cancion", fetch = FetchType.EAGER)
    private List<PreferenciaXCancion> preferenciaXCancionList;

    public Cancion() {
    }

    public Cancion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    
    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    
    public List<Enriq> getEnriqList() {
        return enriqList;
    }

    public void setEnriqList(List<Enriq> enriqList) {
        this.enriqList = enriqList;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    
    public List<PreferenciaXCancion> getPreferenciaXCancionList() {
        return preferenciaXCancionList;
    }

    public void setPreferenciaXCancionList(List<PreferenciaXCancion> preferenciaXCancionList) {
        this.preferenciaXCancionList = preferenciaXCancionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Cancion)) {
            return false;
        }
        Cancion other = (Cancion) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.Cancion[ nombre=" + nombre + " ]";
    }
    
}
