
package com.besa.PwAAgent.db.model;

import java.io.Serializable;

import com.besa.PwAAgent.db.model.userprofile.PwAExerciseProfile;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;



@Entity
@Table(name = "historial")

@NamedQueries({
    @NamedQuery(name = "Historial.findAll", query = "SELECT h FROM Historial h"),
    @NamedQuery(name = "Historial.findByLogId", query = "SELECT h FROM Historial h WHERE h.logId = :logId"),
    @NamedQuery(name = "Historial.findByEjercicio", query = "SELECT h FROM Historial h WHERE h.ejercicio = :ejercicio"),
    @NamedQuery(name = "Historial.findByRepeticionesHechas", query = "SELECT h FROM Historial h WHERE h.repeticionesHechas = :repeticionesHechas"),
    @NamedQuery(name = "Historial.findByRetroalimentacionGusto", query = "SELECT h FROM Historial h WHERE h.retroalimentacionGusto = :retroalimentacionGusto"),
    @NamedQuery(name = "Historial.findByRetroalimentacionCansancio", query = "SELECT h FROM Historial h WHERE h.retroalimentacionCansancio = :retroalimentacionCansancio"),
    @NamedQuery(name = "Historial.findByNotas", query = "SELECT h FROM Historial h WHERE h.notas = :notas")})
public class Historial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "log_id")
    private Integer logId;
    @Basic(optional = false)
    @Column(name = "ejercicio")
    private String ejercicio;
    @Basic(optional = false)
    @Column(name = "repeticiones_hechas")
    private int repeticionesHechas;
    @Column(name = "retroalimentacion_gusto")
    private Integer retroalimentacionGusto;
    @Column(name = "retroalimentacion_cansancio")
    private Integer retroalimentacionCansancio;
    @Column(name = "notas")
    private String notas;
    @JoinColumn(name = "pwa_cedula", referencedColumnName = "perfil_pwa_cedula")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PwAExerciseProfile pwaCedula;

    public Historial() {
    }

    public Historial(Integer logId) {
        this.logId = logId;
    }

    public Historial(Integer logId, String ejercicio, int repeticionesHechas) {
        this.logId = logId;
        this.ejercicio = ejercicio;
        this.repeticionesHechas = repeticionesHechas;
    }
    public Historial(String ejercicio, int repeticionesHechas) {
        this.ejercicio = ejercicio;
        this.repeticionesHechas = repeticionesHechas;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(String ejercicio) {
        this.ejercicio = ejercicio;
    }

    public int getRepeticionesHechas() {
        return repeticionesHechas;
    }

    public void setRepeticionesHechas(int repeticionesHechas) {
        this.repeticionesHechas = repeticionesHechas;
    }

    public Integer getRetroalimentacionGusto() {
        return retroalimentacionGusto;
    }

    public void setRetroalimentacionGusto(Integer retroalimentacionGusto) {
        this.retroalimentacionGusto = retroalimentacionGusto;
    }

    public Integer getRetroalimentacionCansancio() {
        return retroalimentacionCansancio;
    }

    public void setRetroalimentacionCansancio(Integer retroalimentacionCansancio) {
        this.retroalimentacionCansancio = retroalimentacionCansancio;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public PwAExerciseProfile getPwaCedula() {
        return pwaCedula;
    }

    public void setPwaCedula(PwAExerciseProfile pwaCedula) {
        this.pwaCedula = pwaCedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logId != null ? logId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historial)) {
            return false;
        }
        Historial other = (Historial) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.Historial[ logId=" + logId + " ]";
    }
    
}
