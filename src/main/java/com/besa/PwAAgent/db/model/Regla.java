
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
@Table(name = "regla")

@NamedQueries({
    @NamedQuery(name = "Regla.findAll", query = "SELECT r FROM Regla r"),
    @NamedQuery(name = "Regla.findById", query = "SELECT r FROM Regla r WHERE r.id = :id"),
    @NamedQuery(name = "Regla.findByFeedback", query = "SELECT r FROM Regla r WHERE r.feedback = :feedback"),
    @NamedQuery(name = "Regla.findByEtiqueta", query = "SELECT r FROM Regla r WHERE r.etiqueta = :etiqueta")})
public class Regla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "feedback")
    private double feedback;
    @Basic(optional = false)
    @Column(name = "etiqueta")
    private String etiqueta;
    @ManyToMany(mappedBy = "reglaList", fetch = FetchType.EAGER)
    private List<Antecedente> antecedenteList;

    public Regla() {
    }

    public Regla(Integer id) {
        this.id = id;
    }

    public Regla(Integer id, double feedback, String etiqueta) {
        this.id = id;
        this.feedback = feedback;
        this.etiqueta = etiqueta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getFeedback() {
        return feedback;
    }

    public void setFeedback(double feedback) {
        this.feedback = feedback;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    
    public List<Antecedente> getAntecedenteList() {
        return antecedenteList;
    }

    public void setAntecedenteList(List<Antecedente> antecedenteList) {
        this.antecedenteList = antecedenteList;
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
        if (!(object instanceof Regla)) {
            return false;
        }
        Regla other = (Regla) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.Regla[ id=" + id + " ]";
    }
    
}
