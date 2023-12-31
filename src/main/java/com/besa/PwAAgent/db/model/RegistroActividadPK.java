
package com.besa.PwAAgent.db.model;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Embeddable
public class RegistroActividadPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "perfil_pwa_cedula")
    private String PwAProfileCedula;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "actividad_pwa_id")
    private int actividadPwaId;

    public RegistroActividadPK() {
    }

    public RegistroActividadPK(Date fecha, String PwAProfileCedula, String tipo, int actividadPwaId) {
        this.fecha = fecha;
        this.PwAProfileCedula = PwAProfileCedula;
        this.tipo = tipo;
        this.actividadPwaId = actividadPwaId;
    }
    public RegistroActividadPK(Date fecha,  String tipo) {
        this.fecha = fecha;
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPwAProfileCedula() {
        return PwAProfileCedula;
    }

    public void setPwAProfileCedula(String PwAProfileCedula) {
        this.PwAProfileCedula = PwAProfileCedula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getActividadPwaId() {
        return actividadPwaId;
    }

    public void setActividadPwaId(int actividadPwaId) {
        this.actividadPwaId = actividadPwaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (PwAProfileCedula != null ? PwAProfileCedula.hashCode() : 0);
        hash += (tipo != null ? tipo.hashCode() : 0);
        hash += (int) actividadPwaId;
        return hash;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.RegistroActividadPK[ fecha=" + fecha + ", PwAProfileCedula=" + PwAProfileCedula + ", tipo=" + tipo + ", actividadPwaId=" + actividadPwaId + " ]";
    }
    
}
