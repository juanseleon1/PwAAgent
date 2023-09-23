
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
@Table(name = "dia")

@NamedQueries({
    @NamedQuery(name = "Dia.findAll", query = "SELECT d FROM Dia d"),
    @NamedQuery(name = "Dia.findByNombre", query = "SELECT d FROM Dia d WHERE d.nombre = :nombre")})
public class Dia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dia", fetch = FetchType.EAGER)
    private List<DiaXProgramaEjercicio> diaXProgramaEjercicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dia", fetch = FetchType.EAGER)
    private List<DiaXCategoriaEntrenamiento> diaXCategoriaEntrenamientoList;

    public Dia() {
    }

    public Dia(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public List<DiaXProgramaEjercicio> getDiaXProgramaEjercicioList() {
        return diaXProgramaEjercicioList;
    }

    public void setDiaXProgramaEjercicioList(List<DiaXProgramaEjercicio> diaXProgramaEjercicioList) {
        this.diaXProgramaEjercicioList = diaXProgramaEjercicioList;
    }

    
    public List<DiaXCategoriaEntrenamiento> getDiaXCategoriaEntrenamientoList() {
        return diaXCategoriaEntrenamientoList;
    }

    public void setDiaXCategoriaEntrenamientoList(List<DiaXCategoriaEntrenamiento> diaXCategoriaEntrenamientoList) {
        this.diaXCategoriaEntrenamientoList = diaXCategoriaEntrenamientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dia)) {
            return false;
        }
        Dia other = (Dia) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.Dia[ nombre=" + nombre + " ]";
    }
    
}
