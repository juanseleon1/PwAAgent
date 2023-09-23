
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
@Table(name = "dia_x_categoria_entrenamiento")

@NamedQueries({
    @NamedQuery(name = "DiaXCategoriaEntrenamiento.findAll", query = "SELECT d FROM DiaXCategoriaEntrenamiento d"),
    @NamedQuery(name = "DiaXCategoriaEntrenamiento.findByDiaNombre", query = "SELECT d FROM DiaXCategoriaEntrenamiento d WHERE d.diaXCategoriaEntrenamientoPK.diaNombre = :diaNombre"),
    @NamedQuery(name = "DiaXCategoriaEntrenamiento.findByCategoriaTipo", query = "SELECT d FROM DiaXCategoriaEntrenamiento d WHERE d.diaXCategoriaEntrenamientoPK.categoriaTipo = :categoriaTipo"),
    @NamedQuery(name = "DiaXCategoriaEntrenamiento.findByIndiceOrden", query = "SELECT d FROM DiaXCategoriaEntrenamiento d WHERE d.diaXCategoriaEntrenamientoPK.indiceOrden = :indiceOrden"),
    @NamedQuery(name = "DiaXCategoriaEntrenamiento.findByOpcional", query = "SELECT d FROM DiaXCategoriaEntrenamiento d WHERE d.opcional = :opcional")})
public class DiaXCategoriaEntrenamiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiaXCategoriaEntrenamientoPK diaXCategoriaEntrenamientoPK;
    @Basic(optional = false)
    @Column(name = "opcional")
    private boolean opcional;
    @JoinColumn(name = "categoria_tipo", referencedColumnName = "tipo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CategoriaEntrenamiento categoriaEntrenamiento;
    @JoinColumn(name = "dia_nombre", referencedColumnName = "nombre", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Dia dia;

    public DiaXCategoriaEntrenamiento() {
    }

    public DiaXCategoriaEntrenamiento(DiaXCategoriaEntrenamientoPK diaXCategoriaEntrenamientoPK) {
        this.diaXCategoriaEntrenamientoPK = diaXCategoriaEntrenamientoPK;
    }

    public DiaXCategoriaEntrenamiento(DiaXCategoriaEntrenamientoPK diaXCategoriaEntrenamientoPK, boolean opcional) {
        this.diaXCategoriaEntrenamientoPK = diaXCategoriaEntrenamientoPK;
        this.opcional = opcional;
    }

    public DiaXCategoriaEntrenamiento(String diaNombre, String categoriaTipo, int indiceOrden) {
        this.diaXCategoriaEntrenamientoPK = new DiaXCategoriaEntrenamientoPK(diaNombre, categoriaTipo, indiceOrden);
    }

    public DiaXCategoriaEntrenamientoPK getDiaXCategoriaEntrenamientoPK() {
        return diaXCategoriaEntrenamientoPK;
    }

    public void setDiaXCategoriaEntrenamientoPK(DiaXCategoriaEntrenamientoPK diaXCategoriaEntrenamientoPK) {
        this.diaXCategoriaEntrenamientoPK = diaXCategoriaEntrenamientoPK;
    }

    public boolean getOpcional() {
        return opcional;
    }

    public void setOpcional(boolean opcional) {
        this.opcional = opcional;
    }

    public CategoriaEntrenamiento getCategoriaEntrenamiento() {
        return categoriaEntrenamiento;
    }

    public void setCategoriaEntrenamiento(CategoriaEntrenamiento categoriaEntrenamiento) {
        this.categoriaEntrenamiento = categoriaEntrenamiento;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diaXCategoriaEntrenamientoPK != null ? diaXCategoriaEntrenamientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof DiaXCategoriaEntrenamiento)) {
            return false;
        }
        DiaXCategoriaEntrenamiento other = (DiaXCategoriaEntrenamiento) object;
        if ((this.diaXCategoriaEntrenamientoPK == null && other.diaXCategoriaEntrenamientoPK != null) || (this.diaXCategoriaEntrenamientoPK != null && !this.diaXCategoriaEntrenamientoPK.equals(other.diaXCategoriaEntrenamientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BESA.PwARobot.DBConnection.SREntities.DiaXCategoriaEntrenamiento[ diaXCategoriaEntrenamientoPK=" + diaXCategoriaEntrenamientoPK + " ]";
    }
    
}
