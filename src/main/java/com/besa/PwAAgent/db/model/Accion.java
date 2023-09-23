
package com.besa.PwAAgent.db.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
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
import jakarta.persistence.Table;



@Entity
@Table(name = "accion")

@NamedQueries({
    @NamedQuery(name = "Accion.findAll", query = "SELECT a FROM Accion a"),
    @NamedQuery(name = "Accion.findById", query = "SELECT a FROM Accion a WHERE a.id = :id"),
    @NamedQuery(name = "Accion.findByNombre", query = "SELECT a FROM Accion a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Accion.findByTipo", query = "SELECT a FROM Accion a WHERE a.tipo = :tipo")})
public class Accion implements Serializable {

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
    @JoinTable(name = "accion_x_joint", joinColumns = {
        @JoinColumn(name = "accion_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "joint_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Joint> jointList;
    @JoinColumn(name = "emocion_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Emocion emocionId;

    public Accion() {
    }

    public Accion(Integer id) {
        this.id = id;
    }

    public Accion(Integer id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
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

    
    public List<Joint> getJointList() {
        return jointList;
    }

    public void setJointList(List<Joint> jointList) {
        this.jointList = jointList;
    }

    public Emocion getEmocionId() {
        return emocionId;
    }

    public void setEmocionId(Emocion emocionId) {
        this.emocionId = emocionId;
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
        if (!(object instanceof Accion)) {
            return false;
        }
        Accion other = (Accion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.Accion[ id=" + id + " ]";
    }
    
}
