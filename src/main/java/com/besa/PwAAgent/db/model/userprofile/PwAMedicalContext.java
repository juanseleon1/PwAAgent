
package com.besa.PwAAgent.db.model.userprofile;

import java.io.Serializable;
import java.util.List;

import com.besa.PwAAgent.db.model.ActividadRutinaria;
import com.besa.PwAAgent.db.model.CausaDemencia;
import com.besa.PwAAgent.db.model.Cdr;

import BESA.SocialRobot.BDIAgent.BeliefAgent.UserProfile.Context.MedicalContext;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "perfil_medico")

@NamedQueries({
        @NamedQuery(name = "PwAMedicalContext.findAll", query = "SELECT p FROM PwAMedicalContext p"),
        @NamedQuery(name = "PwAMedicalContext.findByPwAProfileCedula", query = "SELECT p FROM PwAMedicalContext p WHERE p.PwAProfileCedula = :PwAProfileCedula"),
        @NamedQuery(name = "PwAMedicalContext.findByTomaMedicamentos", query = "SELECT p FROM PwAMedicalContext p WHERE p.tomaMedicamentos = :tomaMedicamentos"),
        @NamedQuery(name = "PwAMedicalContext.findByDiscapAuditiva", query = "SELECT p FROM PwAMedicalContext p WHERE p.discapAuditiva = :discapAuditiva"),
        @NamedQuery(name = "PwAMedicalContext.findByDiscapVisual", query = "SELECT p FROM PwAMedicalContext p WHERE p.discapVisual = :discapVisual"),
        @NamedQuery(name = "PwAMedicalContext.findByDiscapMotora", query = "SELECT p FROM PwAMedicalContext p WHERE p.discapMotora = :discapMotora"),
        @NamedQuery(name = "PwAMedicalContext.findByEstadoEnfermedad", query = "SELECT p FROM PwAMedicalContext p WHERE p.estadoEnfermedad = :estadoEnfermedad"),
        @NamedQuery(name = "PwAMedicalContext.findByPeriodoVigila", query = "SELECT p FROM PwAMedicalContext p WHERE p.periodoVigila = :periodoVigila"),
        @NamedQuery(name = "PwAMedicalContext.findByFast", query = "SELECT p FROM PwAMedicalContext p WHERE p.fast = :fast"),
        @NamedQuery(name = "PwAMedicalContext.findByRiesgoCaida", query = "SELECT p FROM PwAMedicalContext p WHERE p.riesgoCaida = :riesgoCaida"),
        @NamedQuery(name = "PwAMedicalContext.findBySppb", query = "SELECT p FROM PwAMedicalContext p WHERE p.sppb = :sppb") })
