
package com.besa.PwAAgent.db.model.userprofile;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.besa.PwAAgent.db.model.Ejercicio;
import com.besa.PwAAgent.db.model.Historial;
import com.besa.PwAAgent.db.model.Horario;
import com.besa.PwAAgent.db.model.ProgramaEjercicio;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;



@Entity
@Table(name = "perfil_ejercicio")

@NamedQueries({
    @NamedQuery(name = "PwAExerciseProfile.findAll", query = "SELECT p FROM PwAExerciseProfile p"),
    @NamedQuery(name = "PwAExerciseProfile.findByPwAProfileCedula", query = "SELECT p FROM PwAExerciseProfile p WHERE p.PwAProfileCedula = :PwAProfileCedula"),
    @NamedQuery(name = "PwAExerciseProfile.findByIndexIntensidadActual", query = "SELECT p FROM PwAExerciseProfile p WHERE p.indexIntensidadActual = :indexIntensidadActual"),
    @NamedQuery(name = "PwAExerciseProfile.findByFechaProx", query = "SELECT p FROM PwAExerciseProfile p WHERE p.fechaProx = :fechaProx"),
    @NamedQuery(name = "PwAExerciseProfile.findByHoraProx", query = "SELECT p FROM PwAExerciseProfile p WHERE p.horaProx = :horaProx"),
    @NamedQuery(name = "PwAExerciseProfile.findByDiasHechos", query = "SELECT p FROM PwAExerciseProfile p WHERE p.diasHechos = :diasHechos")})
public class PwAExerciseProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "perfil_pwa_cedula")
    private String PwAProfileCedula;
    @Basic(optional = false)
    @Column(name = "index_intensidad_actual")
    private int indexIntensidadActual;
    @Basic(optional = false)
    @Column(name = "fecha_prox")
    @Temporal(TemporalType.DATE)
    private Date fechaProx;
    @Basic(optional = false)
    @Column(name = "hora_prox")
    private int horaProx;
    @Basic(optional = false)
    @Column(name = "dias_hechos")
    private int diasHechos;
    @ManyToMany(mappedBy = "PwAExerciseProfileList", fetch = FetchType.EAGER)
    private List<Ejercicio> ejercicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedula", fetch = FetchType.EAGER)
    private List<Horario> horarioList;
    @JoinColumn(name = "perfil_pwa_cedula", referencedColumnName = "cedula", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private PwAProfile PwAProfile;
    @JoinColumn(name = "nombre_programa", referencedColumnName = "nombre")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ProgramaEjercicio nombrePrograma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pwaCedula", fetch = FetchType.EAGER)
    private List<Historial> historialList;

    public PwAExerciseProfile() {
    }

    public PwAExerciseProfile(String PwAProfileCedula) {
        this.PwAProfileCedula = PwAProfileCedula;
    }

    public PwAExerciseProfile(String PwAProfileCedula, int indexIntensidadActual, Date fechaProx, int horaProx, int diasHechos) {
        this.PwAProfileCedula = PwAProfileCedula;
        this.indexIntensidadActual = indexIntensidadActual;
        this.fechaProx = fechaProx;
        this.horaProx = horaProx;
        this.diasHechos = diasHechos;
    }

    public String getPwAProfileCedula() {
        return PwAProfileCedula;
    }

    public void setPwAProfileCedula(String PwAProfileCedula) {
        this.PwAProfileCedula = PwAProfileCedula;
    }

    public int getIndexIntensidadActual() {
        return indexIntensidadActual;
    }

    public void setIndexIntensidadActual(int indexIntensidadActual) {
        this.indexIntensidadActual = indexIntensidadActual;
    }

    public Date getFechaProx() {
        return fechaProx;
    }

    public void setFechaProx(Date fechaProx) {
        this.fechaProx = fechaProx;
    }

    public int getHoraProx() {
        return horaProx;
    }

    public void setHoraProx(int horaProx) {
        this.horaProx = horaProx;
    }

    public int getDiasHechos() {
        return diasHechos;
    }

    public void setDiasHechos(int diasHechos) {
        this.diasHechos = diasHechos;
    }

    
    public List<Ejercicio> getEjercicioList() {
        return ejercicioList;
    }

    public void setEjercicioList(List<Ejercicio> ejercicioList) {
        this.ejercicioList = ejercicioList;
    }

    
    public List<Horario> getHorarioList() {
        return horarioList;
    }

    public void setHorarioList(List<Horario> horarioList) {
        this.horarioList = horarioList;
    }

    public PwAProfile getPwAProfile() {
        return PwAProfile;
    }

    public void setPwAProfile(PwAProfile PwAProfile) {
        this.PwAProfile = PwAProfile;
    }

    public ProgramaEjercicio getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(ProgramaEjercicio nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    
    public List<Historial> getHistorialList() {
        return historialList;
    }

    public void setHistorialList(List<Historial> historialList) {
        this.historialList = historialList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (PwAProfileCedula != null ? PwAProfileCedula.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "PwAExerciseProfile [PwAProfileCedula=" + PwAProfileCedula + ", indexIntensidadActual="
                + indexIntensidadActual + ", fechaProx=" + fechaProx + ", horaProx=" + horaProx + ", diasHechos="
                + diasHechos + ", ejercicioList=" + ejercicioList + ", horarioList=" + horarioList + ", PwAProfile="
                + PwAProfile + ", nombrePrograma=" + nombrePrograma + ", historialList=" + historialList + "]";
    }

}
