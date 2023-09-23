
package com.besa.PwAAgent.db.model;

import java.io.Serializable;
import java.util.List;

import com.besa.PwAAgent.db.model.userprofile.PerfilPwa;

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
@Table(name = "nivel_educativo")

@NamedQueries({
    @NamedQuery(name = "NivelEducativo.findAll", query = "SELECT n FROM NivelEducativo n"),
    @NamedQuery(name = "NivelEducativo.findByTipoNe", query = "SELECT n FROM NivelEducativo n WHERE n.tipoNe = :tipoNe")})
public class NivelEducativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tipo_ne")
    private String tipoNe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivelEducativoTipoNe", fetch = FetchType.EAGER)
    private List<PerfilPwa> perfilPwaList;

    public NivelEducativo() {
    }

    public NivelEducativo(String tipoNe) {
        this.tipoNe = tipoNe;
    }

    public String getTipoNe() {
        return tipoNe;
    }

    public void setTipoNe(String tipoNe) {
        this.tipoNe = tipoNe;
    }

    
    public List<PerfilPwa> getPerfilPwaList() {
        return perfilPwaList;
    }

    public void setPerfilPwaList(List<PerfilPwa> perfilPwaList) {
        this.perfilPwaList = perfilPwaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoNe != null ? tipoNe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelEducativo)) {
            return false;
        }
        NivelEducativo other = (NivelEducativo) object;
        if ((this.tipoNe == null && other.tipoNe != null) || (this.tipoNe != null && !this.tipoNe.equals(other.tipoNe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.NivelEducativo[ tipoNe=" + tipoNe + " ]";
    }
    
}
