
package com.besa.PwAAgent.db.model;

import java.io.Serializable;
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
@Table(name = "dia_x_programa_ejercicio")

@NamedQueries({
    @NamedQuery(name = "DiaXProgramaEjercicio.findAll", query = "SELECT d FROM DiaXProgramaEjercicio d"),
    @NamedQuery(name = "DiaXProgramaEjercicio.findByDiaNombre", query = "SELECT d FROM DiaXProgramaEjercicio d WHERE d.diaXProgramaEjercicioPK.diaNombre = :diaNombre"),
    @NamedQuery(name = "DiaXProgramaEjercicio.findByProgramaEjercicioNombre", query = "SELECT d FROM DiaXProgramaEjercicio d WHERE d.diaXProgramaEjercicioPK.programaEjercicioNombre = :programaEjercicioNombre"),
    @NamedQuery(name = "DiaXProgramaEjercicio.findByIndiceOrden", query = "SELECT d FROM DiaXProgramaEjercicio d WHERE d.indiceOrden = :indiceOrden")})
public class DiaXProgramaEjercicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiaXProgramaEjercicioPK diaXProgramaEjercicioPK;
    @Basic(optional = false)
    @Column(name = "indice_orden")
    private int indiceOrden;
    @JoinColumn(name = "dia_nombre", referencedColumnName = "nombre", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Dia dia;
    @JoinColumn(name = "programa_ejercicio_nombre", referencedColumnName = "nombre", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ProgramaEjercicio programaEjercicio;

    public DiaXProgramaEjercicio() {
    }

    public DiaXProgramaEjercicio(DiaXProgramaEjercicioPK diaXProgramaEjercicioPK) {
        this.diaXProgramaEjercicioPK = diaXProgramaEjercicioPK;
    }

    public DiaXProgramaEjercicio(DiaXProgramaEjercicioPK diaXProgramaEjercicioPK, int indiceOrden) {
        this.diaXProgramaEjercicioPK = diaXProgramaEjercicioPK;
        this.indiceOrden = indiceOrden;
    }

    public DiaXProgramaEjercicio(String diaNombre, String programaEjercicioNombre) {
        this.diaXProgramaEjercicioPK = new DiaXProgramaEjercicioPK(diaNombre, programaEjercicioNombre);
    }

    public DiaXProgramaEjercicioPK getDiaXProgramaEjercicioPK() {
        return diaXProgramaEjercicioPK;
    }

    public void setDiaXProgramaEjercicioPK(DiaXProgramaEjercicioPK diaXProgramaEjercicioPK) {
        this.diaXProgramaEjercicioPK = diaXProgramaEjercicioPK;
    }

    public int getIndiceOrden() {
        return indiceOrden;
    }

    public void setIndiceOrden(int indiceOrden) {
        this.indiceOrden = indiceOrden;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public ProgramaEjercicio getProgramaEjercicio() {
        return programaEjercicio;
    }

    public void setProgramaEjercicio(ProgramaEjercicio programaEjercicio) {
        this.programaEjercicio = programaEjercicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diaXProgramaEjercicioPK != null ? diaXProgramaEjercicioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof DiaXProgramaEjercicio)) {
            return false;
        }
        DiaXProgramaEjercicio other = (DiaXProgramaEjercicio) object;
        if ((this.diaXProgramaEjercicioPK == null && other.diaXProgramaEjercicioPK != null) || (this.diaXProgramaEjercicioPK != null && !this.diaXProgramaEjercicioPK.equals(other.diaXProgramaEjercicioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.DiaXProgramaEjercicio[ diaXProgramaEjercicioPK=" + diaXProgramaEjercicioPK + " ]";
    }
    
}
