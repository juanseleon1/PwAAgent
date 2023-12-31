
package com.besa.PwAAgent.db.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;



@Entity
@Table(name = "joint")

@NamedQueries({
    @NamedQuery(name = "Joint.findAll", query = "SELECT j FROM Joint j"),
    @NamedQuery(name = "Joint.findById", query = "SELECT j FROM Joint j WHERE j.id = :id"),
    @NamedQuery(name = "Joint.findByNombre", query = "SELECT j FROM Joint j WHERE j.nombre = :nombre"),
    @NamedQuery(name = "Joint.findByAngulo", query = "SELECT j FROM Joint j WHERE j.angulo = :angulo"),
    @NamedQuery(name = "Joint.findByTiempo", query = "SELECT j FROM Joint j WHERE j.tiempo = :tiempo")})
public class Joint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "angulo")
    private double angulo;
    @Basic(optional = false)
    @Column(name = "tiempo")
    private double tiempo;
    @ManyToMany(mappedBy = "jointList", fetch = FetchType.EAGER)
    private List<Accion> accionList;

    public Joint() {
    }

    public Joint(Integer id) {
        this.id = id;
    }

    public Joint(Integer id, String nombre, double angulo, double tiempo) {
        this.id = id;
        this.nombre = nombre;
        this.angulo = angulo;
        this.tiempo = tiempo;
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

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    
    public List<Accion> getAccionList() {
        return accionList;
    }

    public void setAccionList(List<Accion> accionList) {
        this.accionList = accionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Joint)) {
            return false;
        }
        Joint other = (Joint) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.Joint[ id=" + id + " ]";
    }
    
}
