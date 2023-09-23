
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
    @NamedQuery(name = "PwAExerciseProfile.findByPerfilPwaCedula", query = "SELECT p FROM PwAExerciseProfile p WHERE p.perfilPwaCedula = :perfilPwaCedula"),
    @NamedQuery(name = "PwAExerciseProfile.findByIndexIntensidadActual", query = "SELECT p FROM PwAExerciseProfile p WHERE p.indexIntensidadActual = :indexIntensidadActual"),
    @NamedQuery(name = "PwAExerciseProfile.findByFechaProx", query = "SELECT p FROM PwAExerciseProfile p WHERE p.fechaProx = :fechaProx"),
    @NamedQuery(name = "PwAExerciseProfile.findByHoraProx", query = "SELECT p FROM PwAExerciseProfile p WHERE p.horaProx = :horaProx"),
    @NamedQuery(name = "PwAExerciseProfile.findByDiasHechos", query = "SELECT p FROM PwAExerciseProfile p WHERE p.diasHechos = :diasHechos")})
public class PwAExerciseProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "perfil_pwa_cedula")
    private String perfilPwaCedula;
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
    private PerfilPwa perfilPwa;
    @JoinColumn(name = "nombre_programa", referencedColumnName = "nombre")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ProgramaEjercicio nombrePrograma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pwaCedula", fetch = FetchType.EAGER)
    private List<Historial> historialList;

    public PwAExerciseProfile() {
    }

    public PwAExerciseProfile(String perfilPwaCedula) {
        this.perfilPwaCedula = perfilPwaCedula;
    }

    public PwAExerciseProfile(String perfilPwaCedula, int indexIntensidadActual, Date fechaProx, int horaProx, int diasHechos) {
        this.perfilPwaCedula = perfilPwaCedula;
        this.indexIntensidadActual = indexIntensidadActual;
        this.fechaProx = fechaProx;
        this.horaProx = horaProx;
        this.diasHechos = diasHechos;
    }

    public String getPerfilPwaCedula() {
        return perfilPwaCedula;
    }

    public void setPerfilPwaCedula(String perfilPwaCedula) {
        this.perfilPwaCedula = perfilPwaCedula;
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

    public PerfilPwa getPerfilPwa() {
        return perfilPwa;
    }

    public void setPerfilPwa(PerfilPwa perfilPwa) {
        this.perfilPwa = perfilPwa;
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
        hash += (perfilPwaCedula != null ? perfilPwaCedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PwAExerciseProfile)) {
            return false;
        }
        PwAExerciseProfile other = (PwAExerciseProfile) object;
        if ((this.perfilPwaCedula == null && other.perfilPwaCedula != null) || (this.perfilPwaCedula != null && !this.perfilPwaCedula.equals(other.perfilPwaCedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.PwAExerciseProfile[ perfilPwaCedula=" + perfilPwaCedula + " ]";
    }
    
}
