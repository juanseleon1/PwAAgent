
package com.besa.PwAAgent.db.model;

import java.io.Serializable;
import java.util.List;

import com.besa.PwAAgent.db.model.userprofile.PwAMedicalContext;

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
@Table(name = "causa_demencia")

@NamedQueries({
    @NamedQuery(name = "CausaDemencia.findAll", query = "SELECT c FROM CausaDemencia c"),
    @NamedQuery(name = "CausaDemencia.findByCondicion", query = "SELECT c FROM CausaDemencia c WHERE c.condicion = :condicion")})
public class CausaDemencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "condicion")
    private String condicion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "causaDemenciaCondicion", fetch = FetchType.EAGER)
    private List<PwAMedicalContext> PwAMedicalContextList;

    public CausaDemencia() {
    }

    public CausaDemencia(String condicion) {
        this.condicion = condicion;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    
    public List<PwAMedicalContext> getUserMedicalContextList() {
        return PwAMedicalContextList;
    }

    public void setPwAMedicalContextList(List<PwAMedicalContext> PwAMedicalContextList) {
        this.PwAMedicalContextList = PwAMedicalContextList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (condicion != null ? condicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof CausaDemencia)) {
            return false;
        }
        CausaDemencia other = (CausaDemencia) object;
        if ((this.condicion == null && other.condicion != null) || (this.condicion != null && !this.condicion.equals(other.condicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.CausaDemencia[ condicion=" + condicion + " ]";
    }
    
}
