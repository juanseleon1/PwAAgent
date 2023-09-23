
package com.besa.PwAAgent.db.model;

import java.io.Serializable;
import java.util.List;

import com.besa.PwAAgent.db.model.userprofile.PwAProfile;

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
@Table(name = "estado_civil")

@NamedQueries({
    @NamedQuery(name = "EstadoCivil.findAll", query = "SELECT e FROM EstadoCivil e"),
    @NamedQuery(name = "EstadoCivil.findByTipoEc", query = "SELECT e FROM EstadoCivil e WHERE e.tipoEc = :tipoEc")})
public class EstadoCivil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tipo_ec")
    private String tipoEc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoCivilTipoEc", fetch = FetchType.EAGER)
    private List<PwAProfile> PwAProfileList;

    public EstadoCivil() {
    }

    public EstadoCivil(String tipoEc) {
        this.tipoEc = tipoEc;
    }

    public String getTipoEc() {
        return tipoEc;
    }

    public void setTipoEc(String tipoEc) {
        this.tipoEc = tipoEc;
    }

    
    public List<PwAProfile> getPwAProfileList() {
        return PwAProfileList;
    }

    public void setPwAProfileList(List<PwAProfile> PwAProfileList) {
        this.PwAProfileList = PwAProfileList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoEc != null ? tipoEc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EstadoCivil)) {
            return false;
        }
        EstadoCivil other = (EstadoCivil) object;
        if ((this.tipoEc == null && other.tipoEc != null) || (this.tipoEc != null && !this.tipoEc.equals(other.tipoEc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.EstadoCivil[ tipoEc=" + tipoEc + " ]";
    }
    
}
