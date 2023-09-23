
package com.besa.PwAAgent.db.model;

import java.io.Serializable;
import java.util.Date;

import com.besa.PwAAgent.db.model.userprofile.PerfilPwa;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;



@Entity
@Table(name = "registro_actividad")

@NamedQueries({
    @NamedQuery(name = "RegistroActividad.findAll", query = "SELECT r FROM RegistroActividad r"),
    @NamedQuery(name = "RegistroActividad.findByFecha", query = "SELECT r FROM RegistroActividad r WHERE r.registroActividadPK.fecha = :fecha"),
    @NamedQuery(name = "RegistroActividad.findByPerfilPwaCedula", query = "SELECT r FROM RegistroActividad r WHERE r.registroActividadPK.perfilPwaCedula = :perfilPwaCedula"),
    @NamedQuery(name = "RegistroActividad.findByTipo", query = "SELECT r FROM RegistroActividad r WHERE r.registroActividadPK.tipo = :tipo"),
    @NamedQuery(name = "RegistroActividad.findByEstadoInicial", query = "SELECT r FROM RegistroActividad r WHERE r.estadoInicial = :estadoInicial"),
    @NamedQuery(name = "RegistroActividad.findByEstadoFinal", query = "SELECT r FROM RegistroActividad r WHERE r.estadoFinal = :estadoFinal"),
    @NamedQuery(name = "RegistroActividad.findByActividadPwaId", query = "SELECT r FROM RegistroActividad r WHERE r.registroActividadPK.actividadPwaId = :actividadPwaId")})
public class RegistroActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RegistroActividadPK registroActividadPK;
    @Basic(optional = false)
    @Column(name = "estado_inicial")
    private String estadoInicial;
    @Basic(optional = false)
    @Column(name = "estado_final")
    private String estadoFinal;
    @JoinColumn(name = "actividad_pwa_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ActividadPwa actividadPwa;
    @JoinColumn(name = "perfil_pwa_cedula", referencedColumnName = "cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PerfilPwa perfilPwa;

    public RegistroActividad() {
    }

    public RegistroActividad(RegistroActividadPK registroActividadPK) {
        this.registroActividadPK = registroActividadPK;
    }

    public RegistroActividad(RegistroActividadPK registroActividadPK, String estadoInicial, String estadoFinal) {
        this.registroActividadPK = registroActividadPK;
        this.estadoInicial = estadoInicial;
        this.estadoFinal = estadoFinal;
    }

    public RegistroActividad(Date fecha, String perfilPwaCedula, String tipo, int actividadPwaId) {
        this.registroActividadPK = new RegistroActividadPK(fecha, perfilPwaCedula, tipo, actividadPwaId);
    }

    public RegistroActividadPK getRegistroActividadPK() {
        return registroActividadPK;
    }

    public void setRegistroActividadPK(RegistroActividadPK registroActividadPK) {
        this.registroActividadPK = registroActividadPK;
    }

    public String getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(String estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public String getEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(String estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    public ActividadPwa getActividadPwa() {
        return actividadPwa;
    }

    public void setActividadPwa(ActividadPwa actividadPwa) {
        this.actividadPwa = actividadPwa;
    }

    public PerfilPwa getPerfilPwa() {
        return perfilPwa;
    }

    public void setPerfilPwa(PerfilPwa perfilPwa) {
        this.perfilPwa = perfilPwa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (registroActividadPK != null ? registroActividadPK.hashCode() : 0);
        return hash;
    }
}
