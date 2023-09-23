
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
@Table(name = "robot")

@NamedQueries({
    @NamedQuery(name = "Robot.findAll", query = "SELECT r FROM Robot r"),
    @NamedQuery(name = "Robot.findById", query = "SELECT r FROM Robot r WHERE r.id = :id"),
    @NamedQuery(name = "Robot.findByNombre", query = "SELECT r FROM Robot r WHERE r.nombre = :nombre")})
public class Robot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "robotId", fetch = FetchType.EAGER)
    private List<Emocion> emocionList;

    public Robot() {
    }

    public Robot(Integer id) {
        this.id = id;
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

    
    public List<Emocion> getEmocionList() {
        return emocionList;
    }

    public void setEmocionList(List<Emocion> emocionList) {
        this.emocionList = emocionList;
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
        if (!(object instanceof Robot)) {
            return false;
        }
        Robot other = (Robot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.Robot[ id=" + id + " ]";
    }
    
}
