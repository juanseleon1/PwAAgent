
package com.besa.PwAAgent.db.model;

import java.io.Serializable;
import java.util.List;

import com.besa.PwAAgent.db.model.userprofile.PwAExerciseProfile;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "programa_ejercicio")

@NamedQueries({
    @NamedQuery(name = "ProgramaEjercicio.findAll", query = "SELECT p FROM ProgramaEjercicio p"),
    @NamedQuery(name = "ProgramaEjercicio.findByNombre", query = "SELECT p FROM ProgramaEjercicio p WHERE p.nombre = :nombre")})
public class ProgramaEjercicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @ManyToMany(mappedBy = "programaEjercicioList", fetch = FetchType.EAGER)
    private List<CategoriaEntrenamiento> categoriaEntrenamientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programaEjercicio", fetch = FetchType.EAGER)
    private List<DiaXProgramaEjercicio> diaXProgramaEjercicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nombrePrograma", fetch = FetchType.EAGER)
    private List<PwAExerciseProfile> PwAExerciseProfileList;

    public ProgramaEjercicio() {
    }

    public ProgramaEjercicio(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public List<CategoriaEntrenamiento> getCategoriaEntrenamientoList() {
        return categoriaEntrenamientoList;
    }

    public void setCategoriaEntrenamientoList(List<CategoriaEntrenamiento> categoriaEntrenamientoList) {
        this.categoriaEntrenamientoList = categoriaEntrenamientoList;
    }

    
    public List<DiaXProgramaEjercicio> getDiaXProgramaEjercicioList() {
        return diaXProgramaEjercicioList;
    }

    public void setDiaXProgramaEjercicioList(List<DiaXProgramaEjercicio> diaXProgramaEjercicioList) {
        this.diaXProgramaEjercicioList = diaXProgramaEjercicioList;
    }

    
    public List<PwAExerciseProfile> getExerciseProfileList() {
        return PwAExerciseProfileList;
    }

    public void setExerciseProfileList(List<PwAExerciseProfile> PwAExerciseProfileList) {
        this.PwAExerciseProfileList = PwAExerciseProfileList;
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
        if (!(object instanceof ProgramaEjercicio)) {
            return false;
        }
        ProgramaEjercicio other = (ProgramaEjercicio) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.ProgramaEjercicio[ nombre=" + nombre + " ]";
    }
    
}