public class PwAMedicalContext extends MedicalContext implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "perfil_pwa_cedula")
    private String PwAProfileCedula;
    @Basic(optional = false)
    @Column(name = "toma_medicamentos")
    private int tomaMedicamentos;
    @Basic(optional = false)
    @Column(name = "discap_auditiva")
    private int discapAuditiva;
    @Basic(optional = false)
    @Column(name = "discap_visual")
    private int discapVisual;
    @Basic(optional = false)
    @Column(name = "discap_motora")
    private int discapMotora;
    @Basic(optional = false)
    @Column(name = "estado_enfermedad")
    private int estadoEnfermedad;
    @Basic(optional = false)
    @Column(name = "periodo_vigila")
    private int periodoVigila;
    @Basic(optional = false)
    @Column(name = "fast")
    private int fast;
    @Column(name = "riesgo_caida")
    private Integer riesgoCaida;
    @Column(name = "sppb")
    private Integer sppb;
    @Column
    @OneToMany(fetch = FetchType.EAGER)
    private List<FranjaMedicamento> franjaMedicamentoList;
    @JoinColumn(name = "causa_demencia_condicion", referencedColumnName = "condicion")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CausaDemencia causaDemenciaCondicion;
    @JoinColumn(name = "perfil_pwa_cedula", referencedColumnName = "cedula", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private PwAProfile PwAProfile;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicoPwaCedula", fetch = FetchType.EAGER)
    private List<ActividadRutinaria> actividadRutinariaList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "PwAMedicalContext", fetch = FetchType.EAGER)
    private Cdr cdr;

    public PwAMedicalContext() {
    }

    public PwAMedicalContext(String PwAProfileCedula) {
        this.PwAProfileCedula = PwAProfileCedula;
    }

    public PwAMedicalContext(String PwAProfileCedula, int tomaMedicamentos, int discapAuditiva, int discapVisual,
            int discapMotora, int estadoEnfermedad, int periodoVigila, int fast) {
        this.PwAProfileCedula = PwAProfileCedula;
        this.tomaMedicamentos = tomaMedicamentos;
        this.discapAuditiva = discapAuditiva;
        this.discapVisual = discapVisual;
        this.discapMotora = discapMotora;
        this.estadoEnfermedad = estadoEnfermedad;
        this.periodoVigila = periodoVigila;
        this.fast = fast;
    }

    public String getPwAProfileCedula() {
        return PwAProfileCedula;
    }

    public void setPwAProfileCedula(String PwAProfileCedula) {
        this.PwAProfileCedula = PwAProfileCedula;
    }

    public int getTomaMedicamentos() {
        return tomaMedicamentos;
    }

    public void setTomaMedicamentos(int tomaMedicamentos) {
        this.tomaMedicamentos = tomaMedicamentos;
    }

    public int getDiscapAuditiva() {
        return discapAuditiva;
    }

    public void setDiscapAuditiva(int discapAuditiva) {
        this.discapAuditiva = discapAuditiva;
    }

    public int getDiscapVisual() {
        return discapVisual;
    }

    public void setDiscapVisual(int discapVisual) {
        this.discapVisual = discapVisual;
    }

    public int getDiscapMotora() {
        return discapMotora;
    }

    public void setDiscapMotora(int discapMotora) {
        this.discapMotora = discapMotora;
    }

    public int getEstadoEnfermedad() {
        return estadoEnfermedad;
    }

    public void setEstadoEnfermedad(int estadoEnfermedad) {
        this.estadoEnfermedad = estadoEnfermedad;
    }

    public int getPeriodoVigila() {
        return periodoVigila;
    }

    public void setPeriodoVigila(int periodoVigila) {
        this.periodoVigila = periodoVigila;
    }

    public int getFast() {
        return fast;
    }

    public void setFast(int fast) {
        this.fast = fast;
    }

    public Integer getRiesgoCaida() {
        return riesgoCaida;
    }

    public void setRiesgoCaida(Integer riesgoCaida) {
        this.riesgoCaida = riesgoCaida;
    }

    public Integer getSppb() {
        return sppb;
    }

    public void setSppb(Integer sppb) {
        this.sppb = sppb;
    }

    public CausaDemencia getCausaDemenciaCondicion() {
        return causaDemenciaCondicion;
    }

    public void setCausaDemenciaCondicion(CausaDemencia causaDemenciaCondicion) {
        this.causaDemenciaCondicion = causaDemenciaCondicion;
    }

    public PwAProfile getPwAProfile() {
        return PwAProfile;
    }

    public void setPwAProfile(PwAProfile PwAProfile) {
        this.PwAProfile = PwAProfile;
    }

    public List<ActividadRutinaria> getActividadRutinariaList() {
        return actividadRutinariaList;
    }

    public void setActividadRutinariaList(List<ActividadRutinaria> actividadRutinariaList) {
        this.actividadRutinariaList = actividadRutinariaList;
    }

    public Cdr getCdr() {
        return cdr;
    }

    public void setCdr(Cdr cdr) {
        this.cdr = cdr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (PwAProfileCedula != null ? PwAProfileCedula.hashCode() : 0);
        return hash;
    }

    public List<FranjaMedicamento> getFranjaMedicamentoList() {
        return franjaMedicamentoList;
    }

    public void setFranjaMedicamentoList(List<FranjaMedicamento> franjaMedicamentoList) {
        this.franjaMedicamentoList = franjaMedicamentoList;
    }


}
