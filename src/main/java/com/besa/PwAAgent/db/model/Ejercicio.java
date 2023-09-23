
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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "ejercicio")

@NamedQueries({
    @NamedQuery(name = "Ejercicio.findAll", query = "SELECT e FROM Ejercicio e"),
    @NamedQuery(name = "Ejercicio.findByNombre", query = "SELECT e FROM Ejercicio e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Ejercicio.findByDuracion", query = "SELECT e FROM Ejercicio e WHERE e.duracion = :duracion"),
    @NamedQuery(name = "Ejercicio.findByNecesitaPeso", query = "SELECT e FROM Ejercicio e WHERE e.necesitaPeso = :necesitaPeso"),
    @NamedQuery(name = "Ejercicio.findByUrlVideo", query = "SELECT e FROM Ejercicio e WHERE e.urlVideo = :urlVideo")})
public class Ejercicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "duracion")
    private double duracion;
    @Basic(optional = false)
    @Column(name = "necesita_peso")
    private boolean necesitaPeso;
    @Column(name = "url_video")
    private String urlVideo;
    @ManyToMany(mappedBy = "ejercicioList", fetch = FetchType.EAGER)
    private List<CategoriaEntrenamiento> categoriaEntrenamientoList;
    @JoinTable(name = "perfil_ejercicio_x_ejercicio", joinColumns = {
        @JoinColumn(name = "nombre_ejercicio", referencedColumnName = "nombre")}, inverseJoinColumns = {
        @JoinColumn(name = "perfil_pwa_cedula", referencedColumnName = "perfil_pwa_cedula")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<PwAExerciseProfile> PwAExerciseProfileList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ejercicio1", fetch = FetchType.EAGER)
    private List<FraseInspiracional> fraseInspiracionalList;

    public Ejercicio() {
    }

    public Ejercicio(String nombre) {
        this.nombre = nombre;
    }

    public Ejercicio(String nombre, double duracion, boolean necesitaPeso) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.necesitaPeso = necesitaPeso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public boolean getNecesitaPeso() {
        return necesitaPeso;
    }

    public void setNecesitaPeso(boolean necesitaPeso) {
        this.necesitaPeso = necesitaPeso;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    
    public List<CategoriaEntrenamiento> getCategoriaEntrenamientoList() {
        return categoriaEntrenamientoList;
    }

    public void setCategoriaEntrenamientoList(List<CategoriaEntrenamiento> categoriaEntrenamientoList) {
        this.categoriaEntrenamientoList = categoriaEntrenamientoList;
    }

    
    public List<PwAExerciseProfile> getExerciseProfileList() {
        return PwAExerciseProfileList;
    }

    public void setExerciseProfileList(List<PwAExerciseProfile> PwAExerciseProfileList) {
        this.PwAExerciseProfileList = PwAExerciseProfileList;
    }

    
    public List<FraseInspiracional> getFraseInspiracionalList() {
        return fraseInspiracionalList;
    }

    public void setFraseInspiracionalList(List<FraseInspiracional> fraseInspiracionalList) {
        this.fraseInspiracionalList = fraseInspiracionalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Ejercicio)) {
            return false;
        }
        Ejercicio other = (Ejercicio) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.Ejercicio[ nombre=" + nombre + " ]";
    }
    
}
