
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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "categoria_entrenamiento")

@NamedQueries({
    @NamedQuery(name = "CategoriaEntrenamiento.findAll", query = "SELECT c FROM CategoriaEntrenamiento c"),
    @NamedQuery(name = "CategoriaEntrenamiento.findByTipo", query = "SELECT c FROM CategoriaEntrenamiento c WHERE c.tipo = :tipo")})
public class CategoriaEntrenamiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @JoinTable(name = "categoria_entrenamiento_x_programa", joinColumns = {
        @JoinColumn(name = "tipo_categoria", referencedColumnName = "tipo")}, inverseJoinColumns = {
        @JoinColumn(name = "programa_ejercicio_nombre", referencedColumnName = "nombre")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<ProgramaEjercicio> programaEjercicioList;
    @JoinTable(name = "ejercicio_x_categoria", joinColumns = {
        @JoinColumn(name = "categoria_tipo", referencedColumnName = "tipo")}, inverseJoinColumns = {
        @JoinColumn(name = "ejercicio_nombre", referencedColumnName = "nombre")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Ejercicio> ejercicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaEntrenamientoTipo", fetch = FetchType.EAGER)
    private List<Intensidad> intensidadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaEntrenamiento", fetch = FetchType.EAGER)
    private List<DiaXCategoriaEntrenamiento> diaXCategoriaEntrenamientoList;

    public CategoriaEntrenamiento() {
    }

    public CategoriaEntrenamiento(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    public List<ProgramaEjercicio> getProgramaEjercicioList() {
        return programaEjercicioList;
    }

    public void setProgramaEjercicioList(List<ProgramaEjercicio> programaEjercicioList) {
        this.programaEjercicioList = programaEjercicioList;
    }

    
    public List<Ejercicio> getEjercicioList() {
        return ejercicioList;
    }

    public void setEjercicioList(List<Ejercicio> ejercicioList) {
        this.ejercicioList = ejercicioList;
    }

    
    public List<Intensidad> getIntensidadList() {
        return intensidadList;
    }

    public void setIntensidadList(List<Intensidad> intensidadList) {
        this.intensidadList = intensidadList;
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
        hash += (tipo != null ? tipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof CategoriaEntrenamiento)) {
            return false;
        }
        CategoriaEntrenamiento other = (CategoriaEntrenamiento) object;
        if ((this.tipo == null && other.tipo != null) || (this.tipo != null && !this.tipo.equals(other.tipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.CategoriaEntrenamiento[ tipo=" + tipo + " ]";
    }
    
}
