
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
@Table(name = "emocion")

@NamedQueries({
    @NamedQuery(name = "Emocion.findAll", query = "SELECT e FROM Emocion e"),
    @NamedQuery(name = "Emocion.findById", query = "SELECT e FROM Emocion e WHERE e.id = :id"),
    @NamedQuery(name = "Emocion.findByImagen", query = "SELECT e FROM Emocion e WHERE e.imagen = :imagen"),
    @NamedQuery(name = "Emocion.findByEmotionalTag", query = "SELECT e FROM Emocion e WHERE e.emotionalTag = :emotionalTag")})
public class Emocion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "emotional_tag")
    private String emotionalTag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emocionId", fetch = FetchType.EAGER)
    private List<Accion> accionList;
    @JoinColumn(name = "robot_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Robot robotId;

    public Emocion() {
    }

    public Emocion(String id) {
        this.id = id;
    }

    public Emocion(String id, String imagen) {
        this.id = id;
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEmotionalTag() {
        return emotionalTag;
    }

    public void setEmotionalTag(String emotionalTag) {
        this.emotionalTag = emotionalTag;
    }

    
    public List<Accion> getAccionList() {
        return accionList;
    }

    public void setAccionList(List<Accion> accionList) {
        this.accionList = accionList;
    }

    public Robot getRobotId() {
        return robotId;
    }

    public void setRobotId(Robot robotId) {
        this.robotId = robotId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Emocion)) {
            return false;
        }
        Emocion other = (Emocion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.Emocion[ id=" + id + " ]";
    }
    
}
