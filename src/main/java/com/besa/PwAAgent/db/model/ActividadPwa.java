
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
@Table(name = "actividad_pwa")
@NamedQueries({
    @NamedQuery(name = "ActividadPwa.findAll", query = "SELECT a FROM ActividadPwa a"),
    @NamedQuery(name = "ActividadPwa.findById", query = "SELECT a FROM ActividadPwa a WHERE a.id = :id"),
    @NamedQuery(name = "ActividadPwa.findByNombre", query = "SELECT a FROM ActividadPwa a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "ActividadPwa.findByTipo", query = "SELECT a FROM ActividadPwa a WHERE a.tipo = :tipo"),
    @NamedQuery(name = "ActividadPwa.findByDuracion", query = "SELECT a FROM ActividadPwa a WHERE a.duracion = :duracion")})
public class ActividadPwa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "duracion")
    private double duracion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividadPwa", fetch = FetchType.EAGER)
    private List<RegistroActividad> registroActividadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividadPwa", fetch = FetchType.EAGER)
    private List<ActXPreferencia> actXPreferenciaList;

    public ActividadPwa() {
    }

    public ActividadPwa(Integer id) {
        this.id = id;
    }

    public ActividadPwa(Integer id, String nombre, String tipo, double duracion) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.duracion = duracion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    
    public List<RegistroActividad> getRegistroActividadList() {
        return registroActividadList;
    }

    public void setRegistroActividadList(List<RegistroActividad> registroActividadList) {
        this.registroActividadList = registroActividadList;
    }

    
    public List<ActXPreferencia> getActXPreferenciaList() {
        return actXPreferenciaList;
    }

    public void setActXPreferenciaList(List<ActXPreferencia> actXPreferenciaList) {
        this.actXPreferenciaList = actXPreferenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadPwa)) {
            return false;
        }
        ActividadPwa other = (ActividadPwa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.ActividadPwa[ id=" + id + " ]";
    }
    
}
